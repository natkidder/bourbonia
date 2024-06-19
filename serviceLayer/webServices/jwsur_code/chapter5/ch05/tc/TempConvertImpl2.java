package ch05.tc;

import javax.jws.WebService;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;
import java.util.Map;
import java.util.List;

@WebService(endpointInterface = "ch05.tc.TempConvert")
public class TempConvertImpl2 implements TempConvert {
    @Resource
    WebServiceContext ws_ctx;

    public float c2f(float t) {
        if (authenticated()) return 32.0f + (t * 9.0f / 5.0f);
        else throw new HTTPException(401); // authorization error
    }

    public float f2c(float t) {
        if (authenticated()) return (5.0f / 9.0f) * (t - 32.0f);
        else throw new HTTPException(401); // authorization error
    }

    private boolean authenticated() {
        MessageContext mctx = ws_ctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List ulist = (List) http_headers.get("Username");
        List plist = (List) http_headers.get("Password");

        // proof of concept authentication
        if (ulist.contains("fred") && plist.contains("rockbed")) return true;
        else return false;
    }
}

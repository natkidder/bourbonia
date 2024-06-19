package ch05.authrest;

import javax.xml.ws.Provider;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.annotation.Resource;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.http.HTTPBinding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.beans.XMLEncoder;
import java.util.List;
import java.util.ArrayList;

@WebServiceProvider
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class TempConvertR implements Provider<Source> {
    @Resource
    protected WebServiceContext ws_ctx;

    public Source invoke(Source request) {
        // Grab the message context and extract the request verb.
        MessageContext msg_ctx = ws_ctx.getMessageContext();
        String http_verb = (String)
            msg_ctx.get(MessageContext.HTTP_REQUEST_METHOD);
        http_verb = http_verb.trim().toUpperCase();

        if (http_verb.equals("GET")) return doGet(msg_ctx);
        else throw new HTTPException(405); // bad verb exception
    }

    private Source doGet(MessageContext msg_ctx) {
        String query_string = (String) msg_ctx.get(MessageContext.QUERY_STRING);
        if (query_string == null) throw new HTTPException(400); // bad request

        String temp = get_value_from_qs("temp", query_string);
        if (temp == null) throw new HTTPException(400); // bad request
        
        List<String> converts = new ArrayList<String>();
        try {
            float f = Float.parseFloat(temp.trim());
            float f2c = f2c(f);
            float c2f = c2f(f);
            converts.add(f2c + "C");
            converts.add(c2f + "F");
        }
        catch (NumberFormatException e) { throw new HTTPException(400); }

        // Generate XML and return.
        ByteArrayInputStream stream = encode_to_stream(converts);
        return new StreamSource(stream);
    }

    private String get_value_from_qs(String key, String qs) {
        String[ ] parts = qs.split("=");
        if (!parts[0].equalsIgnoreCase(key))
            throw new HTTPException(400); // bad request
        return parts[1].trim();
    }

    private ByteArrayInputStream encode_to_stream(Object obj) {
       // Serialize object to XML and return
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        XMLEncoder enc = new XMLEncoder(stream);
        enc.writeObject(obj);
        enc.close();
        return new ByteArrayInputStream(stream.toByteArray());
    }
    private float c2f(float t) { return 32.0f + (t * 9.0f / 5.0f); }
    private float f2c(float t) { return (5.0f / 9.0f) * (t - 32.0f); }
}
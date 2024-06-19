package ch05.tcauth;

import javax.jws.WebService;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;
import java.util.Map;
import java.util.List;

@WebService(endpointInterface = "ch05.tcauth.TempConvertAuth")
public class TempConvertAuthImpl implements TempConvertAuth {
    public float c2f(float t) { 
	return 32.0f + (t * 9.0f / 5.0f);
    }

    public float f2c(float t) { 
	return (5.0f / 9.0f) * (t - 32.0f); 
    }
}



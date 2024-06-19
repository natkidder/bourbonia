import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import echoC.EchoService;
import echoC.Echo;

class EchoClient {
   public static void main(String[ ] args) {
      EchoService service = new EchoService();
      Echo port = service.getEchoPort();

      Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();

      // Sample invocation: 
      //
      // % java EchoClient http://localhost:9797 echo
      //
      // 1st command-line argument ends with serivce location port number
      // 2nd command-line argument is the service operation
      if (args.length >= 2) { 
         // Endpoint address becomes: http://localhost:9797/echo
         req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                         args[0] + "/" + args[1]);
         // SOAP action becomes: echo
         req_ctx.put(BindingProvider.SOAPACTION_URI_PROPERTY, args[1]);
      }
      // Add some application-specific HTTP headers
      Map<String, List<String>> my_header = new HashMap<String, List<String>>();
      my_header.put("Accept-Encoding", Collections.singletonList("gzip"));
      my_header.put("Greeting", Collections.singletonList("Hello, world!"));

      // Insert customized headers into HTTP message headers
      req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, my_header);

      dump_map(req_ctx, "");
      System.out.println("\n\nRequest above, response below\n\n");

      // Invoke service operation to generate an HTTP response.
      String response = port.echo("Have a nice day :)");

      Map<String, Object> res_ctx = ((BindingProvider) port).getResponseContext();
      dump_map(res_ctx, "");

      Object response_code = res_ctx.get(MessageContext.HTTP_RESPONSE_CODE);
   }

   private static void dump_map(Map map, String indent) {
      Set keys = map.keySet();
      for (Object key : keys) {
        System.out.println(indent + key + " ==> " + map.get(key));
        if (map.get(key) instanceof Map)
          dump_map((Map) map.get(key), indent += "   ");
      }
   }
}

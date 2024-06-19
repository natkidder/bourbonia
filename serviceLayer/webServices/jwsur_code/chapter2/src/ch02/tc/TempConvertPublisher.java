package ch02.tc;

import javax.xml.ws.Endpoint;

public class TempConvertPublisher {
    public static void main(String[ ] args) {
      Endpoint.publish("http://127.0.0.1:5599/tc", new TempConvert());
    }
}

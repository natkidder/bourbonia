package ch01.ts;

import java.io.IOException;
import java.net.ServerSocket;
import javax.xml.ws.Endpoint;
import natsUtilities.NatsUtilities;

class TimePublisherMT { // MT for multithreaded
    private Endpoint endpoint;
    private static final int START_PORT = 8200;
    private static final int END_PORT = 8300;

    public static void main(String[ ] args) throws IOException {
    	Esso.pn("TimePublisherMT - main"); ////
        TimePublisherMT self = new TimePublisherMT();
        self.create_endpoint();
        self.configure_endpoint();
        self.publish();
    }
    private void create_endpoint() {
        endpoint = Endpoint.create(new TimeServerImpl());
    }
    private void configure_endpoint() {
        endpoint.setExecutor(new MyThreadPool());
    }
    private void publish() throws IOException {
        ServerSocket socket = null;
        int port = NatsUtilities.getFreePort(START_PORT, END_PORT);
    	for (int i = START_PORT ; i <= END_PORT; i++) {
            try {
    			socket = new ServerSocket(i);
    			if (socket != null)  {
    				port = i;
    				break; 
    				}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			continue;
     		}    		
    	}
        String url = "http://localhost:" + port + "/ts";
        endpoint.publish(url);
        System.out.println("Publishing TimeServer on port " + port);


    }
}    

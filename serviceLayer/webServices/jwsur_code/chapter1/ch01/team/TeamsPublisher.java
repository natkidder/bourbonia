package ch01.team;
import javax.xml.ws.Endpoint;
import natsUtilities.NatsUtilities;

class TeamsPublisher {
    private static final int START_PORT = 8200;
    private static final int END_PORT = 8300;

    public static void main(String[ ] args) {
       int port = NatsUtilities.getFreePort(START_PORT, END_PORT);
       String url = "http://localhost:" + port + "/teams";
       System.out.println("Publishing Teams on port " + port);
       Endpoint.publish(url, new Teams());
    }
} 

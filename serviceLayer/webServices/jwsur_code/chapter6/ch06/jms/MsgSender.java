package ch06.jms;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.JMSException;
import javax.annotation.Resource;

// A Web service that sends a message to a queue.
@WebService
public class MsgSender {
    // name and mappedName can differ; mappedName is the JNDI lookup name
    @Resource(name="qcf", mappedName="qcf")
    private QueueConnectionFactory qf;
    @Resource(name="jmsQ", mappedName="jmsQ")
    private Queue queue;

    private QueueConnection conn;

    @WebMethod
    public void send(String msg) {
        try {
            if (conn == null) conn = (QueueConnection) qf.createConnection();
            Session session =
                conn.createSession(false, // no transaction support
                                   Session.AUTO_ACKNOWLEDGE);

            // Wrap the string in a TextMessage for sending.
            TextMessage tmsg = session.createTextMessage(msg);
            session.createProducer(queue).send(tmsg);
            session.close();
        }
        catch(JMSException e) { throw new RuntimeException(e); }
    }
}

package ch06.jms;

import java.util.List;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Session;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.QueueReceiver;
import javax.jms.JMSException;
import javax.annotation.Resource;

@WebService
public class MsgReceiver {
    // name and mappedName can differ
    @Resource(name="qcf", mappedName="qcf")
    private QueueConnectionFactory qf;
    @Resource(name="jmsQ", mappedName="jmsQ")
    private Queue queue;

    private QueueConnection conn;

    @WebMethod
    public String receive() {
        String cliche = null;
        try {
            if (conn == null) conn = qf.createQueueConnection();
            QueueSession session =
                conn.createQueueSession(false,
                                        Session.AUTO_ACKNOWLEDGE);
            QueueReceiver receiver = session.createReceiver(queue);
            conn.start();

            Message msg = receiver.receiveNoWait();
            if (msg != null && msg instanceof TextMessage ) {
                TextMessage tmsg = (TextMessage) msg;
                cliche = tmsg.getText().trim();
            }
        }
        catch(JMSException e) { throw new RuntimeException(e); }
        return cliche;
    }
}

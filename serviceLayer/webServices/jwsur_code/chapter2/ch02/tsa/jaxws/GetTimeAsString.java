
package ch02.tsa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "time_string", namespace = "http://ch02.tsa")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time_string", namespace = "http://ch02.tsa")
public class GetTimeAsString {

    @XmlElement(name = "client_message", namespace = "http://ch02.tsa")
    private String clientMessage;

    /**
     * 
     * @return
     *     returns String
     */
    public String getClientMessage() {
        return this.clientMessage;
    }

    /**
     * 
     * @param clientMessage
     *     the value for the clientMessage property
     */
    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }

}

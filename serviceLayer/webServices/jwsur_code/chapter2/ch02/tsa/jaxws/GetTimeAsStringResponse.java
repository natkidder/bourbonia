
package ch02.tsa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "time_stringResponse", namespace = "http://ch02.tsa")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time_stringResponse", namespace = "http://ch02.tsa")
public class GetTimeAsStringResponse {

    @XmlElement(name = "ts_out", namespace = "http://ch02.tsa")
    private String tsOut;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTsOut() {
        return this.tsOut;
    }

    /**
     * 
     * @param tsOut
     *     the value for the tsOut property
     */
    public void setTsOut(String tsOut) {
        this.tsOut = tsOut;
    }

}

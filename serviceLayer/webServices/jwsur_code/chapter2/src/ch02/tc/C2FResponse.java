
package ch02.tc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "c2fResponse", namespace = "http://tempConvertURI.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "c2fResponse", namespace = "http://tempConvertURI.org/")
public class C2FResponse {

    @XmlElement(name = "c2fResult", namespace = "http://tempConvertURI.org/")
    private double c2FResult;

    /**
     * 
     * @return
     *     returns double
     */
    public double getC2FResult() {
        return this.c2FResult;
    }

    /**
     * 
     * @param c2FResult
     *     the value for the c2FResult property
     */
    public void setC2FResult(double c2FResult) {
        this.c2FResult = c2FResult;
    }

}

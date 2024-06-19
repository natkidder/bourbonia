
package ch02.tc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "f2cResponse", namespace = "http://tempConvertURI.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "f2cResponse", namespace = "http://tempConvertURI.org/")
public class F2CResponse {

    @XmlElement(name = "f2cResult", namespace = "http://tempConvertURI.org/")
    private double f2CResult;

    /**
     * 
     * @return
     *     returns double
     */
    public double getF2CResult() {
        return this.f2CResult;
    }

    /**
     * 
     * @param f2CResult
     *     the value for the f2CResult property
     */
    public void setF2CResult(double f2CResult) {
        this.f2CResult = f2CResult;
    }

}

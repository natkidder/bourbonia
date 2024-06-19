
package ch02.tc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "c2f", namespace = "http://tempConvertURI.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "c2f", namespace = "http://tempConvertURI.org/")
public class C2F {

    @XmlElement(name = "t", namespace = "http://tempConvertURI.org/")
    private double t;

    /**
     * 
     * @return
     *     returns double
     */
    public double getT() {
        return this.t;
    }

    /**
     * 
     * @param t
     *     the value for the t property
     */
    public void setT(double t) {
        this.t = t;
    }

}

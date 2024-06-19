
package ch03.image.jaxws;

import java.awt.Image;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getImagesResponse", namespace = "http://image.ch03/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getImagesResponse", namespace = "http://image.ch03/")
public class GetImagesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Image> _return;

    /**
     * 
     * @return
     *     returns List<Image>
     */
    public List<Image> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Image> _return) {
        this._return = _return;
    }

}

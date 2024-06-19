/**
 * WeeklyIndex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class WeeklyIndex  implements java.io.Serializable {
    private java.lang.String indexDate;

    private java.lang.String oneYearConstantMaturityTreasury;

    private java.lang.String threeYearConstantMaturityTreasury;

    private java.lang.String fiveYearConstantMaturityTreasury;

    private java.lang.String threeMonthTreasuryBill;

    private java.lang.String sixMonthTreasuryBill;

    private java.lang.String threeMonthSecondaryMarketCD;

    public WeeklyIndex() {
    }

    public WeeklyIndex(
           java.lang.String indexDate,
           java.lang.String oneYearConstantMaturityTreasury,
           java.lang.String threeYearConstantMaturityTreasury,
           java.lang.String fiveYearConstantMaturityTreasury,
           java.lang.String threeMonthTreasuryBill,
           java.lang.String sixMonthTreasuryBill,
           java.lang.String threeMonthSecondaryMarketCD) {
           this.indexDate = indexDate;
           this.oneYearConstantMaturityTreasury = oneYearConstantMaturityTreasury;
           this.threeYearConstantMaturityTreasury = threeYearConstantMaturityTreasury;
           this.fiveYearConstantMaturityTreasury = fiveYearConstantMaturityTreasury;
           this.threeMonthTreasuryBill = threeMonthTreasuryBill;
           this.sixMonthTreasuryBill = sixMonthTreasuryBill;
           this.threeMonthSecondaryMarketCD = threeMonthSecondaryMarketCD;
    }


    /**
     * Gets the indexDate value for this WeeklyIndex.
     * 
     * @return indexDate
     */
    public java.lang.String getIndexDate() {
        return indexDate;
    }


    /**
     * Sets the indexDate value for this WeeklyIndex.
     * 
     * @param indexDate
     */
    public void setIndexDate(java.lang.String indexDate) {
        this.indexDate = indexDate;
    }


    /**
     * Gets the oneYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @return oneYearConstantMaturityTreasury
     */
    public java.lang.String getOneYearConstantMaturityTreasury() {
        return oneYearConstantMaturityTreasury;
    }


    /**
     * Sets the oneYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @param oneYearConstantMaturityTreasury
     */
    public void setOneYearConstantMaturityTreasury(java.lang.String oneYearConstantMaturityTreasury) {
        this.oneYearConstantMaturityTreasury = oneYearConstantMaturityTreasury;
    }


    /**
     * Gets the threeYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @return threeYearConstantMaturityTreasury
     */
    public java.lang.String getThreeYearConstantMaturityTreasury() {
        return threeYearConstantMaturityTreasury;
    }


    /**
     * Sets the threeYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @param threeYearConstantMaturityTreasury
     */
    public void setThreeYearConstantMaturityTreasury(java.lang.String threeYearConstantMaturityTreasury) {
        this.threeYearConstantMaturityTreasury = threeYearConstantMaturityTreasury;
    }


    /**
     * Gets the fiveYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @return fiveYearConstantMaturityTreasury
     */
    public java.lang.String getFiveYearConstantMaturityTreasury() {
        return fiveYearConstantMaturityTreasury;
    }


    /**
     * Sets the fiveYearConstantMaturityTreasury value for this WeeklyIndex.
     * 
     * @param fiveYearConstantMaturityTreasury
     */
    public void setFiveYearConstantMaturityTreasury(java.lang.String fiveYearConstantMaturityTreasury) {
        this.fiveYearConstantMaturityTreasury = fiveYearConstantMaturityTreasury;
    }


    /**
     * Gets the threeMonthTreasuryBill value for this WeeklyIndex.
     * 
     * @return threeMonthTreasuryBill
     */
    public java.lang.String getThreeMonthTreasuryBill() {
        return threeMonthTreasuryBill;
    }


    /**
     * Sets the threeMonthTreasuryBill value for this WeeklyIndex.
     * 
     * @param threeMonthTreasuryBill
     */
    public void setThreeMonthTreasuryBill(java.lang.String threeMonthTreasuryBill) {
        this.threeMonthTreasuryBill = threeMonthTreasuryBill;
    }


    /**
     * Gets the sixMonthTreasuryBill value for this WeeklyIndex.
     * 
     * @return sixMonthTreasuryBill
     */
    public java.lang.String getSixMonthTreasuryBill() {
        return sixMonthTreasuryBill;
    }


    /**
     * Sets the sixMonthTreasuryBill value for this WeeklyIndex.
     * 
     * @param sixMonthTreasuryBill
     */
    public void setSixMonthTreasuryBill(java.lang.String sixMonthTreasuryBill) {
        this.sixMonthTreasuryBill = sixMonthTreasuryBill;
    }


    /**
     * Gets the threeMonthSecondaryMarketCD value for this WeeklyIndex.
     * 
     * @return threeMonthSecondaryMarketCD
     */
    public java.lang.String getThreeMonthSecondaryMarketCD() {
        return threeMonthSecondaryMarketCD;
    }


    /**
     * Sets the threeMonthSecondaryMarketCD value for this WeeklyIndex.
     * 
     * @param threeMonthSecondaryMarketCD
     */
    public void setThreeMonthSecondaryMarketCD(java.lang.String threeMonthSecondaryMarketCD) {
        this.threeMonthSecondaryMarketCD = threeMonthSecondaryMarketCD;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WeeklyIndex)) return false;
        WeeklyIndex other = (WeeklyIndex) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indexDate==null && other.getIndexDate()==null) || 
             (this.indexDate!=null &&
              this.indexDate.equals(other.getIndexDate()))) &&
            ((this.oneYearConstantMaturityTreasury==null && other.getOneYearConstantMaturityTreasury()==null) || 
             (this.oneYearConstantMaturityTreasury!=null &&
              this.oneYearConstantMaturityTreasury.equals(other.getOneYearConstantMaturityTreasury()))) &&
            ((this.threeYearConstantMaturityTreasury==null && other.getThreeYearConstantMaturityTreasury()==null) || 
             (this.threeYearConstantMaturityTreasury!=null &&
              this.threeYearConstantMaturityTreasury.equals(other.getThreeYearConstantMaturityTreasury()))) &&
            ((this.fiveYearConstantMaturityTreasury==null && other.getFiveYearConstantMaturityTreasury()==null) || 
             (this.fiveYearConstantMaturityTreasury!=null &&
              this.fiveYearConstantMaturityTreasury.equals(other.getFiveYearConstantMaturityTreasury()))) &&
            ((this.threeMonthTreasuryBill==null && other.getThreeMonthTreasuryBill()==null) || 
             (this.threeMonthTreasuryBill!=null &&
              this.threeMonthTreasuryBill.equals(other.getThreeMonthTreasuryBill()))) &&
            ((this.sixMonthTreasuryBill==null && other.getSixMonthTreasuryBill()==null) || 
             (this.sixMonthTreasuryBill!=null &&
              this.sixMonthTreasuryBill.equals(other.getSixMonthTreasuryBill()))) &&
            ((this.threeMonthSecondaryMarketCD==null && other.getThreeMonthSecondaryMarketCD()==null) || 
             (this.threeMonthSecondaryMarketCD!=null &&
              this.threeMonthSecondaryMarketCD.equals(other.getThreeMonthSecondaryMarketCD())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIndexDate() != null) {
            _hashCode += getIndexDate().hashCode();
        }
        if (getOneYearConstantMaturityTreasury() != null) {
            _hashCode += getOneYearConstantMaturityTreasury().hashCode();
        }
        if (getThreeYearConstantMaturityTreasury() != null) {
            _hashCode += getThreeYearConstantMaturityTreasury().hashCode();
        }
        if (getFiveYearConstantMaturityTreasury() != null) {
            _hashCode += getFiveYearConstantMaturityTreasury().hashCode();
        }
        if (getThreeMonthTreasuryBill() != null) {
            _hashCode += getThreeMonthTreasuryBill().hashCode();
        }
        if (getSixMonthTreasuryBill() != null) {
            _hashCode += getSixMonthTreasuryBill().hashCode();
        }
        if (getThreeMonthSecondaryMarketCD() != null) {
            _hashCode += getThreeMonthSecondaryMarketCD().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WeeklyIndex.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "WeeklyIndex"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indexDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "IndexDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oneYearConstantMaturityTreasury");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "OneYearConstantMaturityTreasury"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threeYearConstantMaturityTreasury");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "ThreeYearConstantMaturityTreasury"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fiveYearConstantMaturityTreasury");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "FiveYearConstantMaturityTreasury"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threeMonthTreasuryBill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "ThreeMonthTreasuryBill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sixMonthTreasuryBill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "SixMonthTreasuryBill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threeMonthSecondaryMarketCD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "ThreeMonthSecondaryMarketCD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

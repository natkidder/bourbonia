/**
 * TimeMetric.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.csapi.www.schema.parlayx.common.v2_1;

public class TimeMetric  implements java.io.Serializable {
    private org.csapi.www.schema.parlayx.common.v3_0.TimeMetrics metric;

    private int units;

    public TimeMetric() {
    }

    public TimeMetric(
           org.csapi.www.schema.parlayx.common.v3_0.TimeMetrics metric,
           int units) {
           this.metric = metric;
           this.units = units;
    }


    /**
     * Gets the metric value for this TimeMetric.
     * 
     * @return metric
     */
    public org.csapi.www.schema.parlayx.common.v3_0.TimeMetrics getMetric() {
        return metric;
    }


    /**
     * Sets the metric value for this TimeMetric.
     * 
     * @param metric
     */
    public void setMetric(org.csapi.www.schema.parlayx.common.v3_0.TimeMetrics metric) {
        this.metric = metric;
    }


    /**
     * Gets the units value for this TimeMetric.
     * 
     * @return units
     */
    public int getUnits() {
        return units;
    }


    /**
     * Sets the units value for this TimeMetric.
     * 
     * @param units
     */
    public void setUnits(int units) {
        this.units = units;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimeMetric)) return false;
        TimeMetric other = (TimeMetric) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metric==null && other.getMetric()==null) || 
             (this.metric!=null &&
              this.metric.equals(other.getMetric()))) &&
            this.units == other.getUnits();
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
        if (getMetric() != null) {
            _hashCode += getMetric().hashCode();
        }
        _hashCode += getUnits();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeMetric.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metric");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "metric"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v3_0", "TimeMetrics"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("units");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "units"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

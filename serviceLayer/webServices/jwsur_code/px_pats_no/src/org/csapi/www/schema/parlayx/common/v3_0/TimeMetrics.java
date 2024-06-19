/**
 * TimeMetrics.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.csapi.www.schema.parlayx.common.v3_0;

public class TimeMetrics implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TimeMetrics(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Millisecond = "Millisecond";
    public static final java.lang.String _Second = "Second";
    public static final java.lang.String _Minute = "Minute";
    public static final java.lang.String _Hour = "Hour";
    public static final java.lang.String _Day = "Day";
    public static final java.lang.String _Week = "Week";
    public static final java.lang.String _Month = "Month";
    public static final java.lang.String _Year = "Year";
    public static final TimeMetrics Millisecond = new TimeMetrics(_Millisecond);
    public static final TimeMetrics Second = new TimeMetrics(_Second);
    public static final TimeMetrics Minute = new TimeMetrics(_Minute);
    public static final TimeMetrics Hour = new TimeMetrics(_Hour);
    public static final TimeMetrics Day = new TimeMetrics(_Day);
    public static final TimeMetrics Week = new TimeMetrics(_Week);
    public static final TimeMetrics Month = new TimeMetrics(_Month);
    public static final TimeMetrics Year = new TimeMetrics(_Year);
    public java.lang.String getValue() { return _value_;}
    public static TimeMetrics fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TimeMetrics enumeration = (TimeMetrics)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TimeMetrics fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeMetrics.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v3_0", "TimeMetrics"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

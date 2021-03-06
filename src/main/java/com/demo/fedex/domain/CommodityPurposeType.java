
package com.demo.fedex.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommodityPurposeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommodityPurposeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BUSINESS"/>
 *     &lt;enumeration value="CONSUMER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommodityPurposeType")
@XmlEnum
public enum CommodityPurposeType {

    BUSINESS,
    CONSUMER;

    public String value() {
        return name();
    }

    public static CommodityPurposeType fromValue(String v) {
        return valueOf(v);
    }

}

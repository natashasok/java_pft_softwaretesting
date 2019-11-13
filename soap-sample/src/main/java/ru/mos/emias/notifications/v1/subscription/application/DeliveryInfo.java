
package ru.mos.emias.notifications.v1.subscription.application;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация по доставке уведомлений
 * 
 * <p>Java class for DeliveryInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deliveryMethodId" type="{http://emias.mos.ru/notifications/v1/subscription/application/}ID"/&gt;
 *         &lt;element name="deliveryDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parameters" type="{http://emias.mos.ru/notifications/v1/subscription/application/}KeyValuePair" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryInfo", propOrder = {
    "deliveryMethodId",
    "deliveryDetails",
    "parameters"
})
public class DeliveryInfo {

    protected long deliveryMethodId;
    protected String deliveryDetails;
    protected List<KeyValuePair> parameters;

    /**
     * Gets the value of the deliveryMethodId property.
     * 
     */
    public long getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * Sets the value of the deliveryMethodId property.
     * 
     */
    public void setDeliveryMethodId(long value) {
        this.deliveryMethodId = value;
    }

    /**
     * Gets the value of the deliveryDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    /**
     * Sets the value of the deliveryDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryDetails(String value) {
        this.deliveryDetails = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePair }
     * 
     * 
     */
    public List<KeyValuePair> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<KeyValuePair>();
        }
        return this.parameters;
    }

}

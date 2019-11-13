
package ru.mos.emias.notifications.v1.subscription.application;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип подписки
 * 
 * <p>Java class for SubscriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="subscriptionTypeId" type="{http://emias.mos.ru/notifications/v1/subscription/application/}ID"/&gt;
 *         &lt;element name="deliveryInfos" type="{http://emias.mos.ru/notifications/v1/subscription/application/}DeliveryInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionType", propOrder = {
    "subscriptionTypeId",
    "deliveryInfos"
})
public class SubscriptionType {

    protected long subscriptionTypeId;
    protected List<DeliveryInfo> deliveryInfos;

    /**
     * Gets the value of the subscriptionTypeId property.
     * 
     */
    public long getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    /**
     * Sets the value of the subscriptionTypeId property.
     * 
     */
    public void setSubscriptionTypeId(long value) {
        this.subscriptionTypeId = value;
    }

    /**
     * Gets the value of the deliveryInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryInfo }
     * 
     * 
     */
    public List<DeliveryInfo> getDeliveryInfos() {
        if (deliveryInfos == null) {
            deliveryInfos = new ArrayList<DeliveryInfo>();
        }
        return this.deliveryInfos;
    }

}

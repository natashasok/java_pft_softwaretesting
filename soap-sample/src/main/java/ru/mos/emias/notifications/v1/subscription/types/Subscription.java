
package ru.mos.emias.notifications.v1.subscription.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.mos.emias.notifications.v1.subscription.application.ApplicantDocument;
import ru.mos.emias.notifications.v1.subscription.application.SubscriptionType;


/**
 * Инфомация о подписке
 * 
 * <p>Java class for Subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subscription"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://emias.mos.ru/notifications/v1/subscription/types/}ID"/&gt;
 *         &lt;element name="patientId" type="{http://emias.mos.ru/notifications/v1/common/types/}EmiasId"/&gt;
 *         &lt;element name="availableUntil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="types" type="{http://emias.mos.ru/notifications/v1/subscription/application/}SubscriptionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="documents" type="{http://emias.mos.ru/notifications/v1/subscription/application/}ApplicantDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parameters" type="{http://emias.mos.ru/notifications/v1/subscription/types/}KeyValuePair" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription", propOrder = {
    "id",
    "patientId",
    "availableUntil",
    "types",
    "documents",
    "parameters"
})
public class Subscription {

    protected long id;
    protected long patientId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar availableUntil;
    protected List<SubscriptionType> types;
    protected List<ApplicantDocument> documents;
    protected List<KeyValuePair> parameters;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     */
    public long getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     */
    public void setPatientId(long value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the availableUntil property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAvailableUntil() {
        return availableUntil;
    }

    /**
     * Sets the value of the availableUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAvailableUntil(XMLGregorianCalendar value) {
        this.availableUntil = value;
    }

    /**
     * Gets the value of the types property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the types property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscriptionType }
     * 
     * 
     */
    public List<SubscriptionType> getTypes() {
        if (types == null) {
            types = new ArrayList<SubscriptionType>();
        }
        return this.types;
    }

    /**
     * Gets the value of the documents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicantDocument }
     * 
     * 
     */
    public List<ApplicantDocument> getDocuments() {
        if (documents == null) {
            documents = new ArrayList<ApplicantDocument>();
        }
        return this.documents;
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


package ru.mos.emias.notifications.v1.subscription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.mos.emias.notifications.v1.subscription.application.ApplicantDocument;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applicantDocument" type="{http://emias.mos.ru/notifications/v1/subscription/application/}ApplicantDocument"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applicantDocument"
})
@XmlRootElement(name = "GetApplicantSubscriptionsRequest")
public class GetApplicantSubscriptionsRequest {

    @XmlElement(required = true)
    protected ApplicantDocument applicantDocument;

    /**
     * Gets the value of the applicantDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicantDocument }
     *     
     */
    public ApplicantDocument getApplicantDocument() {
        return applicantDocument;
    }

    /**
     * Sets the value of the applicantDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicantDocument }
     *     
     */
    public void setApplicantDocument(ApplicantDocument value) {
        this.applicantDocument = value;
    }

}

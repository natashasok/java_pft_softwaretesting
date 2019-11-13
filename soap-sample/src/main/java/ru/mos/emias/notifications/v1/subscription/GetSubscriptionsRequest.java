
package ru.mos.emias.notifications.v1.subscription;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="patientId" type="{http://emias.mos.ru/notifications/v1/common/types/}EmiasId"/&gt;
 *         &lt;element name="applicantDocuments" type="{http://emias.mos.ru/notifications/v1/subscription/application/}ApplicantDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "patientId",
    "applicantDocuments"
})
@XmlRootElement(name = "GetSubscriptionsRequest")
public class GetSubscriptionsRequest {

    protected long patientId;
    protected List<ApplicantDocument> applicantDocuments;

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
    public GetSubscriptionsRequest setPatientId(long value) {
        this.patientId = value;
        return null;
    }

    /**
     * Gets the value of the applicantDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicantDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicantDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApplicantDocument }
     * 
     * 
     */
    public List<ApplicantDocument> getApplicantDocuments() {
        if (applicantDocuments == null) {
            applicantDocuments = new ArrayList<ApplicantDocument>();
        }
        return this.applicantDocuments;
    }

}

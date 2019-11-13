
package ru.mos.emias.notifications.v1.subscription.application;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mos.emias.notifications.v1.subscription.application package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Application_QNAME = new QName("http://emias.mos.ru/notifications/v1/subscription/application/", "application");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mos.emias.notifications.v1.subscription.application
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApplicantDocument }
     * 
     */
    public ApplicantDocument createApplicantDocument() {
        return new ApplicantDocument();
    }

    /**
     * Create an instance of {@link SubscriptionApplication }
     * 
     */
    public SubscriptionApplication createSubscriptionApplication() {
        return new SubscriptionApplication();
    }

    /**
     * Create an instance of {@link SubscriptionType }
     * 
     */
    public SubscriptionType createSubscriptionType() {
        return new SubscriptionType();
    }

    /**
     * Create an instance of {@link DeliveryInfo }
     * 
     */
    public DeliveryInfo createDeliveryInfo() {
        return new DeliveryInfo();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     * 
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriptionApplication }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubscriptionApplication }{@code >}
     */
    @XmlElementDecl(namespace = "http://emias.mos.ru/notifications/v1/subscription/application/", name = "application")
    public JAXBElement<SubscriptionApplication> createApplication(SubscriptionApplication value) {
        return new JAXBElement<SubscriptionApplication>(_Application_QNAME, SubscriptionApplication.class, null, value);
    }

}

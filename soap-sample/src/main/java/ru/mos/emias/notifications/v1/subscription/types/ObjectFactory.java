
package ru.mos.emias.notifications.v1.subscription.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mos.emias.notifications.v1.subscription.types package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mos.emias.notifications.v1.subscription.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorMessage }
     * 
     */
    public ErrorMessage createErrorMessage() {
        return new ErrorMessage();
    }

    /**
     * Create an instance of {@link Subscription }
     * 
     */
    public Subscription createSubscription() {
        return new Subscription();
    }

    /**
     * Create an instance of {@link SubscriptionType }
     * 
     */
    public SubscriptionType createSubscriptionType() {
        return new SubscriptionType();
    }

    /**
     * Create an instance of {@link ErrorMessageCollection }
     * 
     */
    public ErrorMessageCollection createErrorMessageCollection() {
        return new ErrorMessageCollection();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     * 
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link DeliveryMethod }
     * 
     */
    public DeliveryMethod createDeliveryMethod() {
        return new DeliveryMethod();
    }

    /**
     * Create an instance of {@link ErrorMessage.Parameters }
     * 
     */
    public ErrorMessage.Parameters createErrorMessageParameters() {
        return new ErrorMessage.Parameters();
    }

}

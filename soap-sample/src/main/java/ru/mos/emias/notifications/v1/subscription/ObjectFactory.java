
package ru.mos.emias.notifications.v1.subscription;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mos.emias.notifications.v1.subscription package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mos.emias.notifications.v1.subscription
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSubscriptionsRequest }
     * 
     */
    public GetSubscriptionsRequest createGetSubscriptionsRequest() {
        return new GetSubscriptionsRequest();
    }

    /**
     * Create an instance of {@link GetSubscriptionsResponse }
     * 
     */
    public GetSubscriptionsResponse createGetSubscriptionsResponse() {
        return new GetSubscriptionsResponse();
    }

    /**
     * Create an instance of {@link GetApplicantSubscriptionsRequest }
     * 
     */
    public GetApplicantSubscriptionsRequest createGetApplicantSubscriptionsRequest() {
        return new GetApplicantSubscriptionsRequest();
    }

    /**
     * Create an instance of {@link GetApplicantSubscriptionsResponse }
     * 
     */
    public GetApplicantSubscriptionsResponse createGetApplicantSubscriptionsResponse() {
        return new GetApplicantSubscriptionsResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionTypesRequest }
     * 
     */
    public GetSubscriptionTypesRequest createGetSubscriptionTypesRequest() {
        return new GetSubscriptionTypesRequest();
    }

    /**
     * Create an instance of {@link GetSubscriptionTypesResponse }
     * 
     */
    public GetSubscriptionTypesResponse createGetSubscriptionTypesResponse() {
        return new GetSubscriptionTypesResponse();
    }

}

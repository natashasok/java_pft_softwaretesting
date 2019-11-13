package ru.stqa.pft.soap;

import org.testng.annotations.Test;
import ru.mos.emias.notifications.v1.subscription.*;
import ru.mos.emias.notifications.v1.subscription.soap.SubscriptionService;

public class TestSoapUI {
  @Test
  public void testGetSubscription() throws Fault {
    long patientId= 10845684;
    GetSubscriptionsRequest test = new GetSubscriptionsRequest().setPatientId(patientId);
    GetSubscriptionsResponse response= new SubscriptionService().getSubscriptionService().getSubscriptions(test);
    System.out.println(response);
  }
}

package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("91.228.65.225");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>88</State></GeoIP>");
  }

  @Test
  public void testInvalidIp(){
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("91.228.65.xxx");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>88</State></GeoIP>");
  }
}

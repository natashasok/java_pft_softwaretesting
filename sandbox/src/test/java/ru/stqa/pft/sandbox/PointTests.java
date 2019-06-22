package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testdistance(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(5,4);
    Assert.assertEquals(p1.distanceToPoint(p2),5.0);
  }

  @Test
  public void testdistance2(){
    Point p1 = new Point(2,0);
    Point p2 = new Point(5,4);
    Assert.assertEquals(p1.distanceToPoint(p2),5.0);
  }
}
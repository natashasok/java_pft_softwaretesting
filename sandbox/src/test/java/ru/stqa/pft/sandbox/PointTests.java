package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  Point p1 = new Point(1,1);
  Point p2 = new Point(5,4);

  @Test
  public void testdistance(){
    Assert.assertEquals(p1.distanceToPoint(p2),5.0);
  }

  @Test
  public void testdistance2(){
    Assert.assertEquals(p2.distanceToPoint(p1),5.0);
  }
  @Test
  public void testdistance3(){
    Assert.assertEquals(MyFirstProgram.distance(p1,p2),5.0);
  }
}
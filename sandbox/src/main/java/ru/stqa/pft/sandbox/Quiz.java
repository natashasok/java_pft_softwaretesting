package ru.stqa.pft.sandbox;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Quiz {
  public static void main(String[] args) throws Exception {
  booleanExpression(true, true, false, false);
  }

  public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
    ArrayList<Boolean> abcd = new ArrayList<>();
    abcd.add(0,a);
    abcd.add(1,b);
    abcd.add(2,c);
    abcd.add(3,d);
    for (int i = 0; i < abcd.size(); i++) { abcd.remove(false);}
    System.out.println(abcd.size());
    return false;
  }

}

package ru.stqa.pft.sandbox;

public class Collections {
  public static void main(String[] arg){
    String [] langs = {"Java","C#","Python", "PHP"};

    for (String l : langs){
      System.out.println("Я хочу выучить " + l);
    }
  }
}

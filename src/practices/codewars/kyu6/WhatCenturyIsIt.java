package practices.codewars.kyu6;

public class WhatCenturyIsIt {

  public static String whatCentury(int year) {
    int century = 1+(year-1)/100;
    String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    if(century>=11 && century<=13){
      return century + suffixes[0];
    }
    return century + suffixes[century%10];
  }
}

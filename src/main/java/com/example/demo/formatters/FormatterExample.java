package com.example.demo.formatters;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.example.demo.OneInterfaceToRunThemAll;

public class FormatterExample implements OneInterfaceToRunThemAll {
  @Override
  public void runExample() {
    System.out.println("\n*** Formatters ***");
    dateFormatters();
    numberFormatters();
  }

  private void dateFormatters() {
    LocalDateTime myLocalDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myLocalDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myLocalDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);

    myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    formattedDate = myLocalDateObj.format(myFormatObj);
    System.out.println("My own formatting: " + formattedDate);

    Date myDateObj = new Date();
    System.out.println("My date: " + myDateObj);

    LocalDate localDate = LocalDate.of(2002, 1, 1);
    System.out.println("My LocalDate: " + localDate);
    LocalDate localDate2 = LocalDate.now();
    System.out.println("My LocalDate2: " + localDate2);

    LocalTime localTime = LocalTime.now();
    System.out.println("My LocalTime: " + localTime);

    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("My LocalDateTime: " + localDateTime);
  }

  private void numberFormatters() {
    Float nbr = 1234.4321f;
    String result = NumberFormat.getInstance(Locale.US).format(nbr);
    System.out.println("Result of NumberFormat.getInstance: " + result);
  }
}
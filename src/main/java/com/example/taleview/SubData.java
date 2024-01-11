package com.example.taleview;

import com.example.taleview.Person;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

public class SubData extends Person {

    public static HelloController helloController;

    public static void setHelloController(HelloController controller) {
        helloController = controller;
    }

    public SubData(String firstName, String lastName, String won, String subs, String content, String where) {
        super(firstName, lastName, won, subs, content, where);

    }
    public  String toString() {
        return "The service is " + getFirstName() + "The amount of subscribers are " + getLastName()+ "The owner is " + getWon() + "The location it is in "+ getSubs() + " The founding date is " + getContent()+ "The content is " + getWhere();
    }
    public static void readData() throws Exception {


        File dataFile = new File("src/main/java/com/example/taleview/Streamig");

            try (Scanner dataScanner = new Scanner(dataFile)) {
                dataScanner.useDelimiter("\t|\n");
                while (dataScanner.hasNext()) {
                    String firstName = dataScanner.next();
                    String lastName = dataScanner.next();
                    String won = dataScanner.next();
                    String Subs = dataScanner.next();
                    String Content = dataScanner.next();
                    String where = dataScanner.next();
                    Person newPerson = new Person(firstName, lastName, won, Subs,Content, where);
                    System.out.println(newPerson);

                    helloController.addPersonToTableView(new SubData(firstName, lastName, won, Subs, Content, where));
                }
                 //   HelloController.myTableView.getItems().add(new Person(firstName, lastName, won, Subs,Content, where));
                }
            }
        }

        //    return  firstName +  lastName + won + Subs + Content + where;
        /*File dataFile = new File("src/main/java/com/example/taleview/Streamig");
        Scanner dataScanner = new Scanner(dataFile);
        dataScanner.useDelimiter("\t|\n");
        while (dataScanner.hasNext()) {

            String firstName = dataScanner.next();

            String lastName = dataScanner.next();

            String won = dataScanner.next();

            String Subs = dataScanner.next();

            String Content = dataScanner.next();

            String where = dataScanner.next();

            Person newPerson = new Person(firstName +  lastName + won + Subs + Content + where);

            System.out.println(newPerson);
        }
*/



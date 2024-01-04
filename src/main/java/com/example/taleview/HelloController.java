package com.example.taleview;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class HelloController {
    public TableView myTableView;
    public TextField firstName;
    public TextField lastname;
    public TextField wins;



    //        myController = (HelloController) fxmlLoader.getController();
    public void setTableView()  throws Exception {

        TableColumn firstNameColumn = new TableColumn<Person, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameColumn = new TableColumn<Person, String>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        TableColumn wonColummn = new TableColumn<Person, String>("Won");
        wonColummn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("won"));

        myTableView.getColumns().add(firstNameColumn);
        myTableView.getColumns().add(lastNameColumn);
        myTableView.getColumns().add(wonColummn);

        myTableView.getItems().add(new Person("Eli","Phillips","79"));
        //  @FXML
    }
    public void Saving() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("Save");
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

        ObservableList<Person> activities = myTableView.getItems();

        // Write the number of saved objects
        objOutputStream.writeInt(activities.size());

        // Write each Activity object
        for (Person activity : activities) {
            objOutputStream.writeObject(activity);
        }

        // Close the streams
        objOutputStream.flush();
        objOutputStream.close();
        outputStream.close();
    }
    public void initialize() throws Exception {
        TableColumn firstNameColumn = new TableColumn<Person, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameColumn = new TableColumn<Person, String>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        TableColumn wonColummn = new TableColumn<Person, String>("Won");
        wonColummn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("won"));

        myTableView.getColumns().add(firstNameColumn);
        myTableView.getColumns().add(lastNameColumn);
        myTableView.getColumns().add(wonColummn);

        //myTableView.getItems().add(new Person("Eli","Phillips","79"));

        myTableView.getSortOrder().add(firstNameColumn);
        //  @FXML
        this.RecalData();
    }
    public void additems() throws Exception {

        myTableView.getItems().add(new Person(firstName.getText(),lastname.getText(),wins.getText()));

    }
    public void eddit() throws Exception {
        myTableView.setEditable(true);

        System.out.println("dfdsa");

    }
public void RecalData() throws Exception{
   FileInputStream inputStream = new FileInputStream("Save");
    ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

// Read the list size
    int numOfSavedObjects = objInputStream.readInt();

    List<Person> activities = new ArrayList<>();

// Read each Activity object
    for (int i = 0; i < numOfSavedObjects; i++) {
        Person activity = (Person) objInputStream.readObject();
        activities.add(activity);
    }

// Close the streams
    objInputStream.close();
    inputStream.close();

// Add the loaded activities to the table
    myTableView.getItems().addAll(activities);
}

}
package com.example.taleview;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class HelloController {
    public  TableView myTableView;
    public TextField firstName;
    public TextField lastname;
    public TextField wins;

    public TextField subs;
    public TextField content;
    public TextField where;


    //        myController = (HelloController) fxmlLoader.getController();
    public void setTableView()  throws Exception {

        TableColumn firstNameColumn = new TableColumn<Person, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameColumn = new TableColumn<Person, String>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        TableColumn wonColummn = new TableColumn<Person, String>("Won");
        wonColummn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("won"));

        TableColumn subsCollumn = new TableColumn<Person, String>("Subs");
        subsCollumn.setCellValueFactory(new PropertyValueFactory<Person, String>("subs"));
        TableColumn contentCollummn = new TableColumn<Person, String>("Content");
        contentCollummn.setCellValueFactory(new PropertyValueFactory<Person, String>("Content"));
        TableColumn whereCollumn = new TableColumn<Person, String>("where");
        whereCollumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("where"));

        myTableView.getColumns().add(firstNameColumn);
        myTableView.getColumns().add(lastNameColumn);
        myTableView.getColumns().add(wonColummn);
        myTableView.getColumns().add(subsCollumn);
        myTableView.getColumns().add(contentCollummn);
        myTableView.getColumns().add(whereCollumn);

        myTableView.getItems().add(new Person("Eli","Phillips","79","12","12","12"));
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

        TableColumn firstNameColumn = new TableColumn<Person, String>("Company");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameColumn = new TableColumn<Person, String>("Company id");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        TableColumn wonColummn = new TableColumn<Person, String>("When they where founded");
        wonColummn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("won"));

        TableColumn subsCollumn = new TableColumn<Person, String>("Subs");
        subsCollumn.setCellValueFactory(new PropertyValueFactory<Person, String>("subs"));
        TableColumn contentCollummn = new TableColumn<Person, String>("Content");
        contentCollummn.setCellValueFactory(new PropertyValueFactory<Person, String>("Content"));
        TableColumn whereCollumn = new TableColumn<Person, String>("where");
        whereCollumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("where"));

        myTableView.getColumns().add(firstNameColumn);
        myTableView.getColumns().add(lastNameColumn);
        myTableView.getColumns().add(wonColummn);
        myTableView.getColumns().add(subsCollumn);
        myTableView.getColumns().add(contentCollummn);
        myTableView.getColumns().add(whereCollumn);

        //myTableView.getItems().add(new Person("Eli","Phillips","79","12","12","12"));
        myTableView.getSortOrder().add(firstNameColumn);
        //  @FXML
myTableView.setEditable(true);
     //   this.RecalData();


    }

    public void additems() throws Exception {

        myTableView.getItems().add(new Person(firstName.getText(),lastname.getText(),wins.getText(),subs.getText(),content.getText(),where.getText()));

    }
    public void eddit() throws Exception {
        SubData.setHelloController(this);
        SubData.readData();
    }
    void PrintData() throws Exception {
        SubData.readData();
    }
    public void addPersonToTableView(SubData newPerson){
        myTableView.getItems().add(newPerson);

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
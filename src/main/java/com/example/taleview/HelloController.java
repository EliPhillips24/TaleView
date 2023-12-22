package com.example.taleview;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;


public class HelloController {
    public TableView myTableView;
    public TextField firstName;
    public TextField lastname;
    public TextField wins;



    //        myController = (HelloController) fxmlLoader.getController();
    public void setTableView() {

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
        File fileForData = new File("Saved");
        FileOutputStream outputStream = new FileOutputStream(fileForData);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        ObservableList list1 = myTableView.getItems();
        objOutputStream.writeObject(list1.size());
        for (Object person : list1) {
            objOutputStream.writeObject(person);
        }
        objOutputStream.writeObject(list1.size());

        objOutputStream.flush();
        System.out.println(list1);
    }
    public void initialize(){
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

        myTableView.getSortOrder().add(firstNameColumn);
        //  @FXML

    }


    public void additems(){

        myTableView.getItems().add(new Person(firstName.getText(),lastname.getText(),wins.getText()));

    }
    public void eddit(){
        myTableView.setEditable(true);

        System.out.println("dfdsa");

    }
    public void checklist(){
        System.out.println(myTableView);
        System.out.println(myTableView.getItems());

        System.out.println(myTableView.getColumns());


    }
public void recal() {

}
}
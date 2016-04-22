/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import been.ListChemin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author QYL
 */
public class ListCheminController {

    private ObservableList<ListChemin> listCheminsData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<ListChemin,String> fromColumn;
    @FXML
    private TableColumn<ListChemin,String> destColumn;
    @FXML
    private TableColumn<ListChemin,String> distColumn;
    @FXML
    private TableColumn<ListChemin,String> radioColumn;
    @FXML
    private TableView<ListChemin> listTable;
    
    public ListCheminController (){
        listCheminsData.add(new ListChemin("from1","dest1","dist1","radio1"));
        listCheminsData.add(new ListChemin("from2","dest2","dist2","radio2"));
        listCheminsData.add(new ListChemin("from3","dest3","dist3","radio3"));
    }
    
    public ObservableList<ListChemin> getListChemins() {
        return listCheminsData;
    }
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        fromColumn.setCellValueFactory(cellData -> cellData.getValue().fromProperty());
        destColumn.setCellValueFactory(cellData -> cellData.getValue().destProperty());
        distColumn.setCellValueFactory(cellData -> cellData.getValue().distProperty());
        radioColumn.setCellValueFactory(cellData -> cellData.getValue().radioProperty());
    }
    
    public void setList(){
        listTable.setItems(getListChemins());
    }
}

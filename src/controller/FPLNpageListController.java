/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import been.ListChemin;
import java.time.Clock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author sowoumar25
 */
public class FPLNpageListController {

    private ObservableList<ListChemin> listCheminsData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<ListChemin, String> fromColumn;
    @FXML
    private TableColumn<ListChemin, String> destColumn;
    @FXML
    private TableColumn<ListChemin, String> distColumn;
    @FXML
    private TableColumn<ListChemin, String> radioColumn;
    @FXML
    private TableView<ListChemin> listTable;

    public ObservableList<ListChemin> getListChemins() {
        return listCheminsData;
    }

    /**
     * Initialize the person table with the two columns
     */
    @FXML
    private void initialize() {
        fromColumn.setCellValueFactory(cellData -> cellData.getValue().fromProperty());
        destColumn.setCellValueFactory(cellData -> cellData.getValue().destProperty());
        distColumn.setCellValueFactory(cellData -> cellData.getValue().distProperty());
        radioColumn.setCellValueFactory(cellData -> cellData.getValue().radioProperty());
    }

    
    public void afficherList() {
        System.out.println(listTable.getItems().size());
        listTable.setItems(getListChemins());
    }

    public void setList(String from, String dest, String dist, String radio) {
        System.out.println(listTable.getItems().size());
        listCheminsData.add(new ListChemin(from, dest, dist, radio));
    }
}

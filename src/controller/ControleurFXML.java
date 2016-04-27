/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mars
 */
public class ControleurFXML implements Initializable {

    
    @FXML
    private ClavierController controllerClavier;
    
    @FXML
    private FLNpageController controllerFlnPage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleButtonActionAlphaKeyBoard(ActionEvent event){
        System.out.println("Test ControleurFXML");
        controllerClavier.handleButtonActionAlphaKeyBoard(event);
    }
    
    @FXML
    public void handleButtonActionNumeriqueKeyBoard(ActionEvent event) {
        controllerClavier.handleButtonActionNumeriqueKeyBoard(event);
    }
    
    
}

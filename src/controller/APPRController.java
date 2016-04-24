/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class APPRController {
    private BorderPane rootBorder;
    private SplitPane rootSplit;
    FXMLLoader loaderCenter = null;
    FXMLLoader loaderSplit = null;
    FXMLLoader loaderClavier = null;
    
    public void setAPPRController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }

    @FXML
    public void handleEntererFLNPage() {
        try {                    
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../view/FLNpageSplit.fxml"));
            rootSplit = (SplitPane) loaderCenter.load();
            rootBorder.setCenter(rootSplit);
            
            /*
            Charger la page FLN sur le split  en haut.
            */
            loaderSplit = new FXMLLoader();
            loaderSplit.setLocation(StillStandFMS.class.getResource("../view/FLNpage.fxml"));            
            AnchorPane FXMLViewSplit = (AnchorPane) loaderSplit.load();
            rootSplit.getItems().set(0, FXMLViewSplit);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerFLNController();
    }
    
    public void chargerFLNController(){
        FLNpageController flnController = loaderSplit.getController();
        flnController.setFLNpageController(rootBorder,rootSplit);  
    }
}

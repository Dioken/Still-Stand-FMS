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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class APPRController {
    private BorderPane rootBorder;
    FXMLLoader loaderCenter = null;
    
    public void setAPPRController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }

    @FXML
    public void handleEntererFLNPage() {
        try {                    
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../view/FLNpage.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerFLNController();
    }
    
    public void chargerFLNController(){
        FLNpageController flnController = loaderCenter.getController();
        flnController.setFLNpageController(rootBorder);  
    }
}

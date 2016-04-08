/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import stillStandFMS.StillStandFMS;

/**
 *
 * @author QYL
 */
public class FXMLController {
    private BorderPane rootBorder;
    
    public void setFXMLController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    
    @FXML
    public void handleEntrerAPPR(){
        try {                    
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/APPR.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void handleEntrerGA(){
        try {                    
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/fxmlGoAround.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

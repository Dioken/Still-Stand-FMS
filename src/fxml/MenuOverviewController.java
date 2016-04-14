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
public class MenuOverviewController {
    private BorderPane rootBorder;
    private FXMLLoader loaderCenter;
    private FXMLLoader loaderLeft;
    public void setStillStandFMS(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    @FXML
    public void handleEntrerGoAroundPage() {        
        try {                    
            chargerFXML();
            
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/fxmlGoAround.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        chargerFXMLController();
        chargerGoAroundController();
    }    
    
    @FXML
    public void handleEntrerAPPRPage() {        
        try {                    
            chargerFXML();
            
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/APPR.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        chargerFXMLController();
        chargerAPPRController();
    }    
    
    public void chargerFXML(){
        try {
            loaderLeft = new FXMLLoader();
            loaderLeft.setLocation(StillStandFMS.class.getResource("../fxml/FXML.fxml"));
            AnchorPane FXMLViewLeft = (AnchorPane) loaderLeft.load();
            rootBorder.setLeft(FXMLViewLeft);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chargerFXMLController(){
        FXMLController fxmlController=loaderLeft.getController();
        fxmlController.setFXMLController(rootBorder);
    }
    
    public void chargerGoAroundController(){
        fxmlGoAroundController GoAroundController = loaderCenter.getController();
        GoAroundController.setGoAround(rootBorder);  
    }
    
    public void chargerAPPRController(){
        APPRController apprController = loaderCenter.getController();
        apprController.setAPPRController(rootBorder);
    }
}

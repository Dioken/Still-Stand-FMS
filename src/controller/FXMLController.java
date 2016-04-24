/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Button;
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
public class FXMLController {
    private BorderPane rootBorder;

    private Button jbuttonCLB;

    FXMLLoader loaderCenter = null;

    
    public void setFXMLController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    
    @FXML
    public void handleEntrerAPPR(){
          
        try {                    
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../view/APPR.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
          
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerAPPRController();
    }
    @FXML
    public void handleEntrerGA(){
        try {                    
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../view/GoAround.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerGoAroundController();
    }
    
    @FXML
    public void handleEntrerMenu(){
        try {                    
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../view/Menu.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
            rootBorder.setLeft(null);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerMenuController();
    }
    
    public void chargerGoAroundController(){
        GoAroundController GoAroundController = loaderCenter.getController();
        GoAroundController.setGoAround(rootBorder);  
    }
    
    public void chargerAPPRController(){
        APPRController apprController = loaderCenter.getController();
        apprController.setAPPRController(rootBorder);
    }
    
    public void chargerMenuController(){
        MenuController apprController = loaderCenter.getController();
        apprController.setStillStandFMS(rootBorder);
    }
    @FXML
    public void DeclencherAction(){
         System.out.println(jbuttonCLB.getSize());
    }
}

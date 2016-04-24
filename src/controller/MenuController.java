/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 * FXML Controller class
 *
 * @author bah
 */
public class MenuController implements Initializable {

    @FXML
    private Button boutonCRZ;
    @FXML
    private Button boutonGA;
    @FXML
    private Button boutonAPPR;
    @FXML
    private CheckBox normal;
    @FXML
    private CheckBox vibration;
    @FXML
    private CheckBox limunisite;
    
 
    boolean secondCliked = false;
    private BorderPane rootBorder;
    private FXMLLoader loaderCenter;
    private FXMLLoader loaderLeft;
    public void setStillStandFMS(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        normal.setSelected(true);
        vibration.setSelected(false);
        limunisite.setSelected(false);
    }    
    

    @FXML
    private void handleEntrerAPPRPage(ActionEvent event) {
        
         if(vibration.isSelected()){
            if(secondCliked){
                
              executeDeclencheAPPR();
              secondCliked = false;
            }else{
               DeclencherAction.declencherAction2(boutonAPPR, 100, 70);
               secondCliked = true;
            } 
         }else{
            executeDeclencheAPPR();
         }
        
    }

    @FXML
    private void handleEntrerGoAroundPage(ActionEvent event) {
        if(vibration.isSelected()){
            if(secondCliked){
              executeDeclencheGA();
              secondCliked = false;
            }else{
               DeclencherAction.declencherAction2(boutonGA, 100, 70);
               secondCliked = true;
            }
        }else{
            executeDeclencheGA();
        }
    }
    /**
     * Armer le contexte nomale
     * @param event 
     */
    @FXML
    private void activeNormal(ActionEvent event){
        normal.setSelected(true);
        vibration.setSelected(false);
        limunisite.setSelected(false);
        DeclencherAction.declencherAction2(boutonGA, 61.0, 23.0);
        DeclencherAction.declencherAction2(boutonAPPR, 61.0, 23.0);
    }
    /**
     * Armer le contexte vibration
     */
    @FXML
    private void activeVibration(ActionEvent event){
        normal.setSelected(false);
        vibration.setSelected(true);
        limunisite.setSelected(false);
        
    }
    /**
     * Aemer le contexte de la limuere
     */
    @FXML
    private void activeLimuniere(ActionEvent event){
        normal.setSelected(false); 
        vibration.setSelected(false);
        limunisite.setSelected(true);
    }
    /**
     * active dans le deux contexte
     * 
     */
    private void activeDesactiveContexte(CheckBox plimuniere, CheckBox pvibration){
        if((plimuniere.isSelected())&&pvibration.isSelected()){
           pvibration.setSelected(true);
        }
    }
    public void chargerFXML(){
        try {
            loaderLeft = new FXMLLoader();
            loaderLeft.setLocation(StillStandFMS.class.getResource("/view/FXML.fxml"));
            AnchorPane FXMLViewLeft = (AnchorPane) loaderLeft.load();
            rootBorder.setLeft(FXMLViewLeft);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chargerFXMLController(){
        FXMLController fxmlController=loaderLeft.getController();
        fxmlController.setFXMLController(rootBorder);
    }
    
    public void chargerGoAroundController(){
        GoAroundController GoAroundController = loaderCenter.getController();
        GoAroundController.setGoAround(rootBorder);  
    }
    
    public void chargerAPPRController(){
        APPRController apprController = loaderCenter.getController();
        apprController.setAPPRController(rootBorder);
    }
    /**
     * declenche l'action du bouton GA
     */
    private void executeDeclencheGA(){
        try {                    
            chargerFXML();
            
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/GoAround.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        chargerFXMLController();
        chargerGoAroundController();
    }
    /**
     * decleche l'action du bouton APPR
     */
    private void executeDeclencheAPPR(){
        try {                    
            chargerFXML();
            
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/APPR.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        chargerFXMLController();
        chargerAPPRController();
    }
}

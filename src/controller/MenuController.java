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
    private CheckBox luminosite;
    
    //Etat dans le conetxte
    public static Etat etat = Etat.Normal;
    boolean secondCliked = false;
    private BorderPane rootBorder;
    private FXMLLoader loaderCenter;
    private FXMLLoader loaderLeft;
    StillStandFMS fms;
    
    public void setStillStandFMS(BorderPane rootBorder,StillStandFMS fms){
        this.rootBorder = rootBorder;        
        this.fms = fms;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        switch(etat){
            case Normal:{
                etat = Etat.Normal;
                secondCliked = false;
                normal.setSelected(true);
                vibration.setSelected(false);
                luminosite.setSelected(false);
                break;
            }
            case Lumiere:{
                etat = Etat.Lumiere;
                secondCliked = false;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            }
            case Vibration:{
                etat = Etat.Vibration;
                secondCliked = false;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false); 
                break;
            }
            case VibLum:{
                etat = Etat.VibLum;
                secondCliked = false;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(true);
                break;
            }
        }
        
    }    
    

    @FXML
    private void handleEntrerAPPRPage(ActionEvent event) {  
        switch(etat){
            case Normal:{
                secondCliked = false;
                etat = Etat.Normal;
                executeDeclencheAPPR(); 
                break;
            }
            case Vibration:{
                etat = Etat.Vibration;
                if(secondCliked){
                    executeDeclencheAPPR(); 
                    secondCliked = false;
                }else{
                    DeclencherAction.declencherAction2(boutonAPPR, 100, 70);
                    secondCliked = true;
                }
                break;
            }   
            case Lumiere:{//completer
                break;
            }
            case VibLum:{//completer
                break;
            }
        }
           
    }

    @FXML
    private void handleEntrerGoAroundPage(ActionEvent event) {
        switch(etat){
            case Normal:{
                secondCliked = false;
                etat = Etat.Normal;
                executeDeclencheGA();
                break;
            }                    
            case Vibration:{
                etat = Etat.Vibration;
                if(secondCliked){
                    executeDeclencheGA();
                    secondCliked = false;
                }else{
                    DeclencherAction.declencherAction2(boutonGA, 100, 70);
                    secondCliked = true;
                }
                break;
            }
            case Lumiere:{ //completer
                break;
            }
            case VibLum:{ //completer
                break;
            }
        }
        

    }
    /**
     * Armer le contexte nomale
     * @param event 
     */
    @FXML
    private void activeNormal(ActionEvent event){
        etat = Etat.Normal;
        normal.setSelected(true);
        vibration.setSelected(false);
        luminosite.setSelected(false);
        DeclencherAction.declencherAction2(boutonGA, 61.0, 23.0);
        DeclencherAction.declencherAction2(boutonAPPR, 61.0, 23.0);
        //change les couleurs de bouton
        this.fms.setStyleCss(1);
    }
    /**
     * Armer le contexte vibration
     */
    @FXML
    private void activeVibration(ActionEvent event){
        if(luminosite.isSelected()){
            etat = Etat.VibLum;
            normal.setSelected(false);
            vibration.setSelected(true);
            luminosite.setSelected(true);  
        }else{
            etat = Etat.Vibration;
            normal.setSelected(false);
            vibration.setSelected(true);
            luminosite.setSelected(false);
        }
        
        
    }
    /**
     * Aemer le contexte de la limuere
     */
    @FXML
    private void activeLimuniere(ActionEvent event){
        if(vibration.isSelected()){
            etat = Etat.VibLum;
            normal.setSelected(false); 
            vibration.setSelected(true);
            luminosite.setSelected(true);
        }else{
            etat = Etat.Lumiere;
            normal.setSelected(false); 
            vibration.setSelected(false);
            luminosite.setSelected(true);
        }
       this.fms.setStyleCss(2);
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
        fxmlController.setFXMLController(rootBorder,fms);
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

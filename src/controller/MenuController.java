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
    private boolean firstActionGA = false;
    private boolean firstActionAPP = false;
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
        switch(etat){
            case Normal:{
                etat = Etat.Normal;
                normal.setSelected(true);
                vibration.setSelected(false);
                luminosite.setSelected(false);
                break;
            }
            case Lumiere:{
                etat = Etat.Lumiere;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            }
            case Vibration:{
                etat = Etat.Vibration;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false); 
                break;
            }
            case VibLum:{
                etat = Etat.VibLum;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(true);
                break;
            }
            case VibAction:{
                etat = Etat.VibAction;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false);
                break;
            }
            case LumAction:{
                etat = Etat.LumAction;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            }
            case VibLumAction:{
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
                etat = Etat.Normal;
                executeDeclencheAPPR(); 
                break;
            }
            case Vibration:{
                etat = Etat.VibAction;
                firstActionAPP = true;
                DeclencherAction.declencherAction2(boutonAPPR, 100, 70);
                DeclencherAction.declencherAction2(boutonGA, 61.0, 23.0);
                break;
            }
            case VibAction:{
                if(firstActionGA){  
                    etat = Etat.VibAction;
                    firstActionAPP = true;
                    firstActionGA = false;
                    DeclencherAction.declencherAction2(boutonAPPR, 100, 70);
                    DeclencherAction.declencherAction2(boutonGA, 61.0, 23.0);
                    
                }else{
                    etat = Etat.Vibration;
                    executeDeclencheAPPR();
                    DeclencherAction.declencherAction2(boutonAPPR, 61.0, 23.0);
                    firstActionAPP = false;  
                }                 
                break;
            }
            case Lumiere:{//completer
                etat = Etat.LumAction;
                
                break;
            }
            case LumAction:{// a completer
                etat = Etat.Lumiere;
                break;
            }
            case VibLum:{//completer
                etat = Etat.VibLumAction;
                break;
            }
            case VibLumAction:{
                etat = Etat.VibLum;
                break;
            }
            
        }
           
    }

    @FXML
    private void handleEntrerGoAroundPage(ActionEvent event) {
        switch(etat){
            case Normal:{
                etat = Etat.Normal;
                executeDeclencheGA();
                break;
            }                    
            case Vibration:{
                etat = Etat.VibAction;
                firstActionGA = true;
                DeclencherAction.declencherAction2(boutonGA, 100, 70);
                DeclencherAction.declencherAction2(boutonAPPR, 61.0, 23.0);
                break;
            }
            case Lumiere:{ //completer
                etat = Etat.LumAction;
                break;
            }
            case VibLum:{ // completer
                etat = Etat.VibLumAction;
                break;
            }
            case VibAction:{
                if(firstActionAPP){
                    firstActionGA = true;
                    firstActionAPP = false;
                    etat = Etat.VibAction;
                    DeclencherAction.declencherAction2(boutonGA, 100, 70);
                    DeclencherAction.declencherAction2(boutonAPPR, 61.0, 23.0);
                }else{
                    etat = Etat.Vibration;
                    firstActionGA = false;
                    executeDeclencheGA();
                    DeclencherAction.declencherAction2(boutonGA, 61.0, 23.0);
                }         
                break;
            }
            case LumAction:{ // a completer
                etat = Etat.Lumiere;
                break;
            }
            case VibLumAction:{
                etat = Etat.VibLum;
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
    }
    /**
     * Armer le contexte vibration
     */
    @FXML
    private void activeVibration(ActionEvent event){
        switch(etat){
            case Normal: 
                etat = Etat.Vibration;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false);
                break;
            case Vibration:
                etat = Etat.Vibration;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false);
                break;
            case Lumiere:{
                etat = Etat.VibLum;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(true);
                break;
            }
            case VibLum:{
                etat = Etat.Lumiere;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            }
            case LumAction://interdit
                break;
            case VibAction://interdit
                break;
            case VibLumAction://interdit
                break;
        }
                
    }
    /**
     * Aemer le contexte de la limuere
     */
    @FXML
    private void activeLimuniere(ActionEvent event){
        switch(etat){
            case Normal: 
                etat = Etat.Lumiere;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            case Vibration:{
                etat = Etat.VibLum;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(true);
                break;
            }               
            case Lumiere:{
                etat = Etat.Lumiere;
                normal.setSelected(false);
                vibration.setSelected(false);
                luminosite.setSelected(true);
                break;
            }
            case VibLum:{
                etat = Etat.Vibration;
                normal.setSelected(false);
                vibration.setSelected(true);
                luminosite.setSelected(false);
                break;
            }
            case LumAction://interdit
                break;
            case VibAction://interdit
                break;
            case VibLumAction: //interdit
                break;
                    
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
    
     public void changerCss(){
     //   rootBorder.getStylesheets().add("/view/modena.css");
        
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

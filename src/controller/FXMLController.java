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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class FXMLController {
    @FXML
    private Button bouttonMenu;
    @FXML
    private Button bouttonGA;
    @FXML
    private Button bouttonAPPR;
    
    boolean secondCliked = false;
    private BorderPane rootBorder;
    FXMLLoader loaderCenter = null;

    
    public void setFXMLController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    
    @FXML
    public void handleEntrerAPPR(){
        switch (MenuController.etat){
            case Normal:{
                secondCliked = false;
                declencherAPPR();
                break;
            }
            case Vibration:{
                if(secondCliked){
                   declencherAPPR();
                   secondCliked = false;
                   DeclencherAction.declencherAction2(bouttonAPPR, 61.0, 23.0);
                }else{
                   DeclencherAction.declencherAction2(bouttonAPPR, 100, 70);
                   secondCliked = true;
                }
            }
            case Lumiere:{//a completer
                break;
            }
            case VibLum:{// a completer
                break;
            }
        }
        
    }
    @FXML
    public void handleEntrerGA(){
        switch(MenuController.etat){
            case Normal:{
                secondCliked = false;
                declencherGA();
                break;
            }
            case Vibration:{
                 if(secondCliked){
                    declencherGA();
                    secondCliked = false;
                    DeclencherAction.declencherAction2(bouttonGA, 61.0, 23.0);
                 }else{
                    DeclencherAction.declencherAction2(bouttonGA, 100, 70);
                    secondCliked = true;
                 }
                 break;
            }
            case Lumiere:{// a completer
                
                break;
            }
            case VibLum:{// a completer
                break;
            }
        }
        
    }
    
    @FXML
    public void handleEntrerMenu(){
        switch(MenuController.etat){
            case Normal:{
                secondCliked = false;
                declencherMenu();
                break;
            }
            case Vibration:{
                 if(secondCliked){
                    declencherMenu();
                    secondCliked = false;
                    DeclencherAction.declencherAction2(bouttonMenu, 61.0, 23.0);
                 }else{
                    DeclencherAction.declencherAction2(bouttonMenu, 100, 70);
                    secondCliked = true;
                 }
                 break;
            }
            case Lumiere:{// a completer
                
                break;
            }
            case VibLum:{// a completer
                break;
            }
        }
        
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

    private void declencherGA() {
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
    /**
     * declenche APPR
     */
    private void declencherAPPR() {
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
    /**
     * declenche Manu
     */
    private void declencherMenu() {
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
}

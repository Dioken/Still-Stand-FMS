/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import controller.util.Etat;
import controller.util.DeclencherAction;
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
    private boolean firstActionGA = false;
    private boolean firstActionAPPR = false;
    private boolean firstActionMenu = false;
    private BorderPane rootBorder;
    FXMLLoader loaderCenter = null;
    StillStandFMS fms;
    
    public void setFXMLController(BorderPane rootBorder,StillStandFMS fms){
        this.rootBorder = rootBorder;
        this.fms = fms;
    }
    
    @FXML
    public void handleEntrerAPPR(){
        switch (MenuController.etat){
            case Normal:{
                MenuController.etat = Etat.Normal;
                firstActionGA = false;
                firstActionAPPR = false;
                firstActionMenu = false;
                declencherAPPR();
                break;
            }
            case Vibration:{
                MenuController.etat = Etat.VibAction;
                firstActionAPPR = true;                 
                DeclencherAction.declencherAction2(bouttonAPPR, 150, 110);
                DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                break;
            }
            case Lumiere:{
                MenuController.etat = Etat.Lumiere;
                declencherAPPR();
                break;
            }
            case VibLum:{
                MenuController.etat = Etat.VibLumAction;
                firstActionAPPR = true;                 
                DeclencherAction.declencherAction2(bouttonAPPR, 150, 110);
                DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                break;
            }
            
            case VibAction:{
                if((firstActionGA)||(firstActionMenu)){
                    MenuController.etat = Etat.VibAction;
                    firstActionAPPR = true;
                    firstActionGA = false;
                    firstActionMenu = false;
                    DeclencherAction.declencherAction2(bouttonAPPR, 150, 110);
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                }else{
                    MenuController.etat = Etat.Vibration;
                    declencherAPPR();
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                    firstActionAPPR = false;
                }
                break;
            }
            case VibLumAction:{ 
                if((firstActionGA)||(firstActionMenu)){
                    MenuController.etat = Etat.VibLumAction;
                    firstActionAPPR = true;
                    firstActionGA = false;
                    firstActionMenu = false;
                    DeclencherAction.declencherAction2(bouttonAPPR, 150, 110);
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                }else{
                    MenuController.etat = Etat.VibLum;
                    declencherAPPR();
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                    firstActionAPPR = false;
                }                
                break;
            }
            
        }
        
    }
    @FXML
    public void handleEntrerGA(){
        switch(MenuController.etat){
            case Normal:{
                MenuController.etat = Etat.Normal;
                declencherGA();
                break;
            }
            case Vibration:{
                MenuController.etat = Etat.VibAction;
                firstActionGA = true;
                DeclencherAction.declencherAction2(bouttonGA, 150, 110);
                DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                DeclencherAction.declencherAction2(bouttonMenu, 83, 43);  
                break;
            }
            case Lumiere:{
                MenuController.etat = Etat.Lumiere;
                declencherGA();
                break;
            }
            case VibLum:{
                MenuController.etat = Etat.VibLumAction;
                firstActionGA = true;
                DeclencherAction.declencherAction2(bouttonGA, 150, 110);
                DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                break;
            }
            
            case VibAction:{
                if((firstActionAPPR)||(firstActionMenu)){
                    MenuController.etat = Etat.VibAction;
                    firstActionGA = true;
                    firstActionAPPR = false;
                    firstActionMenu = false;
                    DeclencherAction.declencherAction2(bouttonGA, 150, 110);
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                }else{
                    MenuController.etat = Etat.Vibration;
                    declencherGA();
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    firstActionGA = false;
                }
                break;
            }
            case VibLumAction:{
                if((firstActionAPPR)||(firstActionMenu)){
                    MenuController.etat = Etat.VibLumAction;
                    firstActionGA = true;
                    firstActionAPPR = false;
                    firstActionMenu = false;
                    DeclencherAction.declencherAction2(bouttonGA, 150, 110);
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                }else{
                    MenuController.etat = Etat.VibLum;
                    declencherGA();
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    firstActionGA = false;
                }
                break;
            }
        }
               
    }
    
    @FXML
    public void handleEntrerMenu(){
        switch(MenuController.etat){
            case Normal:{
                MenuController.etat = Etat.Normal;
                declencherMenu();
                break;
            }
            case Vibration:{
                MenuController.etat = Etat.VibAction;
                firstActionMenu = true;
                DeclencherAction.declencherAction2(bouttonMenu, 150, 110);
                DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                DeclencherAction.declencherAction2(bouttonGA, 83, 43);  
                 break;
            }
            case Lumiere:{
                MenuController.etat = Etat.Lumiere;
                declencherMenu();
                break;
            }
            case VibLum:{
                MenuController.etat = Etat.VibLumAction;
                firstActionMenu = true;
                DeclencherAction.declencherAction2(bouttonMenu, 150, 110);
                DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                break;
            }
            
            case VibAction:{
                if((firstActionGA)||(firstActionAPPR)){
                    MenuController.etat = Etat.VibAction;
                    firstActionMenu = true;
                    firstActionGA = false;
                    firstActionAPPR = false;
                    DeclencherAction.declencherAction2(bouttonMenu, 150, 110);
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                }else{
                    MenuController.etat = Etat.Vibration;
                    declencherMenu();
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                    firstActionMenu = false;
                }
                break;
            }
            case VibLumAction:{
                if((firstActionGA)||(firstActionAPPR)){
                    MenuController.etat = Etat.VibLumAction;
                    firstActionMenu = true;
                    firstActionGA = false;
                    firstActionAPPR = false;
                    DeclencherAction.declencherAction2(bouttonMenu, 150, 110);
                    DeclencherAction.declencherAction2(bouttonGA, 83, 43);
                    DeclencherAction.declencherAction2(bouttonAPPR, 83, 43);
                }else{
                    MenuController.etat = Etat.VibLum;
                    declencherMenu();
                    DeclencherAction.declencherAction2(bouttonMenu, 83, 43);
                    firstActionMenu = false;
                }
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
        apprController.setStillStandFMS(rootBorder,fms);
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

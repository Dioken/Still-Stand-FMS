/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import been.ListChemin;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class FLNpageController {
    private BorderPane rootBorder;
    private SplitPane rootSplit;
    private SplitPane splitPane;
    @FXML
    private TextField numch;
    @FXML
    private TextField from;
    @FXML
    private TextField dest;
    @FXML
    private TextField dist;
    @FXML
    private TextField radio;
    @FXML
    private Button bModifier;
    @FXML
    private Button bValider;
    
    public void setFLNpageController(BorderPane rootBorder,SplitPane rootSplit){
        this.rootBorder = rootBorder;
        this.rootSplit = rootSplit;
    }
    @FXML
    public void handleEntererListe(){
        try {                    
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Liste.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);
            
            //charger listCheminController
            ListCheminController controller = loaderCenter.getController();
            /*
            ListChemin: 4 attributs
            from: depart
            dest: arrive
            dist: distance
            radio: lu numero de radio
            */
            controller.setList("from1","dest1","dist1","radio1");
            controller.setList("from2","dest2","dist2","radio2");
            controller.setList("from3","dest3","dist3","radio3");
            // afficher des donnee sur la TableView
            controller.afficherList();

            
            //A mettre dans un autre controlleur ce qui est en commentaire
            /* 
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            SplitPane splitPane = (SplitPane) FXMLViewCenter.getChildren().get(0);
            
            FXMLLoader loaderDown = new FXMLLoader();
            loaderDown.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            AnchorPane clavier = (AnchorPane) loaderDown.load();
                    
            
            splitPane.getItems().set(1, clavier);
            rootBorder.setCenter(FXMLViewCenter);*/
            
            //FXMLLoader loaderDown = new FXMLLoader();
            //loaderDown.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            //rootBorder.getChildren().get(0).setClip(FXMLLoader);
            //FXMLViewCenter.getChildren().add(loaderDown);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void handleAfficherLeCheminEnCourant(){
        try {
            /*
            charger la page clavier sur le split en bas
            */
            FXMLLoader loaderClavier = new FXMLLoader();
            loaderClavier.setLocation(StillStandFMS.class.getResource("../view/Clavier.fxml"));                            
            AnchorPane FXMLViewClavier;
            FXMLViewClavier = (AnchorPane) loaderClavier.load();
            rootSplit.getItems().set(1, FXMLViewClavier);
        } catch (IOException ex) {
            Logger.getLogger(FLNpageController.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }     
    
    @FXML
    public void apuyerBtValide(){  
        this.bModifier.setDisable(false);
        this.bValider.setDisable(true);
        this.dest.setEditable(false);
        this.dist.setEditable(false);
        this.radio.setEditable(false);
        
        try {
            FXMLLoader  loaderChemins = new FXMLLoader();
            
            loaderChemins.setLocation(StillStandFMS.class.getResource("../view/FLNpageList.fxml"));
            AnchorPane FXMLViewClavier = (AnchorPane) loaderChemins.load();
            rootSplit.getItems().set(1, FXMLViewClavier);
        
        
        //charger listCheminController
            FLNpageListController controller = loaderChemins.getController();
            /*
            ListChemin: 4 attributs
            from: depart
            dest: arrive
            dist: distance
            radio: lu numero de radio
            */
            controller.setList("Gbessia International Airport (GUINEA)",
                    "Léopold-Sédar-Senghor Airport (SENEGAL)","1200","1505");
            controller.setList("Léopold-Sédar-Senghor Airport (SENEGAL)",
                    "Mohammed V - Casablanca Airport (MAROC)", "1200","1505");
            controller.setList("Mohammed V - Casablanca Airport (MAROC)",
                    this.dest.getText(),"1200","1505");
            // afficher des donnee sur la TableView
            controller.afficherList();
            } catch (IOException ex) {
            Logger.getLogger(FLNpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML
    public void chercherChenim(){
        if(this.numch.getText().equals("L001")){
            this.from.setText("Gbessia International Airport (GUINEA)");
            this.dest.setText("Paris Charles-de-Gaulle Airport (FRANCE)");
            this.dist.setText("9100 KM");
            this.radio.setText("1505");
        }
        
    }
    
    @FXML
    public void activerModification(){
        this.bModifier.setDisable(true);
        this.bValider.setDisable(false);
        this.dest.setEditable(true);
        this.dist.setEditable(true);
        this.radio.setEditable(true);
    }
    
}

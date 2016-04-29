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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class FPLNpageController {

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
    @FXML
    private Button bAnnuler;

    public static TextField focus;
    public static int cursorPosition;

    public void setFLNpageController(BorderPane rootBorder, SplitPane rootSplit) {
        this.rootBorder = rootBorder;
        this.rootSplit = rootSplit;
    }

    /**
     * Permet de remplir les données sur la page Liste
     */
    @FXML
    public void handleEntererListe() {
        try {
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Liste.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();

            rootBorder.setCenter(FXMLViewCenter);

            //charger listCheminController
            ListCheminController controller = loaderCenter.getController();
            
            if (this.from.getText().equals("Gbessia International Airport (GUINEA)")) {
                controller.setList("Gbessia International Airport (GUINEA)",
                        this.dest.getText(), "79100 KM", this.radio.getText());
                controller.setList("London Gatwick International Airport (ENGLAND)",
                        "Léonard-de-Vinci International Airport (ITALIA)", "15700 KM", "0007");
            }

            if (this.from.getText().equals("London Gatwick International Airport (ENGLAND)")) {
                controller.setList("London Gatwick International Airport (ENGLAND)",
                        this.dest.getText(), "15700 KM", this.radio.getText());
                controller.setList("Gbessia International Airport (GUINEA)",
                        "Paris Charles-de-Gaulle Airport (FRANCE)", "9100 KM", "1505");
            }

            // afficher des donnee sur la TableView
            controller.afficherList();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Charger la page listEncourant sur le split en bas
     */
    @FXML
    public void apuyerBtValide() {
        this.bModifier.setDisable(false);
        this.bValider.setDisable(true);
        this.bAnnuler.setDisable(true);
        this.dest.setEditable(false);
        this.dist.setEditable(false);
        this.radio.setEditable(false);

        try {
            FXMLLoader loaderChemins = new FXMLLoader();

            loaderChemins.setLocation(StillStandFMS.class.getResource("/view/FPLNpageList.fxml"));
            AnchorPane FXMLViewClavier = (AnchorPane) loaderChemins.load();
            rootSplit.getItems().set(1, FXMLViewClavier);

            //charger listCheminController
            FPLNpageListController controller = loaderChemins.getController();

            if (this.from.getText().equals("Gbessia International Airport (GUINEA)")) {
                controller.setList("Gbessia International Airport (GUINEA)",
                        "Léopold-Sédar-Senghor Airport (SENEGAL)", "1200 KM", "1505");
                controller.setList("Léopold-Sédar-Senghor Airport (SENEGAL)",
                        "Mohammed V - Casablanca Airport (MAROC)", "2113 KM", "1505");
                controller.setList("Mohammed V - Casablanca Airport (MAROC)",
                        this.dest.getText(), "7700 KM", this.radio.getText());
            }

            if (this.from.getText().equals("London Gatwick International Airport (ENGLAND)")) {
                controller.setList("London Gatwick International Airport (ENGLAND)",
                        "Ciudad de mexico International Airport (MEXICO)", "8200 KM", "0007");
                controller.setList("Ciudad de mexico International Airport (MEXICO)",
                        this.dest.getText(), "2725 KM", this.radio.getText());
            }

            // afficher des donnee sur la TableView
            controller.afficherList();
        } catch (IOException ex) {
            Logger.getLogger(FPLNpageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Affiche le chemin complet à partir du numéro de chemin
     */
    @FXML
    public void chercherChenim() {
        if (this.numch.getText().equals("L001")) {
            this.from.setText("Gbessia International Airport (GUINEA)");
            this.dest.setText("Paris Charles-de-Gaulle Airport (FRANCE)");
            this.dist.setText("9100 KM");
            this.radio.setText("1505"); 
        }

        if (this.numch.getText().equals("L007")) {
            this.from.setText("London Gatwick International Airport (ENGLAND)");
            this.dest.setText("Léonard-de-Vinci International Airport (ITALIA)");
            this.dist.setText("15700 KM");
            this.radio.setText("0007");
        }
    }

    /**
     * Quand on appue sur le bouton modifier
     */
    @FXML
    public void activerModification() {
        this.bModifier.setDisable(true);
        this.bValider.setDisable(false);
        this.bAnnuler.setDisable(false);
        this.dest.setEditable(true);
        this.dist.setEditable(true);
        this.radio.setEditable(true);
    }

    /**
     * Cette fonctions permet de faire la saisit dans le champs lorsqu'on click
     * sur un boutton
     *
     * @param event
     * @return String: la lettre appuyer
     */
    @FXML
    public void handlerRemplirChamp(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        focus.setText(focus.getText() + boutton.getText());
    }

    /**
     * Charger la page clavier sur le split en bas
     * @param event evenement
     */
    @FXML
    public void handlerClickChamp(MouseEvent event) {

        TextField text = (TextField) event.getSource();

        cursorPosition = text.getCaretPosition();

        focus = null;
        focus = text;

        try {
            FXMLLoader loaderClavier = new FXMLLoader();
            loaderClavier.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            AnchorPane FXMLViewClavier = (AnchorPane) loaderClavier.load();
            rootSplit.getItems().set(1, FXMLViewClavier);
        } catch (IOException ex) {
            Logger.getLogger(FPLNpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void handlerClickAnnuler() {
        this.bModifier.setDisable(false);
        this.bValider.setDisable(true);
        this.bAnnuler.setDisable(true);
        this.dest.setEditable(false);
        this.dist.setEditable(false);
        this.radio.setEditable(false);
        
        this.numch.setText("");
        this.from.setText("");
        this.dest.setText("");
        this.dist.setText("");
        this.radio.setText("");
    }
}

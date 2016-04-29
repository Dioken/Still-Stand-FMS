/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.util.DeclencherAction;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;


/**
 *
 * @author QYL
 */
public class GoAroundController {

    @FXML
    private Button boutoonFLNPage;
    private BorderPane rootBorder;
    private SplitPane rootSplit;
    FXMLLoader loaderCenter = null;
    FXMLLoader loaderSplit = null;
    FXMLLoader loaderClavier = null;
    boolean secondCliked = false;

    public void setGoAround(BorderPane rootBorder) {
        this.rootBorder = rootBorder;
    }

    @FXML
    public void handleEntererFLNPage() {
        switch (MenuController.etat) {
            case Normal: {
                secondCliked = false;
                declencehrFLNPage();
                break;
            }
            case Vibration: {
                if (secondCliked) {
                    declencehrFLNPage();
                    secondCliked = false;
                } else {
                    DeclencherAction.declencherAction2(boutoonFLNPage, 150, 110);
                    secondCliked = true;
                }
                break;
            }
            case Lumiere: {
                secondCliked = false;
                declencehrFLNPage();
                break;
            }
            case VibLum: {
                if (secondCliked) {
                    declencehrFLNPage();
                    secondCliked = false;
                } else {
                    DeclencherAction.declencherAction2(boutoonFLNPage, 150, 110);
                    secondCliked = true;
                }
                break;
            }
            case VibAction://interdit
                break;
            case VibLumAction://interdit
                break;
        }

    }

    public void chargerFLNController() {
        FPLNpageController flnController = loaderSplit.getController();
        flnController.setFLNpageController(rootBorder, rootSplit);
    }

    private void declencehrFLNPage() {
        try {
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/FPLNpageSplit.fxml"));
            rootSplit = (SplitPane) loaderCenter.load();
            rootBorder.setCenter(rootSplit);

            /*
            Charger la page FLN sur le split  en haut.
             */
            loaderSplit = new FXMLLoader();
            loaderSplit.setLocation(StillStandFMS.class.getResource("/view/FPLNpage.fxml"));
            AnchorPane FXMLViewSplit = (AnchorPane) loaderSplit.load();
            rootSplit.getItems().set(0, FXMLViewSplit);

            /* Ajouter l'ensemble des chemins de vol (way points)*/
            FXMLLoader loaderSplit2 = new FXMLLoader();
            loaderSplit2.setLocation(StillStandFMS.class.getResource("/view/FPLNpageList.fxml"));
            AnchorPane FXMLViewList = (AnchorPane) loaderSplit2.load();
            rootSplit.getItems().set(1, FXMLViewList);

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        chargerFLNController();
    }
}

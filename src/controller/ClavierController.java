/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.FPLNpageController.cursorPosition;
import static controller.FPLNpageController.focus;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author mars
 */
public class ClavierController implements Initializable {

    @FXML
    private List<Button> buttonsAlpha;

    @FXML
    private List<Button> buttonsNumerique;

    @FXML
    private GridPane gridPaneAlpha;

    @FXML
    private GridPane gridPaneNumerique;

    private boolean firstAlpha;
    private boolean firstNum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        firstAlpha = true;
        firstNum = true;
    }

    @FXML
    public void handleButtonActionAlphaKeyBoard(ActionEvent event) {

        List<Button> listButtonProche = adpaterAlphaKeyboard((Button) event.getSource());
        
        switch (MenuController.etat) {
            case Normal: {
                System.out.println("Normal");
                focusFonction(event);
                //focus.setText(focus.getText() + ((Button) event.getSource()).getText());
                break;
            }
            case Vibration: {
                if (firstAlpha) {
                     System.out.println("FirstVibration");
                    adapteClavier(gridPaneAlpha, listButtonProche);
                    firstAlpha = false;
                } else {
                    focusFonction(event);
                    //focus.setText(focus.getText() + ((Button) event.getSource()).getText());
                    initClavier(gridPaneAlpha);
                    firstAlpha = true;
                }
                break;
            }
            case Lumiere: {
                focusFonction(event);
                break;
            }
            case VibLum: {
                if (firstAlpha) {
                    adapteClavier(gridPaneAlpha, listButtonProche);
                    firstAlpha = false;
                } else {
                    // focus.setText(focus.getText() + ((Button) event.getSource()).getText());
                    focusFonction(event);
                    initClavier(gridPaneAlpha);
                    firstAlpha = true;
                }
                break;
            }
        }

    }

    private void adapteClavier(GridPane gridPane, List<Button> listButtonProche) {
        // List<Button> listButtonProche = adpaterAlphaKeyboard((Button) event.getSource());

        int nbNode = gridPane.getChildren().size();

        for (int i = 0; i < nbNode; i++) {
            if (!listButtonProche.contains(gridPane.getChildren().get(i))) {
                gridPane.getChildren().get(i).setVisible(false);
            }
        }
    }

    private void initClavier(GridPane gridPane) {
        int nbNode = gridPane.getChildren().size();
        for (int i = 0; i < nbNode; i++) {
            gridPane.getChildren().get(i).setVisible(true);

        }
    }

    @FXML
    public void handleButtonActionNumeriqueKeyBoard(ActionEvent event) {

        // System.out.println(focus.getText());
        //focus.setText(focus.getText() + ((Button) event.getSource()).getText());
        List<Button> listButtonProche = adpaterNumeriqueKeyboard((Button) event.getSource());

        switch (MenuController.etat) {
            case Normal: {
                // focus.setText(focus.getText() + ((Button) event.getSource()).getText());
                focusFonction(event);
                break;
            }
            case Vibration: {
                if (firstNum) {
                   
                    adapteClavier(gridPaneNumerique, listButtonProche);
                    firstNum = false;
                } else {
                    //focus.setText(focus.getText() + ((Button) event.getSource()).getText());
                    focusFonction(event);
                    initClavier(gridPaneNumerique);
                    firstNum = true;
                }
                break;
            }
            case Lumiere: {
                focusFonction(event);
                break;
            }
            case VibLum: {
                if (firstNum) {
                    adapteClavier(gridPaneNumerique, listButtonProche);
                    firstNum = false;
                } else {
                    focusFonction(event);
                    initClavier(gridPaneNumerique);
                    firstNum = true;
                }
                break;
            }
        }

    }

    private List<Button> adpaterAlphaKeyboard(Button buttonRepere) {

        int indexButtonRepere;
        indexButtonRepere = buttonsAlpha.indexOf(buttonRepere);
        List<Button> listButtonProche = new ArrayList<>();
        int pX = transFormX(indexButtonRepere, 5);
        int pY = transFormY(indexButtonRepere, 5);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (effetBord(i + pX, j + pY, 5, 4)) {
                    listButtonProche.add(buttonsAlpha.get(trans2Dto1D(i + pX, j + pY, 5)));
                }
            }
        }

        return listButtonProche;
    }

    private List<Button> adpaterNumeriqueKeyboard(Button buttonRepere) {

        int indexButtonRepere;

        indexButtonRepere = buttonsNumerique.indexOf(buttonRepere);
        List<Button> listButtonProche = new ArrayList<>();
        int pX = transFormX(indexButtonRepere, 3);
        int pY = transFormY(indexButtonRepere, 3);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (effetBord(i + pX, j + pY, 3, 2)) {
                    listButtonProche.add(buttonsNumerique.get(trans2Dto1D(i + pX, j + pY, 3)));
                }
            }
        }

        return listButtonProche;
    }

    private int transFormX(int index, int sizeTab) {
        return Math.round(index / sizeTab);
    }

    private int transFormY(int index, int sizeTab) {
        return index % sizeTab;
    }

    private int trans2Dto1D(int indexX, int indexY, int nbColum) {
        return (indexX * nbColum + indexY);
    }

    private boolean effetBord(int x, int y, int maxX, int maxY) {
        return ((x >= 0 && x <= maxX) && (y >= 0 && y <= maxY));
    }

    public void focusFonction(ActionEvent event) {

        if (((Button) event.getSource()).getText().equals("DEL")) {
            String textAvant = focus.getText().substring(0, cursorPosition - 1);
            String textApres = focus.getText().substring(cursorPosition, focus.getLength());
            cursorPosition--;
            focus.setText(textAvant + textApres);
        } else if (((Button) event.getSource()).getText().equals("CLR")) {
            focus.setText(" ");
            //focus.deleteText(range);
        } else if (((Button) event.getSource()).getText().equals("SP")) {
            String textAvant = focus.getText().substring(0, cursorPosition);
            String textApres = focus.getText().substring(cursorPosition, focus.getLength());
            cursorPosition++;
            focus.setText(textAvant + " " + textApres);
        } else {
            String textAvant = focus.getText().substring(0, cursorPosition);
            String textApres = focus.getText().substring(cursorPosition, focus.getLength());
            cursorPosition++;
            focus.setText(textAvant + ((Button) event.getSource()).getText() + textApres);
        }
    }

}

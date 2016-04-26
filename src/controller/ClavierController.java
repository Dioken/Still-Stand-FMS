/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          
    }    
    
    @FXML
    public void handleButtonActionAlphaKeyBoard(ActionEvent event) {
     // Button was clicked, do something...
       // System.out.println("view.ClavierController.handleButtonAction() "+event.getSource());
        List<Button> listButtonProche =adpaterAlphaKeyboard((Button) event.getSource());
        int nbNode = gridPaneAlpha.getChildren().size();
        for(int i = 0; i < nbNode; i++){
            gridPaneAlpha.getChildren().get(i).setVisible(false);
        }
        //System.out.println(listButtonProche.get(0));
        gridPaneAlpha.add(listButtonProche.get(0), 0, 0);
     }
    
    @FXML
    public void handleButtonActionNumeriqueKeyBoard(ActionEvent event) {
     // Button was clicked, do something...
        System.out.println("view.ClavierController.handleButtonAction()");
        System.err.println(event.getSource().toString());
        List<Button> listButtonProche = adpaterNumeriqueKeyboard((Button) event.getSource());
     }
    
    public List<Button> adpaterAlphaKeyboard(Button buttonRepere){
        
       int indexButtonRepere; 
        System.out.println("Alpha "+buttonRepere);
       indexButtonRepere = buttonsAlpha.indexOf(buttonRepere);
       List<Button> listButtonProche = new ArrayList<>();
       int pX = transFormX(indexButtonRepere, 5);
       int pY = transFormY(indexButtonRepere, 5);
    
       for(int i =-1 ;i <= 1 ; i++){
           for(int j = -1 ;j <= 1 ; j++){
                 if(effetBord(i+pX, j+pY)){
                   listButtonProche.add(buttonsAlpha.get(trans2Dto1D(i+pX,j+pY)));
                 }
            }
       }
         
       return listButtonProche;   
    }
    
    public List<Button> adpaterNumeriqueKeyboard(Button buttonRepere){
        
       int indexButtonRepere;
      
       indexButtonRepere = buttonsNumerique.indexOf(buttonRepere);
       List<Button> listButtonProche = new ArrayList<>();
       int pX = transFormX(indexButtonRepere, 3);
       int pY = transFormY(indexButtonRepere, 3);
    
       for(int i =-1 ;i <= 1 ; i++){
           for(int j = -1 ;j <= 1 ; j++){
                 if(effetBord(i+pX, j+pY)){
                   listButtonProche.add(buttonsNumerique.get(trans2Dto1D(i+pX,j+pY)));
                 }
            }
       }
         
       return listButtonProche;   
    }
    
    private int transFormX(int index, int sizeTab){
        return Math.round(index / sizeTab);
    }
    
    private int transFormY(int index, int sizeTab){
        return index % sizeTab;
    }
    
    private int trans2Dto1D(int indexX,int indexY){
        return (indexX * 5 + indexY) ;
    }
    
    private boolean effetBord(int x,int y){
	 return ((x>=0 && x<4) && (y>=0 && y<5));
    }	

}

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
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }           

    @FXML
    public void handleButtonActionAlphaKeyBoard(ActionEvent event) {
        System.out.println(focus.getText());
        
        String textAvant=focus.getText().substring(0,cursorPosition);
        String textApres=focus.getText().substring(cursorPosition,focus.getLength());
        cursorPosition++;
        focus.setText(textAvant+((Button)event.getSource()).getText()+textApres);

        // Button was clicked, do something...
      
        List<Button> listButtonProche =adpaterAlphaKeyboard((Button) event.getSource());


        int nbNode = gridPaneAlpha.getChildren().size();

        for(int i = 0; i < nbNode; i++){
            if(!listButtonProche.contains(gridPaneAlpha.getChildren().get(i))){
                gridPaneAlpha.getChildren().get(i).setVisible(false);
            }
            
            
        }

     }
    
    @FXML
    public void handleButtonActionNumeriqueKeyBoard(ActionEvent event) {
        System.out.println(focus.getText());
        
        String textAvant=focus.getText().substring(0,cursorPosition);
        String textApres=focus.getText().substring(cursorPosition,focus.getLength());
        cursorPosition++;
        focus.setText(textAvant+((Button)event.getSource()).getText()+textApres);
       
        List<Button> listButtonProche = adpaterNumeriqueKeyboard((Button) event.getSource());       
        
        int nbNode = gridPaneNumerique.getChildren().size();
        
        for(int i = 0; i < nbNode; i++){
            if(!listButtonProche.contains(gridPaneNumerique.getChildren().get(i))){
                gridPaneNumerique.getChildren().get(i).setVisible(false);
            }
            
            
        }

     }
    
    private List<Button> adpaterAlphaKeyboard(Button buttonRepere){
                
        
       int indexButtonRepere; 
       // System.out.println("Alpha "+buttonsAlpha.size());
       indexButtonRepere = buttonsAlpha.indexOf(buttonRepere);
        System.out.println("indexButtonRepere "+indexButtonRepere);
       List<Button> listButtonProche = new ArrayList<>();
       int pX = transFormX(indexButtonRepere, 5);
       int pY = transFormY(indexButtonRepere, 5);
       System.out.println("pX "+pX+" pY"+pY);
       for(int i =-1 ;i <= 1 ; i++){
           for(int j = -1 ;j <= 1 ; j++){
                 if(effetBord(i+pX, j+pY,5,4)){   
                   listButtonProche.add(buttonsAlpha.get(trans2Dto1D(i+pX,j+pY,5)));
                 }
            }
       }
      
        System.out.println(listButtonProche);
       return listButtonProche;   
    }
    
    private List<Button> adpaterNumeriqueKeyboard(Button buttonRepere){
        
       int indexButtonRepere;
      
       indexButtonRepere = buttonsNumerique.indexOf(buttonRepere);
       List<Button> listButtonProche = new ArrayList<>();
       int pX = transFormX(indexButtonRepere, 3);
       int pY = transFormY(indexButtonRepere, 3);
    
       for(int i =-1 ;i <= 1 ; i++){
           for(int j = -1 ;j <= 1 ; j++){
                 if(effetBord(i+pX, j+pY,3,2)){
                   listButtonProche.add(buttonsNumerique.get(trans2Dto1D(i+pX,j+pY,3)));
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
    
    private int trans2Dto1D(int indexX,int indexY,int nbColum){
        return (indexX * nbColum + indexY) ;
    }
    
    private boolean effetBord(int x,int y,int maxX,int maxY){
         return ((x>=0 && x<=maxX) && (y>=0 && y<=maxY));
    }	


}

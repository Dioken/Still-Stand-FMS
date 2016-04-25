/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author mars
 */
public class ClavierController implements Initializable {

    @FXML
    private List<Button> buttonsAlpha;
//celia delga à lundi 10h    
//0531088021
    
     @FXML
    private List<Button> buttonsNumerique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Test");
        System.out.println( rb.getObject("a"));
    }    
    
    public java.awt.Button[][] adpaterKeyboard(java.awt.Button buttonRepere, List<java.awt.Button> listButton){
        
       int indexButtonRepere = 0;
       
       indexButtonRepere = listButton.indexOf(buttonRepere);
      
       java.awt.Button[][] buttonProche = new java.awt.Button[3][3];
       
       int pX = transFormX(indexButtonRepere, 6);
       int pY = transFormY(indexButtonRepere, 6);
       
       for(int i =-1 ;i <= 1 ; i++){
           for(int j = -1 ;j <= 1 ; j++){
               if(effetBord(i+pX, j+pY)){
                   buttonProche[i][j] = listButton.get(trans2Dto1D(i+pX,j+pY));
               }
           }
       }
         
       return buttonProche;   
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
	 return ((x>=0 && x<5) && (y>=0 && y<6));
    }	

}

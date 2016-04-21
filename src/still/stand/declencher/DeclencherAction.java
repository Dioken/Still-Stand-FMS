/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package still.stand.declencher;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

/**
 *
 * @author bah
 */
public class DeclencherAction {
     @FXML //  fx:id="myButton"
    private Button jbuttonCLB;
     
     public DeclencherAction(){
         System.out.println(jbuttonCLB.getSize());
     }
   
}

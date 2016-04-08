/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stillStandFMS;

import fxml.MenuOverviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author QYL
 */
public class StillStandFMS extends Application {
    private Stage primaryStage;
    private Scene scene;
    private FXMLLoader loaderCenter;
    private FXMLLoader loaderMain;    
    private BorderPane rootBorder;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MCDU");
        
        initRootLayout();
        showMenuView();
        
        chargerMenuController();        
    }
 
    public void initRootLayout(){
        try {
            loaderMain=new FXMLLoader();
            loaderMain.setLocation(StillStandFMS.class.getResource("../fxml/Root.fxml"));
            rootBorder = (BorderPane)loaderMain.load();
            
            scene = new Scene(rootBorder);   
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
          System.err.println("Erreur au chargement: " + ex);
        }
    }

    public void showMenuView(){
        try {
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/Menu.fxml"));
            AnchorPane menuView = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(menuView);
        } catch (IOException ex) {
          System.err.println("Erreur au chargement: " + ex);
        }
    }

    public void chargerMenuController(){       
        MenuOverviewController menuController = loaderCenter.getController();
        menuController.setStillStandFMS(rootBorder);

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
<Label layoutX="270.0" layoutY="20.0" prefHeight="27.0" prefWidth="52.0" text="APPR" textFill="#09b52c">
         <font>
            <Font size="18.0" />
         </font>
      </Label>
      <Label layoutX="140.0" layoutY="40.0" prefHeight="15.0" prefWidth="37.0" text="DEST" />
      <Label layoutX="140.0" layoutY="64.0" text="QNH" />
      <Label layoutX="260.0" layoutY="64.0" text="FLP_RETR" />
      <Label layoutX="392.0" layoutY="64.0" text="FINAL" />
      <Label layoutX="139.0" layoutY="79.0" text="1015" textFill="#11cdee" />
      <Label layoutX="260.0" layoutY="79.0" text="F=" />
      <Label layoutX="285.0" layoutY="79.0" text="116" textFill="#09b52c" />
      <Label layoutX="394.0" layoutY="79.0" text="ILS27R" textFill="#09b52c" />
      <Label layoutX="139.0" layoutY="108.0" text="TEMP" />
      <Label layoutX="261.0" layoutY="108.0" text="SLT_RETR" />
      <Label layoutX="394.0" layoutY="108.0" text="MDA" />
      <Label layoutX="140.0" layoutY="123.0" text="15°" textFill="#11cdee" />
      <Label layoutX="393.0" layoutY="123.0" text="280" textFill="#11cdee" />
      <Label layoutX="261.0" layoutY="123.0" text="S=" />
      <Label layoutX="285.0" layoutY="123.0" text="186" textFill="#09b52c" />
      <Label layoutX="117.0" layoutY="152.0" text="MAG" />
      <Label layoutX="162.0" layoutY="152.0" text="WIND" />
      <Label layoutX="120.0" layoutY="167.0" text="240" textFill="#11cdee" />
      <Label layoutX="162.0" layoutY="167.0" text="12" textFill="#11cdee" />
      <Label layoutX="148.0" layoutY="167.0" text="°/" textFill="#11cdee" />
      <Label layoutX="263.0" layoutY="152.0" text="CLEAN" />
      <Label layoutX="261.0" layoutY="167.0" text="O=" />
      <Label layoutX="285.0" layoutY="167.0" text="208" textFill="#09b52c" />
      <Label layoutX="396.0" layoutY="152.0" text="DH" />
      <Label layoutX="399.0" layoutY="167.0" text="[ ]" textFill="#11cdee" />
      <Label layoutX="122.0" layoutY="193.0" text="TRANS ALT" />
      <Label layoutX="381.0" layoutY="193.0" text="LDG CONF" />
      <Label layoutX="135.0" layoutY="208.0" text="6000" textFill="#11cdee" />
      <Label layoutX="393.0" layoutY="208.0" text="CONF3*" textFill="#11cdee" />
      <Label layoutX="135.0" layoutY="241.0" text="VAPP" />
      <Label layoutX="265.0" layoutY="241.0" text="VLS" />
      <Label layoutX="135.0" layoutY="256.0" text="137" textFill="#11cdee" />
      <Label layoutX="263.0" layoutY="256.0" text="132" textFill="#09b52c" />
      <Button layoutX="160.0" layoutY="347.0" mnemonicParsing="false" prefHeight="23.0" prefWidth="90.0" text="FLN PAGE" />
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sttill.stand.fms.test;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import controller.ClavierController;
import javafx.scene.control.Button;
/**
 *
 * @author mars
 */
public class ClavierTest {
    
    @Test
    public void testAdpaterKeyboard(){
        
        //Given
        ClavierController clavier = new ClavierController();
        Button b1 = new Button("a");
        Button b2 = new Button("b");
        Button b3 = new Button("c");
        Button b4 = new Button("d");
        Button b5 = new Button("e");
        Button b6 = new Button("f");
        Button b7 = new Button("g");
        Button b8 = new Button("h");
        Button b9 = new Button("i");
        Button b10 = new Button("j");
        Button b11= new Button("k");
        Button b12 = new Button("l");
        
        Button b13 = new Button("m");
        Button b14= new Button("n");
        Button b15 = new Button("o");
        Button b16 = new Button("p");
        Button b17= new Button("q");
        Button b18 = new Button("r");
        Button b19 = new Button("s");
        Button b20= new Button("t");
        Button b21 = new Button("u");
        Button b22 = new Button("v");
        Button b23 = new Button("w");
        Button b24 = new Button("y");
        Button b25 = new Button("z");
        Button b26 = new Button("slash");
        Button b27 = new Button("sp");
        Button b28 = new Button("del");
        Button b29 = new Button("clr");
    
        
        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(b7);
        buttonList.add(b8);
        buttonList.add(b9);
        buttonList.add(b10);
        buttonList.add(b11);
        buttonList.add(b12);
        
        buttonList.add(b13);
        buttonList.add(b14);
        buttonList.add(b15);
        buttonList.add(b16);
        buttonList.add(b17);
        buttonList.add(b18);
        buttonList.add(b19);
        buttonList.add(b20);
        buttonList.add(b21);
        buttonList.add(b22);
        buttonList.add(b23);
        buttonList.add(b24);
        buttonList.add(b25);
        buttonList.add(b26);
        buttonList.add(b27);
        buttonList.add(b28);
        buttonList.add(b29);

      

        //then 
      //  List<Button> arrayButton = clavier.adpaterNumeriqueKeyboard2(b25, buttonList);
        
        List<Button> expectArrayButton = new ArrayList<>();
        expectArrayButton.add(b1);
        expectArrayButton.add(b2);
        expectArrayButton.add(b3);
        expectArrayButton.add(b5);
        expectArrayButton.add(b6);
        expectArrayButton.add(b7);
        expectArrayButton.add(b9);
        expectArrayButton.add(b10);
        expectArrayButton.add(b11);
       
       /* Assert.assertEquals(expectArrayButton[1][0].getLabel(), arrayButton[1][0].getLabel());
        Assert.assertEquals(expectArrayButton[1][1].getLabel(), arrayButton[1][1].getLabel());
        Assert.assertEquals(expectArrayButton[1][2].getLabel(), arrayButton[1][2].getLabel());
        Assert.assertEquals(expectArrayButton[2][0].getLabel(), arrayButton[2][0].getLabel());
        Assert.assertEquals(expectArrayButton[2][1].getLabel(), arrayButton[2][1].getLabel());*/
   
    }

}

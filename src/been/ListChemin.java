/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package been;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author QYL
 */
public class ListChemin {
    private final StringProperty  from;
    private final StringProperty  dest;
    private final StringProperty  dist;
    private final StringProperty  radio;
    
    public ListChemin(String from,String dest,String dist,String radio){
        this.from = new SimpleStringProperty(from);
        this.dest = new SimpleStringProperty(dest);
        this.dist = new SimpleStringProperty(dist);
        this.radio = new SimpleStringProperty(radio);
    }
    
    public void setFrom(String from){
        this.from.set(from);
    }
    public String getFrom(){
        return this.from.get();
    }
    
    public StringProperty fromProperty() {
        return from;
    }
    
    public void setDest(String dest){
        this.dest.set(dest);
    }
    public String getDest(){
        return this.dest.get();
    }
    public StringProperty destProperty() {
        return dest;
    }
    
    public void setDist(String dist){
        this.dist.set(dist);
    }
    public String getDist(){
        return this.dist.get();
    }
    public StringProperty distProperty() {
        return dist;
    }
    
    public void setRadio(String radio){
        this.radio.set(radio);
    }
    public String getRadio(){
        return this.radio.get();
    }
    public StringProperty radioProperty() {
        return radio;
    }
}

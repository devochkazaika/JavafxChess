package com.chess.Shapes;
import java.util.ArrayList;
import java.util.List;

import com.chess.Shapes.AdditionalClass.Coords;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Figure extends Rectangle {
    boolean white;
    Coords coord;
    // String imageBG = getClass().getResource("pict/pesh.png").toExternalForm();
    String path;
    public boolean is_chosen;
    public boolean alive;


    public Figure(boolean w){
        super();
        setWidth(80.5);
        setHeight(80);
        white = w;
        is_chosen = false;
        this.setFill(new Color(0.1, 0.0, 0.0, 0));

    }
    
    public Figure(){
        this(true);
    }
    public boolean is_alive(){
        return false;
    }

    public List<Coords> moves(Coords coord, Desk desk){
        List<Coords> t = new ArrayList<>();
        t.add(new Coords(0, 0));
        return t;
    }

    public void setFill(){
        super.setFill(new Color(0.1, 0.0, 0.0, 1));
    }

    public final void select(){
        is_chosen = true;
        this.setFill(new Color(0, 1, 0.0, 0.2));
    }
    public final void unSelect(){
        is_chosen = false;
        this.setFill(new Color(0, 1, 0.0, 0));
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

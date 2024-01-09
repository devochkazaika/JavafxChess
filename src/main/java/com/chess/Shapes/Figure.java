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
    public Figure(boolean w){
        super();
        setWidth(80.5);
        setHeight(80);
        white = w;
        this.setFill(new Color(0.1, 0.0, 0.0, 1));

    }
    
    public Figure(){
        this(true);
    }

    public List<Coords> moves(Coords coord){
        List<Coords> t = new ArrayList<>();
        t.add(new Coords(0, 0));
        return t;
    }

    
}

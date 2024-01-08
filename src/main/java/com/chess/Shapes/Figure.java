package com.chess.Shapes;
import java.util.ArrayList;
import java.util.List;

import com.chess.Shapes.AdditionalClass.Coords;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Figure extends Rectangle {
    boolean white;
    Coords coord;
    // String imageBG = getClass().getResource("pict/pesh.png").toExternalForm();
    String path;
    public Figure(boolean w){
        super();
        // setX(35 + 78.5*x);
        // setY(35+78.5*y);
        // coord = new Coords(x, y);
        setWidth(78.5);
        setHeight(78.5);
        white = w;
        path = "pict/pesh";
        if (w == false) path+="_b.png";
        else path+=".png";
        if (getClass().getResource(path) != null) {
            String imageBG = getClass().getResource(path).toString();
            this.setFill(new ImagePattern(new Image(imageBG)));

        } else {
            System.err.println(path);
        }
        // setArcWidth(20);
        // setArcHeight(20);
        
    }
    public Figure(){
        this(1, 1, true);
    }

    public List<Coords> moves(){
        List<Coords> t = new ArrayList<>();
        return t;
    }

    
}

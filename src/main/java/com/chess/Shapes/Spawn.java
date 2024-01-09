package com.chess.Shapes;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import com.chess.Shapes.AdditionalClass.Coords;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Spawn extends Figure{
    public Spawn(boolean w){
        super(w);
        path = "pict/pesh";
        if (w == false) path+="_b.png";
        else path+=".png";
        if (getClass().getResource(path) != null) {
            String imageBG = getClass().getResource(path).toString();
            this.setFill(new ImagePattern(new Image(imageBG)));

        } else {
            System.err.println(path);
        }
    }
    public Spawn(){
        super();
    }
    //возможные ходы пешки
    @Override
    public List<Coords> moves(Coords coord){
        List<Coords> move = new ArrayList<>();
        if (white == false){
            if (coord.y == 1){
                move.add(new Coords(coord.x+0, coord.y+2));
            }
            if (coord.y + 1 < 8){
                move.add(new Coords(coord.x+0, coord.y+1));
            }
        }
        else{
            if (coord.y == 6){
                move.add(new Coords(coord.x+0, coord.y-2));
            }
            if (coord.y - 1 < 8){
                move.add(new Coords(coord.x+0, coord.y-1));
            }
        }
        return move;
    }
}

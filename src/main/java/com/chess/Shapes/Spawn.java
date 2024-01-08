package com.chess.Shapes;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import com.chess.Shapes.AdditionalClass.Coords;

import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class Spawn extends Figure{
    public Spawn(boolean w){
        super(w);
    }
    public Spawn(){
        super();
    }
    //возможные ходы пешки
    @Override
    public List<Coords> moves(){
        List<Coords> move = new ArrayList<>();
        if (white == true){
            if (coord.y + 1 < 8){
                move.add(new Coords(0, 1));
            }
        }
        else{
            if (coord.y - 1 < 8){
                move.add(new Coords(0, -1));
            }
        }
        return move;
    }
}

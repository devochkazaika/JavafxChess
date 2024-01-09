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
    public static boolean shape = true;
    public Spawn(boolean w){
        super(w);
        path = "pict/pesh";
        setFill();
    }
    public Spawn(){
        super();
    }

    @Override
    public boolean is_alive(){
        return true;
    }

    @Override
    public void setFill(){
        if (white == false) path+="_b.png";
        else path+=".png";
        if (getClass().getResource(path) != null) {
            String imageBG = getClass().getResource(path).toString();
            this.setFill(new ImagePattern(new Image(imageBG)));

        } else {
            System.err.println(path);
        }
    }
    //возможные ходы пешки
    @Override
    public List<Coords> moves(Coords coord, Desk desk){
        List<Coords> move = new ArrayList<>();
        Coords point;   //точка назначения
        if (white == false){
            if (coord.y == 1){
                point = new Coords(coord.x+0, coord.y+2);
                if (!desk.hasShape(point))  move.add(point);
            }
            if (coord.y + 1 < 8){
                point = new Coords(coord.x+0, coord.y+1);
                if (!desk.hasShape(point))  move.add(point);
            }
            if (desk.hasShape(new Coords(coord.x+1, coord.y+1))){
                move.add(new Coords(coord.x+1, coord.y+1));
            }
            if (desk.hasShape(new Coords(coord.x-1, coord.y+1))){
                move.add(new Coords(coord.x-1, coord.y+1));
            }
        }
        else{
            //доделать нужно
            if (coord.y == 6){
                point = new Coords(coord.x+0, coord.y-2);
                if (!desk.hasShape(point))  move.add(point);
            }
            if (coord.y - 1 >= 0){
                point = new Coords(coord.x+0, coord.y-1);
                if (!desk.hasShape(point))  move.add(point);
            }
        }
        return move;
    }
}

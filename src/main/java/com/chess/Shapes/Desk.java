package com.chess.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.chess.Shapes.AdditionalClass.Coords;
import com.sun.glass.events.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Desk extends Rectangle {
    public Figure mas[][] = new Figure[8][8];
    String path;
    Pane scene;
    List<Rectangle> latest;
    public Desk(Pane root){
        super(700, 700);
        latest = new ArrayList<Rectangle>();
        scene = root;
        path = "pict/Desk.png";
        scene.getChildren().add(this);
        //армия пешек
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                mas[i][j] = new Figure(true) {
                };
                // mas[i][j].setX(35 + 78.5*i);
                // mas[i][j].setY(35 + 78.5*j);
                // scene.getChildren().add(mas[i][j]);
            }
        }
        for (int i=0; i<8; i++){
            mas[i][1] = new Spawn(false) {};
            mas[i][1].setX(35 + 78.5*i);
            mas[i][1].setY(35 + 78.5*1);
            scene.getChildren().add(mas[i][1]);

            mas[i][6] = new Spawn(true) {};
            mas[i][6].setX(35 + 78.5*i);
            mas[i][6].setY(35 + 78.5*6);
            scene.getChildren().add(mas[i][6]);
        }

        if (getClass().getResource(path) != null) {
            String imageBG = getClass().getResource(path).toString();
            this.setFill(new ImagePattern(new Image(imageBG)));
            
        } else {
            System.err.println(path);
        }
    }

    public Coords getPos(double x, double y){
        return new Coords((int)((x-35)/78.5), (int)((y-35)/78.5));
        
    }

    public void showMoves(Coords coord){
        for (Rectangle rectangle : latest) {
            scene.getChildren().remove(rectangle);
        }
        // System.out.println(coord.y);
        int i = coord.x;
        int j = coord.y;
        System.out.println(j);
        // if (Objects.isNull(i) && Objects.isNull(j)){
        List<Coords> k = (mas[i][j]).moves(coord);
        // }
        // else{
        //     System.out.println(i + " " + j);
        // }
        Color n = new Color(0, 1, 0, 0.2);
        for (Coords a : k) {
            Rectangle t = new Rectangle(78.5, 78.5);
            t.setFill(n);
            t.setX(a.x*78.6+35.5);
            t.setY(a.y*78.6+35.5);
            latest.add(t);
            scene.getChildren().add(t);
        }
    }
    // private void arrage(){

    //     for (int i=0; i<8; i++){

    //     }
    // }
}

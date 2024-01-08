package com.chess.Shapes;

import java.util.List;

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
        scene = root;
        path = "pict/Desk.png";
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                mas[i][j] = new Figure(true) {
                    
                };
            }
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
        // for (Rectangle rectangle : latest) {
        //     scene.getChildren().remove(rectangle);
        // }
        System.out.println(coord.y);
        List<Coords> k = (mas[coord.x][coord.y]).moves();
        // // Rectangle t = new Rectangle(78.5, 78.5);
        // // Color n = new Color(0, 1, 0, 0.2);
        // // t.setFill(n);
        // // t.setX(coord.x*78.5+35);
        // // t.setY(coord.y*78.5+35);
        // // scene.getChildren().add(t);
        // for (Coords a : k) {
        //     Rectangle t = new Rectangle(78.5, 78.5);
        //     Color n = new Color(0, 1, 0, 0.2);
        //     t.setFill(n);
        //     t.setX(a.x*78.5+35);
        //     t.setY(a.y*78.5+35);
        //     latest.add(t);
        //     scene.getChildren().add(t);
        // }
    }
    // private void arrage(){

    //     for (int i=0; i<8; i++){

    //     }
    // }
}

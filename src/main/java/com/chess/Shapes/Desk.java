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
    List<Coords> latest;

    double step = 78.5;
    double margin = 35;

    int lat_i;
    int lat_j;

    public Desk(Pane root){
        super(700, 700);
        latest = new ArrayList<Coords>();
        scene = root;
        path = "pict/Desk.png";
        scene.getChildren().add(this);
        //армия пешек
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                mas[i][j] = new Figure(true) {
                };
                scene.getChildren().add(mas[i][j]);
            }
        }
        for (int i=0; i<8; i++){
            mas[i][1] = new Spawn(false) {};
            mas[i][1].setX(margin + step*i);
            mas[i][1].setY(margin + step*1);
            scene.getChildren().add(mas[i][1]);

            mas[i][6] = new Spawn(true) {};
            mas[i][6].setX(margin + step*i);
            mas[i][6].setY(margin + step*6);
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
        return new Coords((int)((x-margin)/step), (int)((y-margin)/step));
        
    }
    //показ возможных ходов
    public void showMoves(Coords coord){
        for (Coords a : latest) {
            scene.getChildren().remove(mas[a.x][a.y]);
            mas[a.x][a.y].unSelect();
        }
        int i = coord.x;
        int j = coord.y;
        lat_i = i;
        lat_j = j;
        //множество доступных ходов
        List<Coords> k = (mas[i][j]).moves(coord, this);

        //закраска возможных ходов
        for (Coords a : k) {
            scene.getChildren().remove(mas[a.x][a.y]);
            mas[a.x][a.y].select();
            mas[a.x][a.y].setX(margin + step*a.x);
            mas[a.x][a.y].setY(margin + step*a.y);
            scene.getChildren().add(mas[a.x][a.y]);
            latest.add(new Coords(a.x, a.y));
        }
    }

    //подвинуть фигуру
    public void moveShape(Coords a){
        for (Coords n : latest) {
            mas[n.x][n.y].unSelect();
            scene.getChildren().remove(mas[n.x][n.y]);
        }
        Figure t = mas[a.x][a.y];
        mas[a.x][a.y] = mas[lat_i][lat_j];
        mas[lat_i][lat_j] = t;
        arrage();
        latest = new ArrayList<>(); 
    }

    //расстановка фигур согласно mas
    private void arrage(){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                scene.getChildren().remove(mas[i][j]);
                mas[i][j].setX(margin + step*i);
                mas[i][j].setY(margin + step*j);
                scene.getChildren().add(mas[i][j]);
            }
        }   
    }

    //проверка есть ли фигура на этом месте
    public boolean hasShape(Coords a){
        return mas[a.x][a.y].is_alive();
    }
}

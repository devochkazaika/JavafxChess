package com.chess;

import com.chess.Shapes.Desk;
import com.chess.Shapes.Figure;
import com.chess.Shapes.Spawn;
import com.chess.Shapes.AdditionalClass.Coords;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    Pane root;
    String path_desk;
    Scene scene;
    Desk desk;
    @Override
    public void start(Stage stage) {
        root = new Pane();
        scene = new Scene(root, 800, 800, Color.WHITESMOKE);
        desk = new Desk(root);

        //кликанье по доске
        scene.setOnMouseClicked(mouseevent ->{
            Coords t = desk.getPos(mouseevent.getX(), mouseevent.getY());
            desk.showMoves(t);
            
        });

        initUI(stage);
    }
    private void initUI(Stage stage) {
        var canvas = new Canvas(800, 800);
        root.getChildren().add(desk);

        // Spawn t = new Spawn();
        // root.getChildren().add(t);
        Spawn t2 = new Spawn(2, 3, false);

        root.getChildren().add(t2);
        // root.getChildren().add(b);
        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

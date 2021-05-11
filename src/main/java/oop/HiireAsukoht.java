package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import java.io.FileInputStream;

import static javafx.application.Application.launch;

public class HiireAsukoht extends Application{

    public void start(Stage primaryStage) throws Exception{
        // vaja lava
        primaryStage.setTitle("Hiire koordinaadid.");


        // proovimine
        // pildi loomine
        Image image = new Image(new FileInputStream("src/kaart.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(25);
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        Group root = new Group(imageView);



        // nupuvajutamise teema
        imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // hiirevajutuse koordinaadid
                double x = event.getSceneX();
                double y = event.getSceneY();

                Label koordinaadid = new Label("(" + Math.round(x) + ", " + Math.round(y) + ")");

                koordinaadid.setTranslateX(x);
                koordinaadid.setTranslateY(y);
                root.getChildren().add(koordinaadid);
            }
        });

        imageView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().remove(root.getChildren().size()-1);
            }
        });

        // lisame lavale stseeni hbox
        primaryStage.setScene(new Scene(root));
        // kuvame lava



        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

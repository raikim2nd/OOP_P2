package oop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static javafx.application.Application.launch;

public class HiireAsukoht extends Application{

    public void start(Stage primaryStage) throws Exception{
        // vaja lava
        primaryStage.setTitle("Hiire koordinaadid.");
        // kasutame hboxi
        HBox hbox = new HBox();

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
        Scene scene = new Scene(root,600,500);
        primaryStage.setScene(scene);

        /*
        // nupuvajutamise teema
        hbox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // hiirevajutuse koordinaadid
                double x = event.getSceneX();
                double y = event.getSceneY();

                Label koordinaadid = new Label("(" + Math.round(x) + ", " + Math.round(y) + ")");

                koordinaadid.setTranslateX(x);
                koordinaadid.setTranslateY(y);
                hbox.getChildren().add(koordinaadid);
            }
        });

        hbox.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hbox.getChildren().clear();
            }
        });
        // lisame lavale stseeni hbox
        //primaryStage.setScene(new Scene(hbox));
        // kuvame lava


         */
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package oop;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



import java.io.FileInputStream;
import java.util.*;

import static javafx.application.Application.launch;

public class HiireAsukoht extends Application {

    int punktid = 0;

    public void start(Stage primaryStage) throws Exception {
        // vaja lava
        primaryStage.setTitle("Maakondade mäng");


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

        int radius = 10;
        Circle hiiu = new Circle(126, 208, radius);
        Circle lääne = new Circle(211, 209, radius);
        Circle harju = new Circle(277, 141, radius);
        Circle lääne_viru = new Circle(395, 157, radius);
        Circle saare = new Circle(117, 276, radius);
        Circle ida_viru = new Circle(469, 169, radius);
        Circle järva = new Circle(343, 204, radius);
        Circle jõgeva = new Circle(401, 230, radius);
        Circle pärnu = new Circle(257, 270, radius);
        Circle viljandi = new Circle(337, 287, radius);
        Circle rapla = new Circle(274, 202, radius);
        Circle võru = new Circle(434, 364, radius);
        Circle tartu = new Circle(423, 279, radius);
        Circle põlva = new Circle(453, 322, radius);
        Circle valga = new Circle(373, 340, radius);


        List<Circle> circleList = new ArrayList<>(Arrays.asList(saare, hiiu, lääne, harju, lääne_viru, ida_viru, rapla, järva, jõgeva, pärnu, viljandi, tartu, valga, põlva, võru));
        for (Circle circle : circleList) {
            circle.setFill(Color.BLACK);

            circle.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    if (circle.getFill() != Color.RED && circle.getFill() != Color.GREEN)
                        circle.setFill(Color.YELLOW);
                }
            });

            circle.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    if (circle.getFill() != Color.RED && circle.getFill() != Color.GREEN) {
                        circle.setFill(Color.BLACK);
                    }

                }
            });

            root.getChildren().add(circle);
        }


        primaryStage.setScene(new Scene(root));
        // kuvame lava


        primaryStage.show();

        List<Kusimus> kusimused = new ArrayList<>();
        Kusimus esimene = new Kusimus("Kus asuvad Piusa koopad?", 434, 364);
        Kusimus teine = new Kusimus("Kus asub Kaali kraater? ", 117, 276);
        kusimused.add(esimene);
        kusimused.add(teine);
        for (int i = 0; i < kusimused.size(); i++) {



            System.out.println("Hetkel on sul " + punktid + "punkti.");
            System.out.println(kusimused.get(i).getKusimus());
            //Nii saab küsimusi lisada
            Label kusimus = new Label(kusimused.get(i).getKusimus());
            root.getChildren().add(kusimus);
            int finalI = i;

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {


                    Point2D point2D = new Point2D(event.getX(), event.getY());
                    for (Circle circle : circleList) {

                        if (circle.contains(point2D)) {
                            if (!circle.contains(kusimused.get(finalI).getX(), kusimused.get(finalI).getY())) {

                                circle.setFill(Color.RED);
                                punktidMiinus();
                            } else {
                                circle.setFill(Color.GREEN);
                                punktidPluss();


                            }
                        }

                    }


                }


            });


        }


    }

    public void punktidMiinus() {
        punktid -= 10;
    }

    public void punktidPluss() {
        punktid += 10;
    }


    public static void main(String[] args) {
        launch(args);
    }

}

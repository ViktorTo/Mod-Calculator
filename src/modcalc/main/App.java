package modcalc.main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    private double yOffset;
    private double xOffset;

    @FXML
    private AnchorPane rootPane;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/sample/resources/mainWindow.fxml"));
        Scene home = new Scene(root);

        root.setOnMousePressed(e -> {

            /*
             * yOffset = primaryStage.getY() - e.getScreenY(); xOffset = primaryStage.getX()
             * - e.getScreenX();
             */

            yOffset = e.getScreenY();
            xOffset = e.getScreenX();

            System.out.println(yOffset);
            System.out.println(xOffset);

        });

        root.setOnMouseDragged(e -> {

            primaryStage.setX(e.getSceneX() + xOffset);
            primaryStage.setY(e.getSceneY() + yOffset);

        });

        primaryStage.setTitle("MOD-CALCULATOR");
        primaryStage.setOpacity(0.96);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(home);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

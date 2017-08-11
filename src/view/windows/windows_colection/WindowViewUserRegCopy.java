package view.windows.windows_colection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by myasnikov
 * on 10.08.2017.
 */
public class WindowViewUserRegCopy extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample_fxml/user_reg.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //primaryStage.setTitle("Sheet Amount");
        assert root != null;
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void create() {
        launch();
    }
}

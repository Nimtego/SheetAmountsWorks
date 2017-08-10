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
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SheetAmountLoginWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }
    public void run(String[] args) {
        launch(args);
    }
}

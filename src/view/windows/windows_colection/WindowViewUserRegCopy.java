package view.windows.windows_colection;

import controller.micro_controllers.MicroController;
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
    private MicroController microController;
    public WindowViewUserRegCopy() {
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample_fxml/user_reg.fxml"));
        Parent root = loader.load();
        this.microController = loader.getController();
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void create() {
        launch();
    }
}

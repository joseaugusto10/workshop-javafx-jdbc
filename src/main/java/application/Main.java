package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Use um caminho relativo ao diretório de trabalho atual
            URL fxmlURL = new File("src/Main/Java/view/MainView.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}


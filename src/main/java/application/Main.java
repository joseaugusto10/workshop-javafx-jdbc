package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    private static Scene mainScene;

    @Override
    public void start(Stage stage) {
        try {
            // Carregue o arquivo FXML em um AnchorPane
            URL fxmlURL = new File("src/Main/Java/view/MainView.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            ScrollPane scrollPane = fxmlLoader.load();

            // Configurar o tamanho preferencial do ScrollPane
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            // Crie uma cena com o ScrollPane
            // Esse é meu palco
            mainScene = new Scene(scrollPane);
            stage.setTitle("Hello!");
            stage.setScene(mainScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Scene getMainScene(){
        return mainScene;
    }
    public static void main(String[] args) {
        launch();
    }
}


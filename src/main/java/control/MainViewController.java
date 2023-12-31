package control;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;
import view.util.Alerts;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.function.Consumer;

public class MainViewController implements Initializable{
    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemItemAbout;

    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }
    @FXML
    public void onMenuItemDepartmentAction(){
        loadView("src/main/java/view/DepartmentList.fxml",(DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }
    @FXML
    public void onMenuItemAboutAction(){
        loadView("src/main/java/view/About.fxml",x ->{});
    }

    @Override
    public void initialize(URL url,ResourceBundle rb){
    }

    //Método carregar outra tela em cima do palco principal
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction){
        try {
            URL fxmlURL = new File(absoluteName).toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            VBox newVbox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());

            T controller = loader.getController();
            initializingAction.accept(controller);

        }catch (IOException e){
            Alerts.showAlert("IO Exception", "Error loading view",e.getMessage(), Alert.AlertType.ERROR);
        }
    }


}

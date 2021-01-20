package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Panel panel = new Panel("This is the title");
//        panel.getStyleClass().add("panel-primary");           //(2)
//        BorderPane content = new BorderPane();
//
//        content.setPadding(new Insets(5));
//
//        Button button = new Button("Hello BootstrapFX");
//        button.getStyleClass().setAll("btn","btn-warning");    //(2)
//
//        Button button1 = new Button("Hello BootstrapFX");
//        button1.getStyleClass().setAll("btn","btn-success","btn-xs");    //(2)
//
//        Label l1 = new Label("LLLLLLLLLLLLLLLLLLLLLLL");
//        l1.getStyleClass().setAll("strong","i", "text-primary", "bg-primary", "code");
//
//        SplitMenuButton splitMenuButton = new SplitMenuButton();
//        splitMenuButton.setText("111111111111111111");
//        splitMenuButton.getStyleClass().setAll("split-menu-btn", "split-menu-btn-primary");
//
//        VBox anchorPane = new VBox();
//        anchorPane.getChildren().addAll(button, button1, l1, splitMenuButton);
//
//        content.setCenter(anchorPane);
//        panel.setBody(content);
//        panel.setFooter(new Button("123131"));
//        panel.setHeading(new Button("123131"));
//
//        Scene scene = new Scene(panel);
//        primaryStage.setTitle("BootstrapFX");
//        primaryStage.setScene(scene);
//        primaryStage.sizeToScene();
//        primaryStage.getScene().getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
//        primaryStage.show();


        Parent show = new Controller().show();

        Scene scene = new Scene(show);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

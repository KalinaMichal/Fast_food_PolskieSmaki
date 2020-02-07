package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("pl"));
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("menu.fxml"));
        root = loader.load();
        primaryStage.setTitle("Login");
        Scene s = new Scene(root);
        //dodajemy plik css
        s.getStylesheets().add(getClass().getResource("/css/basicStylesheet.css").toExternalForm());
        primaryStage.setScene(s);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(windowEvent -> {
            System.exit(1);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package controllers;

import database.connection.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.Accessibility;
import services.Service;

import java.io.IOException;

public class MenuController implements EventHandler<ActionEvent> {
    public Button buttonStartWorker;
    public Button buttonStartDirector;
    public Button buttonStartOwner;

    @FXML
    public void initialize() {
        buttonStartDirector.setOnAction(this);
        buttonStartOwner.setOnAction(this);
        buttonStartWorker.setOnAction(this);
    }

    private void startLoginFrame(String title)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("loginFrame.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle(title);
                    //dodajemy stylescheet
                    Scene s = new Scene(root);
                    s.getStylesheets().add(getClass().getResource("/css/basicStylesheet.css").toExternalForm());
                    stage.setScene(s);
                    stage.setResizable(false);
                    stage.show();
                    //ustawiamy zamknięcie aplikacji
                    stage.setOnCloseRequest(windowEvent -> {
                        System.exit(1);
                    });

                    buttonStartDirector.getScene().getWindow().hide();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().equals(buttonStartWorker))
        {
            Service service = Service.getInstance();
            service.setAccessibility(Accessibility.WORKER);
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.setLogin("worker");
            databaseConnection.setPassword("worker");
            startLoginFrame("Login Frame Worker");
        }
        if(e.getSource().equals(buttonStartDirector))
        {
            Service service = Service.getInstance();
            service.setAccessibility(Accessibility.DIRECTOR);
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.setLogin("director");
            databaseConnection.setPassword("director");
            startLoginFrame("Login Frame Director");
        }
        if(e.getSource().equals(buttonStartOwner))
        {
            Service service = Service.getInstance();
            service.setAccessibility(Accessibility.OWNER);
            startLoginFrame("Login Frame Owner");
        }
    }
}

package controllers;

import database.connection.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.Accessibility;
import services.Service;

import java.io.IOException;

public class LoginFrameController implements EventHandler<ActionEvent> {

    public Label labelLogin;
    public TextField textFieldLogin;
    public Label labelPassword;
    public TextField textFieldPassword;
    public Button buttonSignUp;

    private Accessibility accessibility;
    @FXML
    public void initialize() {
        buttonSignUp.setOnAction(this);
        Service service = Service.getInstance();
        accessibility = service.getAccessibility();
    }
    private void showError(String message)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Sadly error occurred cannot do anything about it...");
                    alert.setContentText(message);
                    alert.showAndWait();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    private void startWindow(String fileName, String title)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource(fileName));
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

                    buttonSignUp.getScene().getWindow().hide();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    private void startWorkerFrame()
    {
        startWindow("workerFrame.fxml","Worker App");
    }
    private void startDirectorFrame()
    {
        startWindow("directorFrame.fxml", "Director App");
    }
    private void startOwnerFrame()
    {
        startWindow("ownerFrame.fxml", "Owner App");
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().equals(buttonSignUp))
        {
            String login = textFieldLogin.getText();
            String password = textFieldPassword.getText();
            Service service = Service.getInstance();
            switch (accessibility)
            {
                case WORKER:
                    service.setLogin(login);
                    if(service.logAsWorker(login,password))
                    {
                        startWorkerFrame();
                    }
                    else
                    {
                        showError("Please insert correct data");
                    }
                    break;
                case DIRECTOR:
                    if(service.logAsDirector(login,password))
                    {
                        startDirectorFrame();
                    }
                    else
                    {
                        showError("Please insert correct data");
                    }
                    break;
                case OWNER:
                    if(!login.equals("owner") || ! password.equals("owner"))
                    {
                        showError("incorrect data");
                    }
                    else
                    {
                        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
                        databaseConnection.setLogin("owner");
                        databaseConnection.setPassword("owner");
                        startOwnerFrame();
                    }
                    break;
            }
        }
    }
}

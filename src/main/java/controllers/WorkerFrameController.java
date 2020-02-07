package controllers;

import database.structure.DirectorData;
import database.structure.WorkerData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import services.Service;

public class WorkerFrameController implements EventHandler<ActionEvent> {
    public Button buttonMyInfo;
    public Button buttonDirectorContact;
    public Label labelLoggedAs;
    public Label labelLogin;
    public TextArea textAreaOutcome;

    private Service service;

    @FXML
    public void initialize() {
            buttonDirectorContact.setOnAction(this);
            buttonMyInfo.setOnAction(this);

            service = Service.getInstance();
            labelLogin.setText(service.getLogin());
    }
    private void showError()
    {
        System.out.println("Something went wrong");
    }
    private void getDirectorContact()
    {
        DirectorData directorData = service.getDirector();
        if(directorData==null)
        {
            showError();
        }
        else
        {
            String display = directorData.toString();
            textAreaOutcome.setText(display);
        }
    }
    private void getMyInfo()
    {
        WorkerData workerData = service.getWorker();
        if(workerData==null)
        {
            showError();
        }
        else
        {
            String display = workerData.toString();
            textAreaOutcome.setText(display);
        }
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().equals(buttonDirectorContact))
        {
            getDirectorContact();
        }
        if(e.getSource().equals(buttonMyInfo))
        {
            getMyInfo();
        }
    }
}

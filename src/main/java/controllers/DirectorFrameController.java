package controllers;

import database.structure.WorkerComplexData;
import database.structure.WorkerData;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import services.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectorFrameController implements EventHandler<ActionEvent> {
    public Button buttonAddWorker;
    public Button buttonDeleteWorker;
    public Button buttonShowWorkers;
    public Button buttonModifyWorker;
    public Button buttonBonus;
    public TextArea textAreaOutcome;
    public Button buttonShowPartTimeWorkers;

    private Service service;
    @FXML
    public void initialize() {
        buttonAddWorker.setOnAction(this);
        buttonBonus.setOnAction(this);
        buttonDeleteWorker.setOnAction(this);
        buttonModifyWorker.setOnAction(this);
        buttonShowPartTimeWorkers.setOnAction(this);
        buttonShowWorkers.setOnAction(this);

        service = Service.getInstance();
    }
    private void showSuccess()
    {
        System.out.println("Success!");
    }
    private void showError()
    {
        System.out.println("Something went wrong....");
    }
    private WorkerData getWorkerData(String title, String header)
    {
        WorkerData workerData = null;
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(header);


// Set the button types.
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField textFieldSalary = new TextField();
        TextField textFieldBranchId = new TextField();
        TextField textFieldPositionId = new TextField();
        TextField textFieldWorkTime = new TextField();
        TextField textFieldName = new TextField();
        TextField textFieldSurname = new TextField();
        TextField textFieldPesel = new TextField();
        TextField textFieldDateOfBirth = new TextField();
        TextField textFieldNationality = new TextField();
        TextField textFieldPhone = new TextField();
        TextField textFieldAddress = new TextField();

        grid.add(new Label("Salary:"), 0, 0);
        grid.add(textFieldSalary, 1, 0);
        grid.add(new Label("Branch ID:"), 0, 1);
        grid.add(textFieldBranchId, 1, 1);
        grid.add(new Label("Position ID: "), 0,2);
        grid.add(textFieldPositionId, 1, 2);
        grid.add(new Label("Work Time: "), 0, 3);
        grid.add(textFieldWorkTime, 1,3);
        grid.add(new Label("Name: "),0,4);
        grid.add(textFieldName, 1, 4);
        grid.add(new Label("Surname: "),0,5);
        grid.add(textFieldSurname, 1, 5);
        grid.add(new Label("Pesel: "),0,6);
        grid.add(textFieldPesel, 1, 6);
        grid.add(new Label("Date of birth: "),0,7);
        grid.add(textFieldDateOfBirth, 1, 7);
        grid.add(new Label("Nationality: "),0,8);
        grid.add(textFieldNationality, 1, 8);
        grid.add(new Label("Phone: "),0,9);
        grid.add(textFieldPhone, 1, 9);
        grid.add(new Label("Address: "),0,10);
        grid.add(textFieldAddress, 1, 10);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            int salary = Integer.parseInt(textFieldSalary.getText());
            int branchId = Integer.parseInt(textFieldBranchId.getText());
            int positionId = Integer.parseInt(textFieldPositionId.getText());
            String workTime = textFieldWorkTime.getText();
            String name = textFieldName.getText();
            String surname = textFieldSurname.getText();
            String pesel = textFieldPesel.getText();
            String dateOfBirth = textFieldDateOfBirth.getText();
            String nationality = textFieldNationality.getText();
            String phone = textFieldPhone.getText();
            String address = textFieldAddress.getText();
            workerData = new WorkerData(salary, branchId, positionId, workTime,  name, surname, pesel, dateOfBirth, nationality, phone, address);
        }
        return workerData;
    }
    private WorkerComplexData getWorkerComplexData(String title, String header)
    {
        WorkerComplexData workerComplexData = null;
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(header);


// Set the button types.
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField textFieldSalary = new TextField();
        TextField textFieldBranchId = new TextField();
        TextField textFieldPositionId = new TextField();
        TextField textFieldWorkTime = new TextField();
        TextField textFieldLogin = new TextField();
        TextField textFieldPassword = new TextField();
        TextField textFieldName = new TextField();
        TextField textFieldSurname = new TextField();
        TextField textFieldPesel = new TextField();
        TextField textFieldDateOfBirth = new TextField();
        TextField textFieldNationality = new TextField();
        TextField textFieldPhone = new TextField();
        TextField textFieldAddress = new TextField();

        grid.add(new Label("Salary:"), 0, 0);
        grid.add(textFieldSalary, 1, 0);
        grid.add(new Label("Branch ID:"), 0, 1);
        grid.add(textFieldBranchId, 1, 1);
        grid.add(new Label("Position ID: "), 0,2);
        grid.add(textFieldPositionId, 1, 2);
        grid.add(new Label("Work Time: "), 0, 3);
        grid.add(textFieldWorkTime, 1,3);
        grid.add(new Label("Login: "),0,4);
        grid.add(textFieldLogin, 1, 4);
        grid.add(new Label("Password: "), 0,5);
        grid.add(textFieldPassword,1, 5 );
        grid.add(new Label("Name: "),0,6);
        grid.add(textFieldName, 1, 6);
        grid.add(new Label("Surname: "),0,7);
        grid.add(textFieldSurname, 1, 7);
        grid.add(new Label("Pesel: "),0,8);
        grid.add(textFieldPesel, 1, 8);
        grid.add(new Label("Date of birth: "),0,9);
        grid.add(textFieldDateOfBirth, 1, 9);
        grid.add(new Label("Nationality: "),0,10);
        grid.add(textFieldNationality, 1, 10);
        grid.add(new Label("Phone: "),0,11);
        grid.add(textFieldPhone, 1, 11);
        grid.add(new Label("Address: "),0,12);
        grid.add(textFieldAddress, 1, 12);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            int salary = Integer.parseInt(textFieldSalary.getText());
            int branchId = Integer.parseInt(textFieldBranchId.getText());
            int positionId = Integer.parseInt(textFieldPositionId.getText());
            String workTime = textFieldWorkTime.getText();
            String login = textFieldLogin.getText();
            String password = textFieldPassword.getText();
            String name = textFieldName.getText();
            String surname = textFieldSurname.getText();
            String pesel = textFieldPesel.getText();
            String dateOfBirth = textFieldDateOfBirth.getText();
            String nationality = textFieldNationality.getText();
            String phone = textFieldPhone.getText();
            String address = textFieldAddress.getText();
            workerComplexData = new WorkerComplexData(salary, branchId, positionId, workTime, login, password, name, surname, pesel, dateOfBirth, nationality, phone, address);
        }
        return workerComplexData;
    }
    private int getID(String title, String header)
    {
        int id = -1;
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(header);


// Set the button types.
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField textFieldWorkerID = new TextField();
        grid.add(new Label("Worker ID: "), 0 ,0);
        grid.add(textFieldWorkerID, 1, 0);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            try
            {
                id = Integer.parseInt( textFieldWorkerID.getText() );
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return id;
    }
    private void displayWorkers(List<WorkerData> workers)
    {
        textAreaOutcome.setText("WORKERS: ");
        String display;
        for(int i = 0; i < workers.size(); i++)
        {
            display = workers.get(i).toString();
            textAreaOutcome.appendText(display);
        }
    }
    private void addWorker()
    {
        WorkerComplexData workerData = getWorkerComplexData("ADD WORKER", "Please insert correct type of data");
        if(service.addWorkerToDatabase(workerData))
        {
            showSuccess();
        }
        else
        {
            showError();
        }
    }
    private void modifyWorker()
    {
        int id = getID("MODIFY WORKER", "Please insert worker ID");
        if(id != -1)
        {
            WorkerData workerData = getWorkerData("MODIFY WORKER", "Please insert new data");
            if(service.updateWorker(id,workerData))
            {
                showSuccess();
            }
            else
            {
                showError();
            }
        }
    }
    private void deleteWorker()
    {
        int id = getID("DELETE Worker", "Please insert worker ID");
        if(service.deleteWorker(id))
        {
            showSuccess();
        }
        else
        {
            showError();
        }
    }
    private void giveBonus()
    {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("BONUS");
        dialog.setHeaderText("Please insert amount of available money");


// Set the button types.
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField textFieldPercent = new TextField();
        grid.add(new Label("Rise percent: "), 0,0);
        grid.add(textFieldPercent, 1,0);



        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            try{
                float percent = Float.parseFloat(textFieldPercent.getText());
                if(service.bonus(percent))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private void showWorkers()
    {
        List<WorkerData> workers = service.selectWorkers();
        displayWorkers(workers);
    }
    private void showPartTimeWorkers()
    {
        String workTime = "";
        List<String> choices = new ArrayList<>();
        choices.add("half");
        choices.add("full");
        choices.add("quater");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("full", choices);
        dialog.setTitle("SHOW PART TIME WORKERS");
        dialog.setHeaderText("Choose time");
        dialog.setContentText("available options : ");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            workTime = result.get();
        }
        List<WorkerData> workers = service.selectPartTimeWorkers(workTime);
        displayWorkers(workers);
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().equals(buttonAddWorker))
        {
            addWorker();
        }
        if(e.getSource().equals(buttonDeleteWorker))
        {
            deleteWorker();
        }
        if(e.getSource().equals(buttonModifyWorker))
        {
            modifyWorker();
        }
        if(e.getSource().equals(buttonBonus))
        {
            giveBonus();
        }
        if(e.getSource().equals(buttonShowWorkers))
        {
            showWorkers();
        }
        if(e.getSource().equals(buttonShowPartTimeWorkers))
        {
            showPartTimeWorkers();
        }
    }
}
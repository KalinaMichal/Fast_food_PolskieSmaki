package controllers;

import database.structure.BranchData;
import database.structure.DirectorComplexData;
import database.structure.DirectorData;
import database.structure.PositionData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import services.Service;

import java.util.List;
import java.util.Optional;

public class OwnerFrameController implements EventHandler<ActionEvent> {
    public Button buttonShowDirectors;
    public Button buttonModifyDirectors;
    public Button buttonModifyBranch;
    public Button buttonBackup;
    public Button buttonLoadData;
    public TextArea textAreaOutcome;
    public Button buttonModifyPosition;
    public Button buttonShowPositions;
    public Button buttonShowBranches;

    private Service service = Service.getInstance();
    @FXML
    public void initialize() {
        buttonBackup.setOnAction(this);
        buttonLoadData.setOnAction(this);
        buttonModifyBranch.setOnAction(this);
        buttonModifyDirectors.setOnAction(this);
        buttonShowDirectors.setOnAction(this);
        buttonModifyPosition.setOnAction(this);
        buttonShowPositions.setOnAction(this);
        buttonShowBranches.setOnAction(this);
    }
    private void showSuccess()
    {
        System.out.println("Success");
    }
    private void showError()
    {
        System.out.println("Something went wrong...");
    }
    private int getID(String title, String header )
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
        grid.add(new Label("ID: "), 0 ,0);
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

    private DirectorComplexData getDirectorComplexData(String title, String header)
    {
        DirectorComplexData directorComplexData = null;
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
        TextField textFieldLogin = new TextField();
        TextField textFieldPassword = new TextField();
        TextField textFieldName = new TextField();
        TextField textFieldSurname = new TextField();
        TextField textFieldPesel = new TextField();
        TextField textFieldDateOfBirth = new TextField();
        TextField textFieldNationality = new TextField();
        TextField textFieldPhone = new TextField();
        TextField textFieldAddress = new TextField();

        grid.add(new Label("Name: "),0,0);
        grid.add(textFieldName, 1, 0);
        grid.add(new Label("Surname: "),0,1);
        grid.add(textFieldSurname, 1, 1);
        grid.add(new Label("Pesel: "),0,2);
        grid.add(textFieldPesel, 1, 2);
        grid.add(new Label("Date of birth: "),0,3);
        grid.add(textFieldDateOfBirth, 1, 3);
        grid.add(new Label("Nationality: "),0,4);
        grid.add(textFieldNationality, 1, 4);
        grid.add(new Label("Phone: "),0,5);
        grid.add(textFieldPhone, 1, 6);
        grid.add(new Label("Address: "),0,7);
        grid.add(textFieldAddress, 1, 7);
        grid.add(new Label("Salary:"), 0, 8);
        grid.add(textFieldSalary, 1, 8);
        grid.add(new Label("Branch ID:"), 0, 9);
        grid.add(textFieldBranchId, 1, 9);
        grid.add(new Label("Login: "),0,10);
        grid.add(textFieldLogin, 1, 10);
        grid.add(new Label("Password: "), 0,11);
        grid.add(textFieldPassword,1, 11 );

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            int salary = Integer.parseInt(textFieldSalary.getText());
            int branchId = Integer.parseInt(textFieldBranchId.getText());
            String login = textFieldLogin.getText();
            String password = textFieldPassword.getText();
            String name = textFieldName.getText();
            String surname = textFieldSurname.getText();
            String pesel = textFieldPesel.getText();
            String dateOfBirth = textFieldDateOfBirth.getText();
            String nationality = textFieldNationality.getText();
            String phone = textFieldPhone.getText();
            String address = textFieldAddress.getText();
            directorComplexData = new DirectorComplexData(  name, surname, pesel, dateOfBirth, nationality, phone, address, salary, branchId, login, password);
        }
        return directorComplexData;
    }
    private DirectorData getDirectorData(String title, String header)
    {
        DirectorData directorData = null;
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
        TextField textFieldName = new TextField();
        TextField textFieldSurname = new TextField();
        TextField textFieldPesel = new TextField();
        TextField textFieldDateOfBirth = new TextField();
        TextField textFieldNationality = new TextField();
        TextField textFieldPhone = new TextField();
        TextField textFieldAddress = new TextField();

        grid.add(new Label("Name: "),0,0);
        grid.add(textFieldName, 1, 0);
        grid.add(new Label("Surname: "),0,1);
        grid.add(textFieldSurname, 1, 1);
        grid.add(new Label("Pesel: "),0,2);
        grid.add(textFieldPesel, 1, 2);
        grid.add(new Label("Date of birth: "),0,3);
        grid.add(textFieldDateOfBirth, 1, 3);
        grid.add(new Label("Nationality: "),0,4);
        grid.add(textFieldNationality, 1, 4);
        grid.add(new Label("Phone: "),0,5);
        grid.add(textFieldPhone, 1, 6);
        grid.add(new Label("Address: "),0,7);
        grid.add(textFieldAddress, 1, 7);
        grid.add(new Label("Salary:"), 0, 8);
        grid.add(textFieldSalary, 1, 8);
        grid.add(new Label("Branch ID:"), 0, 9);
        grid.add(textFieldBranchId, 1, 9);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            int salary = Integer.parseInt(textFieldSalary.getText());
            int branchId = Integer.parseInt(textFieldBranchId.getText());
            String name = textFieldName.getText();
            String surname = textFieldSurname.getText();
            String pesel = textFieldPesel.getText();
            String dateOfBirth = textFieldDateOfBirth.getText();
            String nationality = textFieldNationality.getText();
            String phone = textFieldPhone.getText();
            String address = textFieldAddress.getText();
            directorData = new DirectorData(  name, surname, pesel, dateOfBirth, nationality, phone, address, salary, branchId);
        }
        return directorData;
    }
    private BranchData getBranchData(String title, String header)
    {
        BranchData branchData = null;
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


        TextField textFieldSpecialisation = new TextField();
        TextField textFieldLocation = new TextField();


        grid.add(new Label("Specialisation: "),0,0);
        grid.add(textFieldSpecialisation, 1, 0);
        grid.add(new Label("Location: "),0,1);
        grid.add(textFieldLocation, 1, 1);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {
            try {
                String specialisation = textFieldSpecialisation.getText();
                String location = textFieldLocation.getText();
                branchData = new BranchData(specialisation, location);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                showError();
            }
        }
        return branchData;
    }
    private PositionData getPositionData(String title, String header)
    {
        PositionData positionData = null;
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


        TextField textFieldName = new TextField();
        TextField textFieldMinSalary = new TextField();
        TextField textFieldMaxSalary = new TextField();


        grid.add(new Label("name: "),0,0);
        grid.add(textFieldName, 1, 0);
        grid.add(new Label("minSalary: "),0,1);
        grid.add(textFieldMinSalary, 1, 1);
        grid.add(new Label("maxSalary: "),0,2);
        grid.add(textFieldMaxSalary, 1, 2);

        dialog.getDialogPane().setContent(grid);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(ButtonType.OK))
        {

            String name = textFieldName.getText();
            try {
                int minSalary = Integer.parseInt(textFieldMinSalary.getText());
                int maxSalary = Integer.parseInt(textFieldMaxSalary.getText());
                positionData = new PositionData(name, minSalary, maxSalary);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                showError();
            }
        }
        return positionData;
    }
    private void displayDirectors(List<DirectorData> directors)
    {
        textAreaOutcome.setText("DIRECTORS: \n");
        for(int i = 0; i < directors.size(); i++)
        {
            textAreaOutcome.appendText(directors.get(i).toString());
        }
    }
    private void displayBranches(List<BranchData> branches)
    {
        textAreaOutcome.setText("BRANCHES: \n");
        for(int i = 0; i < branches.size(); i++)
        {
            textAreaOutcome.appendText(branches.get(i).toString());
        }
    }
    private void displayPositions(List<PositionData> positions)
    {
        textAreaOutcome.setText("POSITIONS: \n");
        for(int i = 0; i < positions.size(); i++)
        {
            textAreaOutcome.appendText(positions.get(i).toString());
        }
    }
    private void modifyDirectors()
    {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("MODIFY DIRECTORS");
        dialog.setHeaderText("Choose option");

// Set the button types.
        ButtonType buttonTypeOne = new ButtonType("ADD");
        ButtonType buttonTypeTwo = new ButtonType("UPDATE");
        ButtonType buttonTypeThree = new ButtonType("REMOVE");
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, ButtonType.CANCEL);

// Create the username and password labels and fields.


        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()==false)
        {
            return;
        }
        if(result.get().equals(buttonTypeOne))
        {
            DirectorComplexData directorComplexData = getDirectorComplexData("ADD DIRECTOR", "Please insert correct data");
            service.addDirectorToDatabase(directorComplexData);
        }
        if(result.get().equals(buttonTypeTwo))
        {
            int id = getID("MODIFY ID", "Please chose valid id");
            if(id == -1)
            {
                showError();
            }
            else
            {
                DirectorData directorData = getDirectorData("MODIFY DIRECTOR", "please insert new data");
                if(service.updateDirector(id,directorData))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            }
        }
        if(result.get().equals(buttonTypeThree))
        {
            int id = getID("DELETE DIRECTOR", "Please chose valid id");
            if( service.deleteDirector(id) )
            {
                showSuccess();
            }
            else
            {
                showError();
            }
        }
    }
    private void modifyBranch()
    {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("MODIFY BRANCH");
        dialog.setHeaderText("Choose option");
        ButtonType buttonTypeOne = new ButtonType("ADD");
        ButtonType buttonTypeTwo = new ButtonType("REMOVE");
// Set the button types.
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOne,buttonTypeTwo,ButtonType.CANCEL );

// Create the username and password labels and fields.


        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(buttonTypeOne))
        {
            BranchData branchData = getBranchData("ADD BRANCH", "Please insert correct data");
            if(branchData!=null)
            {
                if(service.addBranchToDatabase(branchData))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            }
            else
            {
                showError();
            }
        }
        if(result.get().equals(buttonTypeTwo))
        {
            int id = getID("DELETE BRANCH", "Please insert valid id");
            if(id==-1)
            {
                showError();
            }
            else
            {
                if(service.deleteBranch(id))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            }
        }
    }
    private void modifyPosition()
    {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("MODIFY POSITION");
        dialog.setHeaderText("Choose option");

// Set the button types.
        ButtonType buttonTypeOne = new ButtonType("ADD");
        ButtonType buttonTypeTwo = new ButtonType("REMOVE");
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOne, buttonTypeTwo, ButtonType.CANCEL);

// Create the username and password labels and fields.


        Optional<ButtonType> result = dialog.showAndWait();

        if(result.get().equals(buttonTypeOne))
        {
            PositionData positionData = getPositionData("ADD POSITION", "Please insert correct data");
            if(positionData!=null)
            {
                if(service.addPositionToDatabase(positionData))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            }
            else
            {
                showError();
            }
        }
        if(result.get().equals(buttonTypeTwo))
        {
            int id = getID("DELETE POSITION", "Please insert valid id");
            if(id==-1)
            {
                showError();
            }
            else
            {
                if(service.deletePosition(id))
                {
                    showSuccess();
                }
                else
                {
                    showError();
                }
            }
        }
    }
    private void showDirectors()
    {
        List<DirectorData> directors = service.selectDirectors();
        displayDirectors(directors);
    }
    private void showBranches()
    {
        List<BranchData> branches = service.selectBranches();
        displayBranches(branches);
    }
    private void showPositions()
    {
        List<PositionData> positions = service.selectPositions();
        displayPositions(positions);
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().equals(buttonBackup))
        {
            //"mysqldump -u owner -powner projectDB > C:\\Users\\ciche\\Desktop\\BACKUP\\projcetD.sql"
            String executeCmd = "cmd.exe /c start C:\\Users\\ciche\\ab.bat";
            Process runtimeProcess;
            try {

                runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                int processComplete = runtimeProcess.waitFor();

                if (processComplete == 0) {
                    System.out.println("Backup created successfully");
                } else {
                    System.out.println("Could not create the backup");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(buttonLoadData))
        {
            //"mysqldump -u owner -powner projectDB < C:\\Users\\ciche\\Desktop\\BACKUP\\projcetD.sql"
            String executeCmd = "cmd.exe /c start C:\\Users\\ciche\\bb.bat";
            Process runtimeProcess;
            try {

                runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                int processComplete = runtimeProcess.waitFor();

                if (processComplete == 0) {
                    System.out.println("Load completed");
                } else {
                    System.out.println("Could not load");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(buttonModifyBranch))
        {
            modifyBranch();
        }
        if(e.getSource().equals(buttonModifyPosition))
        {
            modifyPosition();
        }
        if(e.getSource().equals(buttonModifyDirectors))
        {
            modifyDirectors();
        }
        if(e.getSource().equals(buttonShowDirectors))
        {
            showDirectors();
        }
        if(e.getSource().equals(buttonShowBranches))
        {
            showBranches();
        }
        if(e.getSource().equals(buttonShowPositions))
        {
            showPositions();
        }
    }
}

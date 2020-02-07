package database.connection;

import database.structure.*;
import javafx.concurrent.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Private Constructor
     */
    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public void setDatabaseConnection()
    {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectDB",login,password);
        }catch (Exception e)
        {
            System.out.println("Nie udało się nawiązać połączenia");
            e.printStackTrace();
        }
    }

    public boolean addWorker(WorkerComplexData workerComplexData)
    {
        setDatabaseConnection();
        String statementString = "call insert_worker(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1, workerComplexData.getSalary());
            preparedStatement.setInt(2, workerComplexData.getBranchId());
            preparedStatement.setInt(3, workerComplexData.getPositionId());
            preparedStatement.setString(4, workerComplexData.getWorkTime());
            preparedStatement.setString(5, workerComplexData.getName());
            preparedStatement.setString(6, workerComplexData.getSurname());
            preparedStatement.setString(7, workerComplexData.getPesel());
            preparedStatement.setString(8, workerComplexData.getDateOfBirth());
            preparedStatement.setString(9, workerComplexData.getNationality());
            preparedStatement.setString(10, workerComplexData.getPhone());
            preparedStatement.setString(11, workerComplexData.getAddress());
            preparedStatement.setString(12, workerComplexData.getLogin());
            preparedStatement.setString(13, workerComplexData.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addDirector(DirectorComplexData directorComplexData)
    {
        setDatabaseConnection();
        String statementString = "call insert_director(?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setString(1, directorComplexData.getName());
            preparedStatement.setString(2, directorComplexData.getSurname());
            preparedStatement.setString(3, directorComplexData.getPesel());
            preparedStatement.setString(4, directorComplexData.getDateOfBirth());
            preparedStatement.setString(5, directorComplexData.getNationality());
            preparedStatement.setString(6, directorComplexData.getPhone());
            preparedStatement.setString(7, directorComplexData.getAddress());
            preparedStatement.setInt(8, directorComplexData.getSalary());
            preparedStatement.setInt(9, directorComplexData.getBranchId());
            preparedStatement.setString(10, directorComplexData.getLogin());
            preparedStatement.setString(11, directorComplexData.getPassword());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateWorker(int id, WorkerData workerData)
    {
        setDatabaseConnection();
        String statementString = "call update_worker(?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2, workerData.getSalary());
            preparedStatement.setInt(3, workerData.getBranchId());
            preparedStatement.setInt(4, workerData.getPositionId());
            preparedStatement.setString(5, workerData.getWorkTime());
            preparedStatement.setString(6, workerData.getName());
            preparedStatement.setString(7, workerData.getSurname());
            preparedStatement.setString(8, workerData.getPesel());
            preparedStatement.setString(9, workerData.getDateOfBirth());
            preparedStatement.setString(10, workerData.getNationality());
            preparedStatement.setString(11, workerData.getPhone());
            preparedStatement.setString(12, workerData.getAddress());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDirector(int id, DirectorData directorData)
    {
        setDatabaseConnection();
        String statementString = "call update_director(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, directorData.getName());
            preparedStatement.setString(3, directorData.getSurname());
            preparedStatement.setString(4, directorData.getPesel());
            preparedStatement.setString(5, directorData.getDateOfBirth());
            preparedStatement.setString(6, directorData.getNationality());
            preparedStatement.setString(7, directorData.getPhone());
            preparedStatement.setString(8, directorData.getAddress());
            preparedStatement.setInt(9, directorData.getSalary());
            preparedStatement.setInt(10, directorData.getBranchId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<WorkerData> selectWorkers(){
        setDatabaseConnection();
        List<WorkerData> workerList = new LinkedList<WorkerData>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM view_workers");
            int salary, branchID, positionID;
            String workTime, name, surname, pesel, dateOfBirth, nationality, phone, address;
            while (result.next())
            {
                salary = result.getInt("salary");
                branchID = result.getInt("branch_id");
                positionID = result.getInt("position_id");
                workTime = result.getString("work_time");
                name = result.getString("name");
                surname = result.getString("surname");
                pesel = result.getString("pesel");
                dateOfBirth = result.getString("date_of_birth");
                nationality = result.getString("nationality");
                phone = result.getString("phone");
                address = result.getString("address");
                WorkerData workerData = new WorkerData(salary,branchID, positionID, workTime,  name, surname, pesel, dateOfBirth, nationality, phone, address);
                workerData.setId(result.getInt("id"));
                workerList.add( workerData );
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return workerList;
    }

    public List<DirectorData> selectDirectors()
    {
        setDatabaseConnection();
        List<DirectorData> directorList = new LinkedList<DirectorData>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM directors");
            int salary, branchID;
            String name, surname, pesel, dateOfBirth, nationality, phone, address;
            while (result.next())
            {
                salary = result.getInt("salary");
                branchID = result.getInt("branch_id");
                name = result.getString("name");
                surname = result.getString("surname");
                pesel = result.getString("pesel");
                dateOfBirth = result.getString("date_of_birth");
                nationality = result.getString("nationality");
                phone = result.getString("phone");
                address = result.getString("address");
                DirectorData directorData = new DirectorData(name, surname, pesel, dateOfBirth, nationality, phone, address, salary, branchID);
                directorData.setId(result.getInt("id"));
                directorList.add(directorData);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return directorList;
    }
    public WorkerData getWorker(int id)
    {
        setDatabaseConnection();
        WorkerData workerData = null;
        List<WorkerData> workerList = selectWorkers();
        for(int i = 0; i < workerList.size(); i++ )
        {
            if(workerList.get(i).getId() == id)
            {
                workerData = workerList.get(i);
            }
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return workerData;
    }
    public DirectorData getDirector(int id)
    {
        setDatabaseConnection();
        DirectorData directorData = null;
        List<DirectorData> directorList = selectDirectors();
        for(int i = 0; i < directorList.size(); i++ )
        {
            if(directorList.get(i).getId() == id)
            {
                directorData = directorList.get(i);
            }
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return directorData;
    }
    public boolean deleteWorker(int id)
    {
        setDatabaseConnection();
        String statementString = "CALL delete_worker(?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteDirector(int id)
    {
        setDatabaseConnection();
        String statementString = "CALL  delete_director(?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addPosition( PositionData positionData )
    {
        setDatabaseConnection();
        String statementString = "INSERT INTO positions (position_name, min_salary, max_salary) VALUES (?, ?, ?) ";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setString(1,positionData.getName());
            preparedStatement.setInt(2, positionData.getMinSalary());
            preparedStatement.setInt(3,positionData.getMaxSalary());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deletePosition(int id)
    {
        setDatabaseConnection();
        String statementString = "DELETE FROM positions WHERE id = ?";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<PositionData> selectPosition ( )
    {
        setDatabaseConnection();
        List<PositionData> positionList = new LinkedList<PositionData>();
        try {
            String statementString = "SELECT * FROM positions ";
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            ResultSet result = preparedStatement.executeQuery();
            int minSalary, maxSalary;
            String name;
            while (result.next())
            {
                name = result.getString("position_name");
                minSalary = result.getInt("min_salary");
                maxSalary = result.getInt("max_salary");
                PositionData positionData = new PositionData(name, minSalary, maxSalary);
                positionData.setId(result.getInt("id"));
                positionList.add(positionData);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return positionList;
    }
    public boolean addBranch( BranchData branchData)
    {
        setDatabaseConnection();
        String statementString = "INSERT INTO branches (specialisation,location) VALUES ( ?, ?) ";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setString(1,branchData.getSpecialisation());
            preparedStatement.setString(2, branchData.getLocation());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteBranch(int id)
    {
        setDatabaseConnection();
        String statementString = "DELETE FROM branches WHERE branches.id = ?";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<BranchData> selectBranches()
    {
        setDatabaseConnection();
        List<BranchData> branchList = new LinkedList<BranchData>();
        try {
            String statementString = "SELECT * FROM branches ";
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            ResultSet result = preparedStatement.executeQuery();
            String specialisation, location;
            while (result.next())
            {
                specialisation = result.getString("specialisation");
                location = result.getString("location");
                BranchData branchData = new BranchData(specialisation,location);
                branchData.setId(result.getInt("id"));
                branchList.add(branchData);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return branchList;
    }

    public int getWorkerId(String login, String password)
    {
        setDatabaseConnection();
        int id = -1;
        try {
            String statementString = "SELECT * FROM workers INNER JOIN workers_login_data ON workers.id = workers_login_data.worker_id WHERE workers_login_data.login = ? AND workers_login_data.password = md5(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
            {
                id = result.getInt("id");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public int getDirectorId(String login, String password)
    {
        setDatabaseConnection();
        int id = -1;
        try {
            String statementString = "SELECT * FROM directors INNER JOIN directors_login_data ON directors.id = directors_login_data.director_id WHERE directors_login_data.login = ? AND directors_login_data.password = md5(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
            {
                id = result.getInt("id");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public List<WorkerData> selectDirectorWorkers(int branchId)
    {
        setDatabaseConnection();
        List<WorkerData> outcome = new ArrayList<>();
        List<WorkerData> workers = selectWorkers();
        for(int i = 0; i < workers.size(); i++)
        {
            if(workers.get(i).getBranchId() == branchId)
            {
                outcome.add(workers.get(i));
            }
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return outcome;
    }

    public List<WorkerData> selectPartTimeWorkers(int branchId, String workTime)
    {
        setDatabaseConnection();
        List<WorkerData> outcome = new ArrayList<>();
        List<WorkerData> workers = selectDirectorWorkers(branchId);
        for(int i = 0; i < workers.size(); i++)
        {
            if(workers.get(i).getWorkTime().equals(workTime))
            {
                outcome.add(workers.get(i));
            }
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return outcome;
    }

    public boolean bonus(int branchId, float x)
    {
        setDatabaseConnection();
        String statementString = "call riseSalary( ?, ?)";
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(statementString);
            preparedStatement.setInt(1,branchId);
            preparedStatement.setFloat(2,x);
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}

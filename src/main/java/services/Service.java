package services;

import database.connection.DatabaseConnection;
import database.structure.*;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private static Service service;
    private Accessibility accessibility;
    private String login;
    private DatabaseConnection databaseConnection;
    private int workerId;
    private int directorId;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    /**
     * Private Constructor
     */
    private Service() {
        databaseConnection = DatabaseConnection.getInstance();
    }

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }

    public boolean addWorkerToDatabase(WorkerComplexData workerComplexData)
    {
        return databaseConnection.addWorker(workerComplexData);
    }

    public boolean addDirectorToDatabase(DirectorComplexData directorComplexData)
    {
        return databaseConnection.addDirector(directorComplexData);
    }

    public boolean addPositionToDatabase(PositionData positionData)
    {
        return databaseConnection.addPosition(positionData);
    }

    public boolean addBranchToDatabase(BranchData branchData)
    {
        return databaseConnection.addBranch(branchData);
    }

    public boolean deleteWorker(int id)
    {
        return databaseConnection.deleteWorker(id);
    }

    public boolean deleteDirector(int id)
    {
        return databaseConnection.deleteDirector(id);
    }

    public boolean deleteBranch(int id)
    {
        return databaseConnection.deleteBranch(id);
    }

    public boolean deletePosition(int id)
    {
        return databaseConnection.deletePosition(id);
    }

    public boolean updateWorker(int id, WorkerData workerData)
    {
        return databaseConnection.updateWorker(id,workerData);
    }

    public boolean updateDirector(int id, DirectorData directorData)
    {
        return databaseConnection.updateDirector(id, directorData);
    }

    public List<WorkerData> selectWorkers()
    {
        return databaseConnection.selectDirectorWorkers(databaseConnection.getDirector(directorId).getBranchId());
    }

    public List<WorkerData> selectPartTimeWorkers(String workTime)
    {
        return databaseConnection.selectPartTimeWorkers(databaseConnection.getDirector(directorId).getBranchId(), workTime);
    }

    public List<DirectorData> selectDirectors()
    {
        return databaseConnection.selectDirectors();
    }

    public List<BranchData> selectBranches()
    {
        return databaseConnection.selectBranches();
    }

    public List<PositionData> selectPositions()
    {
        return databaseConnection.selectPosition();
    }

    public WorkerData getWorker()
    {
        return databaseConnection.getWorker(workerId);
    }

    public DirectorData getDirector()
    {
        WorkerData workerData= getWorker();
        return databaseConnection.getDirector(workerData.getBranchId() );
    }

    public boolean logAsWorker(String login, String password)
    {
        workerId = databaseConnection.getWorkerId(login, password);
        if(workerId==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean logAsDirector(String login, String password)
    {
        directorId = databaseConnection.getDirectorId(login, password);
        if(directorId==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean bonus(float x)
    {
        return databaseConnection.bonus(databaseConnection.getDirector(directorId).getBranchId(),x);
    }
}

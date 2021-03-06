package database.structure;

public class WorkerData {
    private int salary;
    private int branchId;
    private int positionId;
    private String workTime;
    private String name;
    private String surname;
    private String pesel;
    private String dateOfBirth;
    private String nationality;
    private String phone;
    private String address;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerData()
    {

    }
    public WorkerData(int s, int bId, int pId, String wT,  String na, String su, String  pe, String date, String nat, String pho, String add)
    {
        salary = s;
        branchId = bId;
        positionId = pId;
        workTime = wT;
        name = na;
        surname = su;
        pesel = pe;
        dateOfBirth = date;
        nationality = nat;
        phone = pho;
        address = add;
    }

    @Override
    public String toString() {
        return "WorkerData:"  +
                "\nsalary=" + salary +
                "\n branchId=" + branchId +
                "\n positionId=" + positionId +
                "\n workTime='" + workTime +
                "\n name='" + name +
                "\n surname='" + surname +
                "\n pesel='" + pesel + '\'' +
                "\n dateOfBirth='" + dateOfBirth +
                "\n nationality='" + nationality +
                "\n phone='" + phone +
                "\n address='" + address +
                "\n id=" + id +
                '\n';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

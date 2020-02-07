package database.structure;

public class DirectorData {
    private String name;
    private String surname;
    private String pesel;
    private String dateOfBirth;
    private String nationality;
    private String phone;
    private String address;
    private int salary;
    private int branchId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DirectorData(String name, String surname, String pesel, String dateOfBirth, String nationality, String phone, String address, int salary, int branchId)
    {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.branchId = branchId;
    }
    public DirectorData()
    {

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

    @Override
    public String toString() {
        return "DirectorData:" +
                "\nname='" + name +
                "\n surname='" + surname +
                "\n pesel='" + pesel +
                "\n dateOfBirth='" + dateOfBirth +
                "\n nationality='" + nationality +
                "\n phone='" + phone +
                "\n address='" + address +
                "\n salary=" + salary +
                "\n branchId=" + branchId +
                "\n id=" + id +
                '\n';
    }
}

package database.structure;

public class BranchData {
    private String specialisation;

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    public BranchData(){

    }
    public BranchData(String specialisation, String location)
    {
        this.specialisation = specialisation;
        this.location = location;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BranchData:" +
                "\n specialisation='" + specialisation +
                "\n location='" + location +
                "\n id=" + id +
                '\n';
    }
}

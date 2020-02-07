package database.structure;

public class PositionData {
    private String name;
    private int minSalary;
    private int maxSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public PositionData()
    {

    }

    public PositionData(String name, int minSalary, int maxSalary)
    {
        this.name = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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
        return "PositionData:" +
                "\n name=" + name + '\'' +
                "\n minSalary=" + minSalary +
                "\n maxSalary=" + maxSalary +
                "\n id=" + id +
                '\n';
    }
}

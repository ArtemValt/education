package stage2.practice.Task2.Service;

public class City {
    private String name;
    private int area;
    private String type;
    private int dataown;
    private double population ;
    private final long id ;

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDataown(int dataown) {
        this.dataown = dataown;
    }

    public void setAreaNumber(double areaNumber) {
        this.population  = areaNumber;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public int getDataown() {
        return dataown;
    }

    public double getAreaNumber() {
        return population ;
    }

    public long getId() {
        return id;
    }

    public City(String name, int area, String type, int dataown, double areaNumber, long id) {
        this.name = name;
        this.area = area;
        this.type = type;
        this.dataown = dataown;
        this.population  = areaNumber;
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", type='" + type + '\'' +
                ", dataown=" + dataown +
                ", areaNumber=" + population  +
                ", id=" + id +
                '}';
    }
}
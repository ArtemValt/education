package stage2.practice.Task2.Service;

public class Streets {
    private String name;
    private String type;
    private final long id ;
    private final int city_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public Streets(long id,String name, String type, int city_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.city_id = city_id;

    }

    @Override
    public String toString() {
        return "------------------------------------------------------------------\nStreets{" +
                "name= '" + name +"'" +
                "||| type= '" + type +"'" +
                "||| id= '" + id +"'" +
                "||| city_id= '" + city_id+"'" +
                "\n------------------------------------------------------------------";
    }
}

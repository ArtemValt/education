package stage2.practice.Task2.Service;

public class Streets {
    private String name;
    private String type;
    private final long id ;

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

    public Streets(String name, String type, long id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Streets{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}

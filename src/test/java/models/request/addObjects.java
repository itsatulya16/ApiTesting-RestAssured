package models.request;

public class addObjects {
    private String name;
    private data data;

    public addObjects(String name, data data) {
        this.name = name;
        this.data = data;
    }
    public String getName() {
        return name;
    }
    public data getData() {
        return data;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setData(data data) {
        this.data = data;
    }

}

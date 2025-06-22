package models.response;

public class addObjectsResponse {
    private String id;
    private String name;
    private String createdAt;
    private data data;

    public addObjectsResponse(){

    }

    public addObjectsResponse(String id, String name, data data, String createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "addObjects{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", data=" + data +
                '}';
    }

}

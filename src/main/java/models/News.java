package models;

public class News {
    private int id;
    private String description;

    public News(String description){
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return description;
    }

}

package fr.peyet.batchcooking.model;

public class Recipe {

    private long id;
    private String title;

    public Recipe() {
        this.id = 0;
        this.title = "";
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

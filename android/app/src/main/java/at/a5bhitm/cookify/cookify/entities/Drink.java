package at.a5bhitm.cookify.cookify.entities;

import java.util.ArrayList;
import java.util.List;

public class Drink {

    private String id;

    private String title;
    private String subtitle;

    private String thumbnail_url;

    private List<Ingredient> ingredients = new ArrayList<>();

    private String time;

    private String description;

    private List<String> steps = new ArrayList<>();

    public Drink() {
    }

    public Drink(String id, String title, String subtitle, String thumbnail_url, List<Ingredient> ingredients, String time, String description, List<String> steps) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.thumbnail_url = thumbnail_url;
        this.ingredients = ingredients;
        this.time = time;
        this.description = description;
        this.steps = steps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", ingredients=" + ingredients +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", steps=" + steps +
                '}';
    }
}

package at.bhitm.entities;

import org.springframework.data.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    @Id
    private String id;

    private String title;
    private String subtitle;

    private String thumbnail_url;

    private List<Ingredient> ingredients = new ArrayList<>();

    private String time_sum;
    private String time_cook;

    private String description;

    private List<String> steps = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String id, String title, String subtitle, String thumbnail_url, List<Ingredient> ingredients, String time_sum, String time_cook, String description, List<String> steps) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.thumbnail_url = thumbnail_url;
        this.ingredients = ingredients;
        this.time_sum = time_sum;
        this.time_cook = time_cook;
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

    public String getTime_sum() {
        return time_sum;
    }

    public void setTime_sum(String time_sum) {
        this.time_sum = time_sum;
    }

    public String getTime_cook() {
        return time_cook;
    }

    public void setTime_cook(String time_cook) {
        this.time_cook = time_cook;
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
        return "Recipe{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", ingredients=" + ingredients +
                ", time_sum='" + time_sum + '\'' +
                ", time_cook='" + time_cook + '\'' +
                ", description='" + description + '\'' +
                ", steps=" + steps +
                '}';
    }
}

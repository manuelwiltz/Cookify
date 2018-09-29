package at.bhitm.entities;

import org.springframework.data.annotation.Id;

public class Favorite {

    @Id
    private String id;

    private String user_id;
    private String recipe_id;

    public Favorite() {
    }

    public Favorite(String id, String user_id, String recipe_id) {
        this.id = id;
        this.user_id = user_id;
        this.recipe_id = recipe_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }
}

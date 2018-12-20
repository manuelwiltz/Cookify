package at.a5bhitm.cookify.cookify.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterRecipe;
import at.a5bhitm.cookify.cookify.entities.Favorite;
import at.a5bhitm.cookify.cookify.entities.Recipe;
import at.a5bhitm.cookify.cookify.sqLiteHelper.FavoriteDatabaseHelper;

public class FavoriteActivity extends AppCompatActivity {

    //172.18.119.157
    //192.168.0.4
    private final String JSON_URL = "http://172.18.119.157:8080/recipe";
    private final String JSON_URL_ID = "http://172.18.119.157:8080/recipe/getById/";
    private JsonRequest request;
    private RequestQueue requestQueue;
    private List<Recipe> recipes;
    private List<Favorite> favorites;
    private RecyclerView recyclerView;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle(R.string.favorite);

        recipes = new ArrayList<>();
        favorites = new ArrayList<>();

        recyclerView = findViewById(R.id.favorite_recycleviewid);
        //jsonrequest();
        try {
            getFavorites();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFavorites() throws Exception {
        FavoriteDatabaseHelper favoriteDatabaseHelper = new FavoriteDatabaseHelper(this);
        this.favorites = favoriteDatabaseHelper.getAllFavorites();

        for (this.i = 0; i < this.favorites.size(); i++) {
            jsonrequest(this.favorites.get(i).getRecipe_id());
        }

        setUpRecyclerView(recipes);

    }

    private void jsonrequest(String recipe_id) throws Exception {

        request = new JsonObjectRequest
                (Request.Method.GET, JSON_URL_ID + recipe_id, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Recipe recipe = new Recipe();
                        try {
                            recipe.setId(jsonObject.getString("id"));
                            recipe.setTitle(jsonObject.getString("title"));
                            recipe.setSubtitle(jsonObject.getString("subtitle"));
                            recipe.setThumbnail_url(jsonObject.getString("thumbnail_url"));
                            recipe.setTime_sum(jsonObject.getString("time_sum"));
                            recipe.setTime_cook(jsonObject.getString("time_cook"));
                            recipe.setDescription(jsonObject.getString("description"));
                            Log.v("FAVORITE_ACTIVITY", recipe.getTitle());
                            recipes.add(recipe);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (favorites.size() == i) {
                            setUpRecyclerView(recipes);
                        }

                    }
                }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.v("FAVORITE_ACTIVITY", "ERROR Fetsching");
                    }
                });

        requestQueue = Volley.newRequestQueue(FavoriteActivity.this);
        requestQueue.add(request);

    }

    private void setUpRecyclerView(List<Recipe> recipe) {

        RecycleViewAdapterRecipe adapter = new RecycleViewAdapterRecipe(this, recipe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }
}

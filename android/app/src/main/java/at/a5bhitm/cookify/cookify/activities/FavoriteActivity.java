package at.a5bhitm.cookify.cookify.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterRecipe;
import at.a5bhitm.cookify.cookify.entities.Recipe;

public class FavoriteActivity extends AppCompatActivity {

    private final String JSON_URL = "http://172.18.119.157:8080/recipe";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Recipe> recipes;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle(R.string.favorite);

        recipes = new ArrayList<>();

        recyclerView = findViewById(R.id.favorite_recycleviewid);
        jsonrequest();

    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Recipe recipe = new Recipe();
                        recipe.setId(jsonObject.getString("id"));
                        recipe.setTitle(jsonObject.getString("title"));
                        recipe.setSubtitle(jsonObject.getString("subtitle"));
                        recipe.setThumbnail_url(jsonObject.getString("thumbnail_url"));
                        recipe.setTime_sum(jsonObject.getString("time_sum"));
                        recipe.setTime_cook(jsonObject.getString("time_cook"));
                        recipe.setDescription(jsonObject.getString("description"));
                        recipes.add(recipe);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(recipes);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

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

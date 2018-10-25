package at.a5bhitm.cookify.cookify.activities;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

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
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterIngredient;
import at.a5bhitm.cookify.cookify.entities.Ingredient;

public class IngredientsActivity extends AppCompatActivity {

    private final String JSON_URL = "http://172.18.119.157:8080/ingredient";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Ingredient> ingredients;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        setTitle(R.string.ingredients);

        FloatingActionButton fab = findViewById(R.id.ingredient_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Switch to new Intent and request REST call for recipes by ingredients
                 */
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient in = (Ingredient) ingredients.get(i);
                    /**
                     * Is not working 😂😂
                     */
                    if (in.getSelected() ) {
                        Log.d("IngredientsActivity", in.getName());

                    }
                }

                Intent i = new Intent(view.getContext(), IngredientsActivity.class);
                startActivity(i);
            }
        });

        ingredients = new ArrayList<>();

        recyclerView = findViewById(R.id.ingredient_recycleviewid);
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
                        Ingredient ingredient = new Ingredient();
                        ingredient.setId(jsonObject.getString("id"));
                        ingredient.setName(jsonObject.getString("name"));
                        ingredient.setAmount(jsonObject.getString("amount"));
                        ingredient.setSelected(jsonObject.getBoolean("selected"));
                        ingredients.add(ingredient);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(ingredients);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(IngredientsActivity.this);
        requestQueue.add(request);

        /*ingredients = new ArrayList<Ingredient>() {{
            add(new Ingredient("1", "Butter", "1", false));
            add(new Ingredient("2", "Käse", "1", false));
            add(new Ingredient("3", "Nudeln", "1", false));
            add(new Ingredient("4", "Schlagobers", "1", false));
        }};*/

        setUpRecyclerView(ingredients);
    }

    private void setUpRecyclerView(List<Ingredient> ingredient) {

        RecycleViewAdapterIngredient adapter = new RecycleViewAdapterIngredient(this, ingredient);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }

}

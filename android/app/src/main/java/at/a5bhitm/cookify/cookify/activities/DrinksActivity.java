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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterDrink;
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterRecipe;
import at.a5bhitm.cookify.cookify.entities.Drink;
import at.a5bhitm.cookify.cookify.entities.Recipe;

public class DrinksActivity extends AppCompatActivity {

    private final String JSON_URL = "http://172.31.154.1/drink";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Drink> drinks;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        setTitle(R.string.drinks);

        drinks = new ArrayList<>();

        recyclerView = findViewById(R.id.drink_recycleviewid);
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
                        Drink drink = new Drink();
                        drink.setId(jsonObject.getString("id"));
                        drink.setTitle(jsonObject.getString("title"));
                        drink.setSubtitle(jsonObject.getString("subtitle"));
                        drink.setThumbnail_url(jsonObject.getString("thumbnail_url"));
                        drink.setTime(jsonObject.getString("time"));
                        drink.setDescription(jsonObject.getString("description"));
                        drinks.add(drink);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(drinks);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(DrinksActivity.this);
        requestQueue.add(request);

    }

    private void setUpRecyclerView(List<Drink> drink) {

        RecycleViewAdapterDrink adapter = new RecycleViewAdapterDrink(this, drink);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }
}

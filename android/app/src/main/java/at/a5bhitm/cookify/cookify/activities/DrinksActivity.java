package at.a5bhitm.cookify.cookify.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

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
import at.a5bhitm.cookify.cookify.adapters.RecycleViewAdapterDrink;
import at.a5bhitm.cookify.cookify.entities.Drink;

public class DrinksActivity extends AppCompatActivity {

    private final String JSON_URL = "http://192.168.0.4:8080/drink";
    private JsonArrayRequest request;
    private JsonArrayRequest search_request;
    private RequestQueue requestQueue;
    private List<Drink> drinks;
    private RecyclerView recyclerView;
    private EditText search_drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        setTitle(R.string.drinks);

        drinks = new ArrayList<>();

        recyclerView = findViewById(R.id.drink_recycleviewid);
        search_drinks = (EditText) findViewById(R.id.search_drinks);
        search_drinks.setSelected(false);
        jsonrequest();

        search_drinks.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!search_drinks.getText().toString().equalsIgnoreCase("")) {
                    search_request = new JsonArrayRequest(JSON_URL + "/getByTitle/" + search_drinks.getText(), new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            drinks = new ArrayList<>();
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
                            Log.d("RecipeActivity", "errrrroooooorrrr");
                        }
                    });

                    requestQueue = Volley.newRequestQueue(DrinksActivity.this);
                    requestQueue.add(search_request);
                } else {
                    drinks = new ArrayList<>();
                    jsonrequest();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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

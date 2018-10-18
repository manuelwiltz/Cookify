package at.a5bhitm.cookify.cookify.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.entities.Ingredient;

public class IngredientsActivity extends AppCompatActivity {

    MyCustomIngredientAdapter ingredientAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        setTitle(R.string.ingredients);

        displayListView();
        checkButtonClick();
    }

    private void displayListView() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        Ingredient ingredient = new Ingredient("Butter", "");
        ingredients.add(ingredient);

        ingredient = new Ingredient("Nudeln", "");
        ingredients.add(ingredient);

        ingredient = new Ingredient("Putenfleisch", "");
        ingredients.add(ingredient);

        ingredient = new Ingredient("Schlagobers", "");
        ingredients.add(ingredient);

        ingredientAdapter = new MyCustomIngredientAdapter(this, R.layout.ingredient_main, ingredients);
        ListView listView = (ListView) findViewById(R.id.ingredients_listview);
        
        listView.setAdapter(ingredientAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ingredient ingredient = (Ingredient) parent.getItemAtPosition(position);
                Toast.makeText(IngredientsActivity.this, "clicked: " + ingredient.getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private class MyCustomIngredientAdapter extends ArrayAdapter<Ingredient> {

        private ArrayList<Ingredient> ingredients;

        public MyCustomIngredientAdapter(Context context, int resource, ArrayList<Ingredient> ingredients) {
            super(context, resource, ingredients);
            this.ingredients = new ArrayList<Ingredient>();
            this.ingredients.addAll(ingredients);
        }

        private class IngredientViewHolder {
            TextView ingredients_textview;
            CheckBox ingredients_checkBox;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);

            IngredientViewHolder holder = null;
            Log.v("Ingredient View", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.ingredient_main, null);

                holder = new IngredientViewHolder();
                holder.ingredients_textview = (TextView) convertView.findViewById(R.id.ingredients_listview);
                holder.ingredients_checkBox = (CheckBox) convertView.findViewById(R.id.ingredients_checkBox);

                convertView.setTag(holder);

                holder.ingredients_checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        Ingredient ingredient = (Ingredient) cb.getTag();
                        ingredient.setSelected(cb.isSelected());
                    }
                });
            } else {
                holder = (IngredientViewHolder) convertView.getTag();
            }

            Ingredient ingredient = ingredients.get(position);
            holder.ingredients_textview.setText(ingredient.getName());
            holder.ingredients_checkBox.setSelected(ingredient.getSelected());

            holder.ingredients_textview.setTag(ingredient);

            return convertView;
        }

    }

    public void checkButtonClick() {
        Button button = (Button) findViewById(R.id.ingredients_find_selected);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer responseText = new StringBuffer();
                responseText.append("selected");

                ArrayList<Ingredient> ingredients = ingredientAdapter.ingredients;

                for (int i = 0; i< ingredients.size(); i++) {
                    Ingredient in = ingredients.get(i);

                    if (in.getSelected()) {
                        responseText.append(" " + in.getName() + " ");
                    }
                }

                Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_LONG).show();
            }
        });
    }

}

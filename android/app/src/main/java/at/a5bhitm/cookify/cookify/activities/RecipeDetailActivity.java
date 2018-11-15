package at.a5bhitm.cookify.cookify.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import at.a5bhitm.cookify.cookify.R;

public class RecipeDetailActivity extends AppCompatActivity {

    private TextView favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        favorite = findViewById(R.id.recipe_detail_favorite);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if Text is unfilled icon
            }
        });

        // hide the default ActionBar
        getSupportActionBar().hide();

        // Receive data
        String name = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        String category = getIntent().getExtras().getString("subtitle");
        String time_sum = getIntent().getExtras().getString("time_sum");
        String time_cook = getIntent().getExtras().getString("time_cook");
        String image_url = getIntent().getExtras().getString("thumbnail_url");

        FloatingActionButton fab = findViewById(R.id.recipe_detail_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Switch to Card View
                Intent i = new Intent(view.getContext(), StepActivity.class);
                startActivity(i);
            }
        });

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.recipe_detail_collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.recipe_detail_title);
        TextView tv_subtitle = findViewById(R.id.recipe_detail_subtitle) ;
        TextView tv_description = findViewById(R.id.recipe_detail_description);
        TextView tv_time_sum  = findViewById(R.id.recipe_detail_time_sum) ;
        ImageView img = findViewById(R.id.recipe_detail_thumbnail);

        tv_name.setText(name);
        tv_subtitle.setText(category);
        tv_description.setText(description);
        tv_time_sum.setText(time_sum);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.listview_loading_shape).error(R.drawable.listview_loading_shape);


        // set image with Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }
}

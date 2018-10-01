package at.a5bhitm.cookify.cookify.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import at.a5bhitm.cookify.cookify.R;

public class DrinkDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        // hide the default ActionBar
        getSupportActionBar().hide();

        // Receive data
        String name = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        String category = getIntent().getExtras().getString("subtitle");
        String time = getIntent().getExtras().getString("time");
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

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.drink_detail_collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.drink_detail_title);
        TextView tv_subtitle = findViewById(R.id.drink_detail_subtitle) ;
        TextView tv_description = findViewById(R.id.drink_detail_description);
        TextView tv_time  = findViewById(R.id.drink_detail_time) ;
        ImageView img = findViewById(R.id.drink_detail_thumbnail);

        tv_name.setText(name);
        tv_subtitle.setText(category);
        tv_description.setText(description);
        tv_time.setText("10 min");

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.listview_loading_shape).error(R.drawable.listview_loading_shape);

        // set image with Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }
}

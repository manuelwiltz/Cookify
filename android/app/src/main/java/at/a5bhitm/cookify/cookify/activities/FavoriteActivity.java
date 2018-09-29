package at.a5bhitm.cookify.cookify.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import at.a5bhitm.cookify.cookify.R;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle(R.string.favorite);
    }
}

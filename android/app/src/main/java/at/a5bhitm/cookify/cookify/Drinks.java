package at.a5bhitm.cookify.cookify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        setTitle(R.string.drinks);
    }
}

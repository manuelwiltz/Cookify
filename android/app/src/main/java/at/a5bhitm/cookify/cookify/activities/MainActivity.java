package at.a5bhitm.cookify.cookify.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import at.a5bhitm.cookify.cookify.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private CardView recipeCard, ingredientsCard, drinksCard, favoriteCard, settingsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // defining Card
        recipeCard = (CardView) findViewById(R.id.recipecardid);
        ingredientsCard = (CardView) findViewById(R.id.ingredientscardid);
        drinksCard = (CardView) findViewById(R.id.drinkscardid);
        favoriteCard = (CardView) findViewById(R.id.favoritecardid);
        settingsCard = (CardView) findViewById(R.id.settingscardid);

        // set listeners
        recipeCard.setOnClickListener(this);
        ingredientsCard.setOnClickListener(this);
        drinksCard.setOnClickListener(this);
        favoriteCard.setOnClickListener(this);
        settingsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.recipecardid: {
                i = new Intent(this, RecipesActivity.class);
                startActivity(i);
                break;
            }
            case R.id.ingredientscardid: {
                i = new Intent(this, IngredientsActivity.class);
                startActivity(i);
                break;
            }
            case R.id.drinkscardid: {
                i = new Intent(this, DrinksActivity.class);
                startActivity(i);
                break;
            }
            case R.id.favoritecardid: {
                i = new Intent(this, FavoriteActivity.class);
                startActivity(i);
                break;
            }
            case R.id.settingscardid: {
                i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent i;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_recipe) {
            i = new Intent(this, RecipesActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_ingredients) {
            i = new Intent(this, IngredientsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_drinks) {
            i = new Intent(this, DrinksActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_favorite) {
            i = new Intent(this, FavoriteActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

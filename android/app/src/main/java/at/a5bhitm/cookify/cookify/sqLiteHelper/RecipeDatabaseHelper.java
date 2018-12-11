package at.a5bhitm.cookify.cookify.sqLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import at.a5bhitm.cookify.cookify.entities.Favorite;
import at.a5bhitm.cookify.cookify.entities.Ingredient;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Cookify";

    // Table name: Note.
    private static final String TABLE_RECIPE = "Recipe";

    private static final String COLUMN_RECIPE_ID = "Id";
    private static final String COLUMN_RECIPE_TITLE = "title";
    private static final String COLUMN_RECIPE_SUBTITLE = "subtitle";
    private static final String COLUMN_RECIPE_THUMBNAIL_URL = "thumbnail_url";
    private static final List<Ingredient> COLUMN_RECIPE_INGREDIENTS = new ArrayList<>();
    private static final String COLUMN_RECIPE_TIME_SUM = "time_sum";
    private static final String COLUMN_RECIPE_TIME_COOK = "time_cook";
    private static final String COLUMN_RECIPE_DESCRIPTION = "description";
    private static final List<String> COLUMN_RECIPE_STEPS = new ArrayList<>();

    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script.
        /*String script = "CREATE TABLE " + TABLE_RECIPE + "("
                + COLUMN_RECIPE_ID + " INTEGER PRIMARY KEY," + COLUMN_FAVORITE_USERID + " TEXT,"
                + COLUMN_FAVORITE_RECIPEID + " TEXT" + ")";
        // Execute Script.
        db.execSQL(script);*/
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);

        // Create tables again
        onCreate(db);
    }


    // If table has no data
    // default, Insert 2 records.
    public void createDefaultNotesIfNeed()  {
        int count = this.getRecipeCount();
        if(count ==0 ) {
            Favorite favorite = new Favorite("1", "1");
            Favorite favorite1 = new Favorite("2", "2");
            this.addRecipe(favorite);
            this.addRecipe(favorite1);
        }
    }


    public void addRecipe(Favorite favorite) {
        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FAVORITE_USERID, favorite.getUser_id());
        values.put(COLUMN_FAVORITE_RECIPEID, favorite.getRecipe_id());

        // Inserting Row
        db.insert(TABLE_RECIPE, null, values);

        // Closing database connection
        db.close();*/
    }


    public /*Favorite*/ void getRecipe(int id) {
        /*SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RECIPE, new String[] {COLUMN_RECIPE_ID,
                        COLUMN_FAVORITE_USERID, COLUMN_FAVORITE_RECIPEID}, COLUMN_RECIPE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Favorite favorite = new Favorite(cursor.getString(0),
                cursor.getString(1), cursor.getString(2));
        // return note
        return favorite;*/
    }


    public List<Favorite> getAllRecipes() {
        List<Favorite> favorites = new ArrayList<Favorite>();
        String selectQuery = "SELECT  * FROM " + TABLE_RECIPE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Favorite favorite = new Favorite();
                favorite.setId(cursor.getString(0));
                favorite.setUser_id(cursor.getString(1));
                favorite.setRecipe_id(cursor.getString(2));
                // Adding note to list
                favorites.add(favorite);
            } while (cursor.moveToNext());
        }

        // return note list
        return favorites;
    }

    public int getRecipeCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RECIPE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        // return count
        return count;
    }


    public int updateFavorite(Favorite favorite) {
        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FAVORITE_USERID, favorite.getUser_id());
        values.put(COLUMN_FAVORITE_RECIPEID, favorite.getRecipe_id());

        // updating row
        return db.update(TABLE_RECIPE, values, COLUMN_RECIPE_ID + " = ?",
                new String[]{String.valueOf(favorite.getId())});*/
        return 0;
    }

    public void deleteRecipe(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RECIPE, COLUMN_RECIPE_ID + " = ?",
                new String[] { String.valueOf(favorite.getId()) });
        db.close();
    }
}

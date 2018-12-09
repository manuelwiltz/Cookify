package at.a5bhitm.cookify.cookify.sqLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import at.a5bhitm.cookify.cookify.entities.Favorite;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Cookify";

    // Table name: Note.
    private static final String TABLE_FAVORITE = "Favorite";

    private static final String COLUMN_FAVORITE_ID = "Id";
    private static final String COLUMN_FAVORITE_USERID = "User_Id";
    private static final String COLUMN_FAVORITE_RECIPEID = "Recipe_Id";

    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script.
        String script = "CREATE TABLE " + TABLE_FAVORITE + "("
                + COLUMN_FAVORITE_ID + " INTEGER PRIMARY KEY," + COLUMN_FAVORITE_USERID + " TEXT,"
                + COLUMN_FAVORITE_RECIPEID + " TEXT" + ")";
        // Execute Script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE);

        // Create tables again
        onCreate(db);
    }


    // If table has no data
    // default, Insert 2 records.
    public void createDefaultNotesIfNeed()  {
        int count = this.getFavoritesCount();
        if(count ==0 ) {
            Favorite favorite = new Favorite("1", "1");
            Favorite favorite1 = new Favorite("2", "2");
            this.addFavorite(favorite);
            this.addFavorite(favorite1);
        }
    }


    public void addFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FAVORITE_USERID, favorite.getUser_id());
        values.put(COLUMN_FAVORITE_RECIPEID, favorite.getRecipe_id());

        // Inserting Row
        db.insert(TABLE_FAVORITE, null, values);

        // Closing database connection
        db.close();
    }


    public Favorite getFavorite(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FAVORITE, new String[] {COLUMN_FAVORITE_ID,
                        COLUMN_FAVORITE_USERID, COLUMN_FAVORITE_RECIPEID}, COLUMN_FAVORITE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Favorite favorite = new Favorite(cursor.getString(0),
                cursor.getString(1), cursor.getString(2));
        // return note
        return favorite;
    }


    public List<Favorite> getAllFavorites() {
        List<Favorite> favorites = new ArrayList<Favorite>();
        String selectQuery = "SELECT  * FROM " + TABLE_FAVORITE;

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

    public int getFavoritesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FAVORITE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        // return count
        return count;
    }


    public int updateFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FAVORITE_USERID, favorite.getUser_id());
        values.put(COLUMN_FAVORITE_RECIPEID, favorite.getRecipe_id());

        // updating row
        return db.update(TABLE_FAVORITE, values, COLUMN_FAVORITE_ID + " = ?",
                new String[]{String.valueOf(favorite.getId())});
    }

    public void deleteFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITE, COLUMN_FAVORITE_ID + " = ?",
                new String[] { String.valueOf(favorite.getId()) });
        db.close();
    }
}

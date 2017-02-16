package com.austinzeller.habittrack;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.austinzeller.habittrack.data.HabitContract;
import com.austinzeller.habittrack.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
    }

    private void insertHabits() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Keys are the Column names.
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Take a walk.");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_STATUS, HabitContract.HabitEntry.STATUS_INCOMPLETE);
        // Insert the new row, returning the primary key value of the new row.
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);


        values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Take Medicine");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_STATUS, HabitContract.HabitEntry.STATUS_COMPLETED);
        newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);


        values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Drink Coffee");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_STATUS, HabitContract.HabitEntry.STATUS_COMPLETED);
        newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);
    }

    private Cursor databaseInfo() {
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Create/Open a database to read from it.
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Projection for viewing which columnss we want
        String[] projection = {HabitContract.HabitEntry._ID, HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_STATUS};

        // Create the cursor object.
        return db.query(HabitContract.HabitEntry.TABLE_NAME, projection, null, null, null,
                null, null);
    }
}

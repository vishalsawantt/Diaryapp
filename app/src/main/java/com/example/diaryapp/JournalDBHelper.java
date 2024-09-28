package com.example.diaryapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class JournalDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "JournalDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_JOURNAL = "journals";

    public static final String KEY_ID = "id";
    public static final String KEY_MOOD = "mood";
    public static final String KEY_DATE = "date";
    public static final String KEY_CONTENT = "content";

    public JournalDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_JOURNAL_TABLE = "CREATE TABLE " + TABLE_JOURNAL + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_MOOD + " TEXT, " +
                KEY_DATE + " TEXT, " +
                KEY_CONTENT + " TEXT);";
        db.execSQL(CREATE_JOURNAL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOURNAL);
        onCreate(db);
    }

    public void addJournal(String mood, String date, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOOD, mood);
        values.put(KEY_DATE, date);
        values.put(KEY_CONTENT, content);
        db.insert(TABLE_JOURNAL, null, values);
        db.close();
    }

    public List<Journal> getAllJournals() {
        List<Journal> journalList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_JOURNAL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Journal journal = new Journal();
                journal.setId(cursor.getInt(0));
                journal.setMood(cursor.getString(1));
                journal.setDate(cursor.getString(2));
                journal.setContent(cursor.getString(3));
                journalList.add(journal);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return journalList;
    }
    public void deleteJournal(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_JOURNAL, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}


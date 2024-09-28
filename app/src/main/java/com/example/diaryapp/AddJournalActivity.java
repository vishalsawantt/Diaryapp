package com.example.diaryapp;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddJournalActivity extends AppCompatActivity {

    private EditText etContent;
    private Spinner spinnerMood;
    private Button btnAddJournal;
    private JournalDBHelper dbHelper;  // Declare JournalDBHelper instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journal);

        etContent = findViewById(R.id.etContent);
        spinnerMood = findViewById(R.id.spinnerMood);
        btnAddJournal = findViewById(R.id.btnAddJournal);

        // Initialize the database helper
        dbHelper = new JournalDBHelper(this);  // Initialize the JournalDBHelper

        // Automatically set the current date
        String currentDate = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date());
        setStatusBarColorToWhite();


        btnAddJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mood = spinnerMood.getSelectedItem().toString();
                String content = etContent.getText().toString();

                // Add a log to check what mood is selected
                Log.d("AddJournalActivity", "Selected Mood: " + mood);

                if (!content.isEmpty()) {
                    dbHelper.addJournal(mood, currentDate, content);
                    finish(); // Go back to MainActivity
                }
            }
        });

    }

    private void setStatusBarColorToWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);

            // To make the status bar text dark (visible on a light background)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }
}


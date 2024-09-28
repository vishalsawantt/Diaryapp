package com.example.diaryapp;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class JournalDetailsActivity extends AppCompatActivity {

    private TextView tvMoodDetails, tvDateDetails, tvContentDetails;
    private Button btnDeleteJournal;
    private int journalId;
    private JournalDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_details);

        tvMoodDetails = findViewById(R.id.tvMoodDetails);
        tvDateDetails = findViewById(R.id.tvDateDetails);
        tvContentDetails = findViewById(R.id.tvContentDetails);
        btnDeleteJournal = findViewById(R.id.btnDeleteJournal);

        dbHelper = new JournalDBHelper(this);

        // Get the root layout to set the background color
        View rootLayout = findViewById(R.id.rootLayout);

        // Get the intent that started this activity
        if (getIntent() != null) {
            journalId = getIntent().getIntExtra("id", -1);
            String mood = getIntent().getStringExtra("mood");
            String date = getIntent().getStringExtra("date");
            String content = getIntent().getStringExtra("content");
            int bgColor = getIntent().getIntExtra("bg_color", Color.WHITE); // Default to white if no color

            // Set the received data to the TextViews
            tvMoodDetails.setText("Mood: " + mood);
            tvDateDetails.setText("Date: " + date);
            tvContentDetails.setText(content);

            // Set the background color of the root layout
            rootLayout.setBackgroundColor(bgColor);
        }

        setStatusBarColorToWhite();

        // Delete button functionality
        btnDeleteJournal.setOnClickListener(v -> {
            if (journalId != -1) {
                dbHelper.deleteJournal(journalId);
                Toast.makeText(JournalDetailsActivity.this, "Journal deleted", Toast.LENGTH_SHORT).show();
                finish(); // Close the current activity after deletion
            } else {
                Toast.makeText(JournalDetailsActivity.this, "Error deleting journal", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setStatusBarColorToWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // Correctly set the status bar color using Color.parseColor
            window.setStatusBarColor(Color.parseColor("#F5F5F5"));

            // To make the status bar text dark (visible on a light background)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

}

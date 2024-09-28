package com.example.diaryapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvJournals;
    private JournalDBHelper dbHelper;
    private JournalAdapter journalAdapter;
    private List<Journal> journalList;
    private List<Journal> filteredList; // List to hold filtered journals
    private FloatingActionButton fabAddJournal;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvJournals = findViewById(R.id.rvJournals);
        fabAddJournal = findViewById(R.id.fabAddJournal);
        searchView = findViewById(R.id.searchView);

        dbHelper = new JournalDBHelper(this);
        journalList = new ArrayList<>();
        filteredList = new ArrayList<>();
        journalAdapter = new JournalAdapter(this, filteredList);

        rvJournals.setLayoutManager(new LinearLayoutManager(this));
        rvJournals.setAdapter(journalAdapter);

        // Load existing journal entries
        loadJournals();
        setStatusBarColorToWhite();

        CardView cardSearch = findViewById(R.id.cardSearch);

        // Set up click listener on the card to expand the search view
        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Expand the search view and request focus
                searchView.setIconified(false); // Expand the search view
                searchView.requestFocus(); // Request focus for typing
            }
        });

        fabAddJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddJournalActivity.class);
                startActivity(intent);
            }
        });

        // Setup search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterJournals(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterJournals(newText);
                return false;
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

    private void loadJournals() {
        journalList.clear();
        journalList.addAll(dbHelper.getAllJournals());
        filteredList.clear();
        filteredList.addAll(journalList); // Initially, display all journals
        journalAdapter.notifyDataSetChanged();
    }

    private void filterJournals(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(journalList); // If search is empty, show all entries
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (Journal journal : journalList) {
                if (journal.getMood().toLowerCase().contains(lowerCaseQuery) ||
                        journal.getDate().toLowerCase().contains(lowerCaseQuery) ||
                        journal.getContent().toLowerCase().contains(lowerCaseQuery)) {
                    filteredList.add(journal);
                }
            }
        }
        journalAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadJournals(); // Reload the journal entries when coming back to MainActivity
    }
}

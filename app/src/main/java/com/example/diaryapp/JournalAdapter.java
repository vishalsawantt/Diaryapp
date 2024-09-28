package com.example.diaryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {

    private Context context;
    private List<Journal> journalList;

    public JournalAdapter(Context context, List<Journal> journalList) {
        this.context = context;
        this.journalList = journalList;
    }

    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.journal_item, parent, false);
        return new JournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        Journal journal = journalList.get(position);
        holder.tvMood.setText(journal.getMood());
        holder.tvDate.setText(journal.getDate());
        holder.tvContent.setText(journal.getContent());

        // Set the CardView background color based on the mood
        String mood = journal.getMood().toLowerCase();
        int color;

        switch (mood) {
            case "happy":
                color = ContextCompat.getColor(context, R.color.happy);
                break;
            case "sad":
                color = ContextCompat.getColor(context, R.color.sad);
                break;
            case "excited":
                color = ContextCompat.getColor(context, R.color.excited);
                break;
            case "angry":
                color = ContextCompat.getColor(context, R.color.angry);
                break;
            case "calm":
                color = ContextCompat.getColor(context, R.color.calm);
                break;
            case "nostalgic":
                color = ContextCompat.getColor(context, R.color.nostalgic);
                break;
            case "anxious":
                color = ContextCompat.getColor(context, R.color.anxious);
                break;
            case "hopeful":
                color = ContextCompat.getColor(context, R.color.hopeful);
                break;
            case "confused":
                color = ContextCompat.getColor(context, R.color.confused);
                break;
            case "grateful":
                color = ContextCompat.getColor(context, R.color.grateful);
                break;
            case "content":
                color = ContextCompat.getColor(context, R.color.content);
                break;
            case "overwhelmed":
                color = ContextCompat.getColor(context, R.color.overwhelmed);
                break;
            case "inspired":
                color = ContextCompat.getColor(context, R.color.inspired);
                break;
            case "frustrated":
                color = ContextCompat.getColor(context, R.color.frustrated);
                break;
            case "joyful":
                color = ContextCompat.getColor(context, R.color.joyful);
                break;
            case "relaxed":
                color = ContextCompat.getColor(context, R.color.relaxed);
                break;
            case "determined":
                color = ContextCompat.getColor(context, R.color.determined);
                break;
            case "curious":
                color = ContextCompat.getColor(context, R.color.curious);
                break;
            case "lonely":
                color = ContextCompat.getColor(context, R.color.lonely);
                break;
            case "pensive":
                color = ContextCompat.getColor(context, R.color.pensive);
                break;
            default:
                color = ContextCompat.getColor(context, R.color.default_color);
                break;
        }


        holder.cardView.setCardBackgroundColor(color);

        // Set an OnClickListener to open JournalDetailsActivity
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, JournalDetailsActivity.class);
            intent.putExtra("id", journal.getId()); // Pass journal id if needed
            intent.putExtra("mood", journal.getMood());
            intent.putExtra("date", journal.getDate());
            intent.putExtra("content", journal.getContent());
            intent.putExtra("bg_color", color); // Pass the background color
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public static class JournalViewHolder extends RecyclerView.ViewHolder {
        TextView tvMood, tvDate, tvContent;
        CardView cardView;

        public JournalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMood = itemView.findViewById(R.id.tvMood);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvContent = itemView.findViewById(R.id.tvContent);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

package com.example.diaryapp;

public class Journal {
    private int id;
    private String mood;
    private String date;
    private String content;

    public Journal() {
    }

    public Journal(int id, String mood, String date, String content) {
        this.id = id;
        this.mood = mood;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

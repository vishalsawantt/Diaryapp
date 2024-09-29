# Journal App with SQLite

## Overview
This project is a simple journaling application for Android, designed to allow users to record their thoughts and memories. The app uses an SQLite database for storing and managing journal entries, ensuring persistence of user data locally on the device.

## Features
- **Add New Journal Entries**: Users can write and save new journal entries with details like mood, date, and full content.
- **Delete Entries**: Users can delete them if needed.
- **Local Storage**: Uses SQLite to save all data on the user's device, making the app accessible offline.
- **User Interface**: A simple and clean UI for easy navigation and usability. Mood, date, and content are displayed in distinct sections.

## Screenshots

## Setup Instructions

### Prerequisites
- Android Studio
- Android SDK
  
## Usage
- Add Journal Entry: Click the "Add Entry" button to create a new journal.
- View Details: Select any journal entry to view full details, including mood and content.
- Edit Entry: On the details screen, click the "Edit" button to update the journal.
- Delete Entry: Click the "Delete Journal" button to remove the entry permanently.

## Project Structure
- DatabaseHelper.java: Contains the SQLite database setup, including creating tables, inserting, updating, deleting, and retrieving journal entries.
- JournalDetailsActivity.java: Displays the details of the journal, including mood, date, and content. Also includes options to edit or delete the entry.
- MainActivity.java: The main entry point of the app where users can see a list of journal entries.

## Technical Details
### Database: SQLite
- The DatabaseHelper class manages the database, including creation and CRUD operations.
- Data is stored in a table named journal_entries, with columns for ID, date, mood, and content.
### UI Components:
- RecyclerView: To display a list of all journal entries.
- LinearLayout and ScrollView: For arranging views in the details and main screen.
### Styling: 
- Uses XML-based layouts with rounded corners, color themes based on user mood, and modern Material Design components.

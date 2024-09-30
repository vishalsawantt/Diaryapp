# Journal App with SQLite

## Overview
This project is a simple journaling application for Android, designed to allow users to record their thoughts and memories. The app uses an SQLite database for storing and managing journal entries, ensuring persistence of user data locally on the device.


## Features
- **Add New Journal Entries**: Users can write and save new journal entries with details like mood, date, and full content.
- **Delete Entries**: Users can delete them if needed.
- **Local Storage**: Uses SQLite to save all data on the user's device, making the app accessible offline.
- **User Interface**: A simple and clean UI for easy navigation and usability. Mood, date, and content are displayed in distinct sections.


## Screenshots
1. **Splach_Screen**, **Main_Activity**, and **Create_Journal_Activity**  
   <div style="display: flex; justify-content: space-between;">
      <img src="https://github.com/user-attachments/assets/cb9a1fc2-fc4a-4584-8cd3-0612f989db31" alt="CreateAccount_activity" width="200">
      <img src="https://github.com/user-attachments/assets/8e0cbf37-7431-42cb-af2d-c939f3547250" alt="Login_Activity" width="200">
      <img src="https://github.com/user-attachments/assets/10ddb08f-377a-4977-9566-e4928beeaeae" alt="Login_Activity" width="200">
  </div>
   
2. **Content_Details_Activity**, **Content_Details_ActivityTwo** 
    <div style="display: flex; justify-content: space-between;">
      <img src="https://github.com/user-attachments/assets/f664fdab-ce5c-4389-a7b3-bf59979a6b46" alt="Home_Fragment" width="200">
      <img src="https://github.com/user-attachments/assets/82b47384-cfae-4d3a-93ee-19026c608b6d" alt="CreateAccount_activity" width="200">
   </div>

   
## Usage
- Add Journal Entry: Click the "Add Journal" button to create a new journal.
- View Details: Select any journal entry to view full details, including mood and content.
- Delete Entry: Click the "Delete Journal" button to remove the entry permanently.


## Project Structure
- DatabaseHelper.java: Contains the SQLite database setup, including creating tables, inserting, deleting, and retrieving journal entries.
- JournalDetailsActivity.java: Displays the details of the journal, including mood, date, and content. Also includes option to delete the entry.
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


## Download
[Uploading app-debug [MConverter.eu].zip…]()


## About Me
I am a passionate Android developer with experience in Java and Android Studio. This app demonstrates my skills in Android app development and my commitment to creating functional and user-friendly applications.


## Contact
For any questions or feedback, please feel free to reach out at [sawantvishal2001@gmail.com].  

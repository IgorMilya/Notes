package com.example.notes2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import io.realm.Realm;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText titleInput = findViewById(R.id.titleinput);
        EditText descriptionInput = findViewById(R.id.descriptioninput);
        MaterialButton saveBtn = findViewById(R.id.savebtn);


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString().trim();
                String description = descriptionInput.getText().toString().trim();

                if (title.isEmpty() || description.isEmpty()) {
                    showToast("Title and description cannot be empty");
                } else {
                    long createdTime = System.currentTimeMillis();

                    realm.beginTransaction();
                    Note note = realm.createObject(Note.class);
                    note.setTitle(title);
                    note.setDescription(description);
                    note.setCreatedTime(createdTime);
                    realm.commitTransaction();

                    showToast("Note saved");
                    finish();
                }
            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
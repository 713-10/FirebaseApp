package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebaseapp.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SaveDataActivity extends AppCompatActivity {
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        db = FirebaseFirestore.getInstance();

        EditText dataInput = findViewById(R.id.dataInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputData = dataInput.getText().toString();
                if (inputData.isEmpty()) {
                    Toast.makeText(SaveDataActivity.this, "Please enter data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String, Object> data = new HashMap<>();
                data.put("content", inputData);

                db.collection("documents")
                        .add(data)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText(SaveDataActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(SaveDataActivity.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }
}

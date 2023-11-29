package com.example.ismail_giobal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {

    EditText text1, text2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        btn1 = findViewById(R.id.btn2);
        btn2 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    // validateUsername and validatePassword methods remain unchanged

    public void checkUser() {
        String userUsername = text1.getText().toString().trim();
        String userPassword = text2.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    text1.setError(null);
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String passwordFromDB = childSnapshot.child("password").getValue(String.class);

                        if (passwordFromDB != null && passwordFromDB.equals(userPassword)) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class); // Replace MainActivity with your intended activity
                            startActivity(intent);
                            return;
                        }
                    }
                    text2.setError("Invalid Credentials");
                    text2.requestFocus();
                } else {
                    text1.setError("User does not exist");
                    text1.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database errors if needed
            }
        });
    }
}

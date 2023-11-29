package com.example.ismail_giobal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.ismail_giobal.databinding.ActivityMenuBinding;

public class Menu extends AppCompatActivity {

    ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMenuBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
        binding.closeBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Menu.super.onBackPressed ();
            }
        });
    }
}
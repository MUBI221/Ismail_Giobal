package com.example.ismail_giobal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.ismail_giobal.databinding.ActivityMenuBinding;
import com.example.ismail_giobal.databinding.ActivityOrderBinding;

public class Order extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_order);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = ActivityOrderBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
        binding.backbtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Order.super.onBackPressed ();
            }
        });
    }
}
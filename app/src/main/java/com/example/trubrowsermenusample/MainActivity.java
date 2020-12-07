package com.example.trubrowsermenusample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private IteoraBottomAppSettingsLayout bottomAppSettingsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppSettingsLayout = findViewById(R.id.iteora_bottom_app_settings_layout);
        ((Button) findViewById(R.id.btn_click)).setOnClickListener((v) -> {
            bottomAppSettingsLayout.toggleBottomAppSettingsLayout();
        });
    }
}
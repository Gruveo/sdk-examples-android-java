package com.gruveo.sdk.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gruveo.sdk.Gruveo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Gruveo.Builder(MainActivity.this).callCode("hellofromsdk").clientId("demo").build();
            }
        });
    }
}

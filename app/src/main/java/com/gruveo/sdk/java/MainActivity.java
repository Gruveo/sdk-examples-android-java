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
                final String result = new Gruveo.Builder(MainActivity.this).callCode("gruveorocks").clientId("demo").build();
                switch (result) {
                    case Gruveo.GRV_RES_MISSING_CALL_CODE: {
                        break;
                    }
                    case Gruveo.GRV_RES_INVALID_CALL_CODE: {
                        break;
                    }
                    case Gruveo.GRV_RES_MISSING_CREDENTIALS: {
                        break;
                    }
                    case Gruveo.GRV_RES_INVALID_CREDENTIALS: {
                        break;
                    }
                    case Gruveo.GRV_RES_OFFLINE: {
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        });
    }
}

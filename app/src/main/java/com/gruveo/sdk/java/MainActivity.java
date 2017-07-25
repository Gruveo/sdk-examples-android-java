package com.gruveo.sdk.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.gruveo.sdk.Gruveo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_video_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCall(true);
            }
        });

        findViewById(R.id.main_voice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCall(false);
            }
        });
    }

    private void initCall(Boolean videoCall) {
        final String code = ((EditText) findViewById(R.id.main_edittext)).getText().toString();
        final String result = new Gruveo.Builder(this).callCode(code).videoCall(videoCall).clientId("demo").eventsListener(eventsListener).build();
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

    private Gruveo.EventsListener eventsListener = new Gruveo.EventsListener() {
        @Override
        public void callInit(boolean videoCall, String code) {

        }

        @Override
        public void callEstablished(String code) {

        }

        @Override
        public void callEnd(Intent data, boolean isInForeground) {

        }
    };
}

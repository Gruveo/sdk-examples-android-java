package com.gruveo.sdk.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.gruveo.sdk.Gruveo;
import com.gruveo.sdk.model.CallErrorType;
import com.gruveo.sdk.model.GrvConstants;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;

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
        final Bundle otherExtras = new Bundle();
        otherExtras.putBoolean(GrvConstants.GRV_EXTRA_VIBRATE_IN_CHAT, false);

        final String code = ((EditText) findViewById(R.id.main_edittext)).getText().toString();
        final String result = new Gruveo.Builder(this)
                .callCode(code)
                .videoCall(videoCall)
                .clientId("demo")
                .requestCode(REQUEST_CALL)
                .otherExtras(otherExtras)
                .eventsListener(eventsListener)
                .build();

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
            case Gruveo.GRV_RES_MISSING_SIGNER_URL: {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CALL && resultCode == RESULT_OK && data != null) {
            CallErrorType error = (CallErrorType) data.getSerializableExtra(GrvConstants.GRV_RES_CALL_ERROR);
            String callCode = data.getStringExtra(GrvConstants.GRV_RES_CALL_CODE);
            int duration = data.getIntExtra(GrvConstants.GRV_RES_CALL_DURATION, 0);
            int messagesExchanged = data.getIntExtra(GrvConstants.GRV_RES_MESSAGES_EXCHANGED, 0);

            switch (error) {
                case BUSY: {
                    break;
                }
                case DIRECT_BUSY: {
                    break;
                }
                case DIRECT_UNREACHABLE: {
                    break;
                }
                case DIRECT_NONEXIST: {
                    break;
                }
                case DIRECT_CALLING_SELF: {
                    break;
                }
                case FREE_MULTIPARTY_ENDED: {
                    break;
                }
                case MULTIPARTY_NOT_SUPPORTED: {
                    break;
                }
                case FREE_DEMO_ENDED: {
                    break;
                }
                case ROOM_LIMIT_REACHED: {
                    break;
                }
                case NO_CONNECTION: {
                    break;
                }
                case NONE: {
                    break;
                }
            }
        }
    }
}

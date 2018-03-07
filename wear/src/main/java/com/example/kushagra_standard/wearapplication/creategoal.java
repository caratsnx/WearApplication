package com.example.kushagra_standard.wearapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class creategoal extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategoal);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }
    public void clickSave(View v)
    {
        finish();
    }
    public void clickName(View v)
    {
        displaySpeechRecognizer(0);
    }
    public void clickAmount(View v)
    {
        displaySpeechRecognizer(1);
    }
    private static final int SPEECH_REQUEST_CODE = 0;

    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer(int code) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, code);
    }

    // This callback is invoked when the Speech Recognizer returns.
// This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            ((EditText)findViewById(R.id.editText)).setText(spokenText);
            // Do something with spokenText
        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            ((EditText)findViewById(R.id.editText1)).setText(spokenText);
            // Do something with spokenText
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

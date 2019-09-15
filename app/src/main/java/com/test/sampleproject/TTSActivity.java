package com.test.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class TTSActivity extends AppCompatActivity {

    private TextToSpeech mTextToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        TextView textView = findViewById(R.id.tts_call_text);
        EditText editText = findViewById(R.id.tts_edit);
        EditText pitchEdit = findViewById(R.id.tts_pitch_edit);
        EditText speechEdit = findViewById(R.id.tts_speech_edit);
        TextView downText = findViewById(R.id.tts_down_text);
        mTextToSpeech = new TextToSpeech(this, i -> {
            if (i == TextToSpeech.SUCCESS) {
                mTextToSpeech.setLanguage(Locale.KOREA);
            }
        });

        textView.setOnClickListener(v -> {
            //음성 톤
            try {
                float pitchDouble = Float.valueOf(pitchEdit.getText().toString().trim());
                float speechDouble = Float.valueOf(speechEdit.getText().toString().trim());
                mTextToSpeech.setPitch(pitchDouble);
                //읽는 속도
                mTextToSpeech.setSpeechRate(speechDouble);
                mTextToSpeech.speak(editText.getText().toString().trim(), TextToSpeech.QUEUE_FLUSH, null, null);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
            }
        });
        downText.setOnClickListener(v -> {
            getDown(editText.getText().toString().trim());
        });
    }

    private void getDown(String text) {
        File file = new File(new File(Environment.getExternalStorageDirectory(), "Download"), text + ".mp3");
        mTextToSpeech.synthesizeToFile(text, null, file, "tts");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }
    }
}

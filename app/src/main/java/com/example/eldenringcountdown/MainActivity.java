package com.example.eldenringcountdown;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView cdTimerText;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("here");
        setContentView(R.layout.activity_main);
        cdTimerText = findViewById(R.id.countText);
        timer = new Timer();
        startCountDown();
    }

    private void startCountDown() {
        timer.schedule(new UpdateUITask(),0,1000);
    }

    private class UpdateUITask extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(() -> {
                    cdTimerText.setText(CountDownHelper.getRemainingTimeAsText(Instant.now().getEpochSecond()));
            });
        }

    }

}
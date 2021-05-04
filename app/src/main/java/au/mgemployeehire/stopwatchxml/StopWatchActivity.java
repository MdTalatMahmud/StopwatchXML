package au.mgemployeehire.stopwatchxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    private Button buttonStart, buttonStop;
    private ImageView icanchor;
    private Animation roundingAnimation;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        //find id
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        icanchor = findViewById(R.id.icanchor);
        chronometer = findViewById(R.id.chronometerID);

        roundingAnimation = AnimationUtils.loadAnimation(this, R.anim.rounding_animation);

        //button functionality
        buttonStop.setAlpha(0);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingAnimation);
                //button animation
                buttonStop.animate().alpha(1).setDuration(500).start();
                buttonStart.animate().alpha(0).setDuration(500).start();

                //chronometer adding
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();

                buttonStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chronometer.stop();
                        icanchor.getAnimation().cancel();
                        icanchor.clearAnimation();
                        buttonStop.animate().alpha(0).setDuration(500).start();
                        buttonStart.animate().alpha(1).setDuration(500).start();
                    }
                });
            }
        });

    }
}
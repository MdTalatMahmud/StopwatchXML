package au.mgemployeehire.stopwatchxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button getStarted;
    private Animation atg;
    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStarted = findViewById(R.id.getStarted);
        ivSplash = findViewById(R.id.ivSplash);
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);

        //passing animation
        ivSplash.startAnimation(atg);

        getStarted.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
            startActivity(intent);
        });
    }
}
package com.example.animation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    int windowWidth, windowHeight;
    GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.framelayout_top);
//        gameView = new GameView(this, windowWidth, windowHeight);
//        frameLayout.addView(gameView);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        windowHeight = frameLayout.getHeight();
        windowWidth = frameLayout.getWidth();
        gameView = new GameView(this, windowWidth, windowHeight);
        frameLayout.addView(gameView);
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//    }
}
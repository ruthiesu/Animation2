package com.example.animation2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import static android.graphics.Rect.intersects;

public class GameView extends SurfaceView implements Runnable {
    private int viewWidth, viewHeight;
    private Player player;
    private Obstacle planet;
    private Background background;
    private Thread thread;

    public GameView(Context context, int width, int height) {
        super(context);

        viewWidth = width;
        viewHeight = height;

        Bitmap planetImage = BitmapFactory.decodeResource(getResources(), R.drawable.planet);
        planet = new Obstacle(planetImage, viewWidth, viewHeight);

        Bitmap playerImage = BitmapFactory.decodeResource(getResources(), R.drawable.tardis);
        // TODO 2
        playerImage = Bitmap.createScaledBitmap(playerImage, 100, 100, false);

        player = new Player(playerImage, viewWidth, viewHeight);

        Bitmap backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.space_star_universe_sky);


        background = new Background(backgroundImage, viewWidth, viewHeight);
        thread = new Thread(this);
        thread.start();
    }

    public void drawSurface() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            background.draw(canvas);
            planet.draw(canvas);
            player.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);
//
        }

    }


    // TODO 1
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                player.setTarget(event.getX(), event.getY());

                background.setTarget(event.getX(), event.getY());
                //       invalidate();
                break;
            default:
                break;
        }

        return true;
    }


    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {
            drawSurface();
            player.move();
            background.move();
            planet.move();
            if (player.checkCollision(planet)) {
                gameOver = true;
            }
            synchronized (this) {
                try {
                    wait(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}

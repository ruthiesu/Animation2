package com.example.animation2;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Obstacle extends Sprite {
    public Obstacle(Bitmap image, int viewWidth, int viewHeight) {
        super(image, viewWidth, viewHeight);
        x = 400;
        y = 500;
        targetX = x;
        targetY = y;
        rect = new Rect(x,y,x+image.getWidth(), y+y+image.getHeight());
    }

    @Override
    public void move() {

    }
}

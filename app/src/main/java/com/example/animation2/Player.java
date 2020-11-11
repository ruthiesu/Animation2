package com.example.animation2;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;

public class Player extends Sprite {
     public Player(Bitmap image, int viewWidth, int viewHeight) {
        super(image, viewWidth, viewHeight);
         x = 0;
         y = 0;
         targetX = x;
         targetY = y;
    }
    public void move() {

        if (Math.abs(targetX - x) >= 5) {
            if (x < targetX) x += 5;
            else x -= 5;
        }
        if (Math.abs(targetY - y) >= 5) {
            if (y < targetY) y += 5;
            else y -= 5;
        }

        rect.set(x,y,x+image.getWidth(), y+image.getHeight());

    }

    public void rotateTowardsTarget(){
    Matrix matrix = new Matrix();
    float angle = 0;
        if (targetX > x && targetY > y){ angle = 45;}
        else if ((targetX > x && targetY < y)){angle = -45;}
        else if ((targetX > x && targetY == y)){angle = 0;}
        else if ((targetX < x && targetY > y)){angle = 135;}
        else if ((targetX < x && targetY < y)){angle = -135;}
        else if ((targetX < x && targetY == y)){angle = -180;}
        else if ((targetX == x && targetY > y)){angle = 90;}
        else if ((targetX == x && targetY < y)){angle = -90;}
        else if ((targetX == x && targetY == y)){angle = 0;}


        matrix.postRotate(angle);
    image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
}
}

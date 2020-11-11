package com.example.animation2;

import android.graphics.Bitmap;
import android.util.Log;

public class Background extends Sprite {
    public Background(Bitmap image, int viewWidth, int viewHeight) {
        super(image, viewWidth, viewHeight);
        targetX = x;
        targetY = y;
        x=0;
        y=0;
    }
    public void move() {
//      if (Math.abs(x+ (image.getWidth()/2) - targetX) >= 5) {
//            if (x+ (image.getWidth()/2) < targetX) x -= 5;
//            else x += 5;
//       }
//        if (Math.abs(y+(image.getHeight()/2) - targetY) >= 5){
//            if (y+(image.getHeight()/2)< targetY) y -= 5;
//            else y += 5;
//        }
    }
}

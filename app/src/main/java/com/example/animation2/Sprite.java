package com.example.animation2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;

public abstract class Sprite {
    protected int x=0;
    protected int y=0;
    protected int targetX = 0;
    protected int targetY = 0;

    protected int speedX = 0;
    protected int speedY = 0;

    protected Bitmap image;
    protected int viewWidth, viewHeight;

    protected Rect rect;

    public Sprite(Bitmap image, int viewWidth, int viewHeight) {
        this.image = image;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        rect = new Rect(x,y,x+image.getWidth(), y+y+image.getHeight());
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public abstract void move();

    public void setTarget(float x, float y){
        targetX = (int) x;
        targetY = (int) y;
        rotateTowardsTarget();
    }

    public void rotateTowardsTarget(){}

    public Rect getRect(){return rect;}

   public boolean checkCollision(Sprite other) {
        int left = Math.max(x, other.x);
        int right = Math.min(x+image.getWidth(), other.x+other.image.getWidth());
        int top = Math.max(y, other.y);
        int bottom = Math.min(y+image.getHeight(), other.y+other.image.getHeight());
        for (int row  = left; row < right; row++) {
            for (int col = top; col < bottom; col++) {
                if (image.getPixel(row-x, col-y)!= Color.TRANSPARENT &&
                        other.image.getPixel(row-other.x, col-other.y)!= Color.TRANSPARENT) {
                    return true;
                }
            }
        }
        return false;
    }




}

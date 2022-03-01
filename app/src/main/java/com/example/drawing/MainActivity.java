package com.example.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new SurfaceView(this));
    }

    class SurfaceView extends View {

        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path;

        public SurfaceView(Context context) {
            super(context);
            path = new Path();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLACK);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                path.moveTo(event.getX(), event.getY());
            } else if (action == MotionEvent.ACTION_MOVE) {
                path.lineTo(event.getX(), event.getY());
            } else if (action == MotionEvent.ACTION_UP) {
                path.lineTo(event.getX(), event.getY());
            }
            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            if (path != null) canvas.drawPath(path, paint);
        }
    }
}
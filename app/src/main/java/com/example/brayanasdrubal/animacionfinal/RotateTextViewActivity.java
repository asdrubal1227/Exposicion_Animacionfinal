package com.example.brayanasdrubal.animacionfinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class RotateTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RotateTextView rotateTextView = new RotateTextView(this);
        setContentView(rotateTextView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rotate_text_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

class RotateTextView extends View {

    private String message = "     Code Project";

    public RotateTextView(Context context) {
        super(context);
        this.setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        canvas.translate(viewWidth / 2, viewHeight / 2);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setTextSize(45f);
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setShadowLayer(5.0f, 10.0f, 10.0f, Color.BLACK);

        for (int i = 0; i < 10; i++) {

            canvas.drawText(message, 0, 0, paint);

            canvas.rotate(36);
        }
    }
}
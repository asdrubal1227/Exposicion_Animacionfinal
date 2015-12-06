package com.example.brayanasdrubal.animacionfinal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class ShapeDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ShapeDrawableView shapeDrawableView = new ShapeDrawableView(this);
        setContentView(shapeDrawableView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shape_drawable, menu);
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

class ShapeDrawableView extends View {

    int startX, startY, endX, endY;

    private List<ShapeDrawable> shapeDrawables =
            new ArrayList<ShapeDrawable>();

    public ShapeDrawableView(ShapeDrawableActivity context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(ShapeDrawable shapeDrawable: shapeDrawables) {
            shapeDrawable.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            startX = (int)event.getX();
            startY = (int)event.getY();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP){
            endX = (int)event.getX();
            endY = (int)event.getY();
            if (startX > endX) {
                int tmp = startX;
                startX = endX;
                endX = tmp;
            }
            if (startY > endY) {
                int tmp = startY;
                startY = endY;
                endY = tmp;
            }

            Shape shape = new RectShape();
            ShapeDrawable shapeDrawable = new ShapeDrawable(shape);
            shapeDrawable.setBounds(startX, startY, endX, endY);
            shapeDrawable.getPaint().setColor(Color.BLUE);
            shapeDrawables.add(shapeDrawable);
            invalidate();

            return true;
        }
        return false;
    }
}
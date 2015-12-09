package com.example.brayanasdrubal.animacionfinal;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DrawableAnimationActivity extends AppCompatActivity {


    AnimationDrawable slideShowAnimation;
    AnimationDrawable slideShowAnimation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);


        ImageView slideShow = (ImageView) findViewById(R.id.imageViewSlideShow);
        slideShow.setBackgroundResource(R.drawable.slide_show);
        slideShowAnimation = (AnimationDrawable) slideShow.getBackground();

        ImageView slideShow2 = (ImageView) findViewById(R.id.imageViewSlideShow2);
        slideShow2.setBackgroundResource(R.drawable.vuelo);
        slideShowAnimation2 = (AnimationDrawable) slideShow2.getBackground();
    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            slideShowAnimation.start();
            slideShowAnimation2.start();
            return true;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawable_animation, menu);
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

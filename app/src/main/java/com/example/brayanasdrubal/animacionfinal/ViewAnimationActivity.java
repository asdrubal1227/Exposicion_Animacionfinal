package com.example.brayanasdrubal.animacionfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
    }

    public void getTogether(View view) {

        ImageView imageView = (ImageView) findViewById(R.id.imageView1 );
        move(imageView);

        imageView = (ImageView) findViewById(R.id.imageView2 );
        move(imageView);

        imageView = (ImageView) findViewById(R.id.imageView3 );
        move(imageView);

        imageView = (ImageView) findViewById(R.id.imageView4);
        move(imageView);

        imageView = (ImageView) findViewById(R.id.imageView5);
        move(imageView);
    }

    private void move( View view )
    {
        // Get the x, y coordinates of the screen center
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int x_centerOfScreen = (displayMetrics.widthPixels / 2) - (view.getMeasuredWidth() / 2);
        int y_centerOfScreen = (displayMetrics.heightPixels / 2) - (view.getMeasuredHeight() / 2);

        // Get the starting coordinates of the view
        int startPosition[] = new int[2];
        view.getLocationOnScreen(startPosition);

        AnimationSet animationSet = new AnimationSet(false);

        RotateAnimation rotate = new RotateAnimation(0,360,
                Animation.RELATIVE_TO_SELF, 0.5f , Animation.RELATIVE_TO_SELF,0.5f );
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setDuration(2000);

        animationSet.addAnimation(rotate);

        TranslateAnimation translate =  new TranslateAnimation(Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, x_centerOfScreen - startPosition[0],
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, y_centerOfScreen - startPosition[1]);
        translate.setInterpolator(new AccelerateDecelerateInterpolator());
        translate.setDuration(2000);
        animationSet.addAnimation(translate);

        animationSet.setFillAfter(true);

        view.startAnimation(animationSet);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_animation, menu);
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

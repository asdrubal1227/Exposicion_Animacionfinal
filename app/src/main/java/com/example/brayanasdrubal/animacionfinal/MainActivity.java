package com.example.brayanasdrubal.animacionfinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getPropertyAnimation(View view) {
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);

    }

    public void getViewAnimation(View view) {
        Intent intent = new Intent(this, ViewAnimationActivity.class);
        startActivity(intent);

    }

    public void getDrawableAnimation(View view) {
        Intent intent = new Intent(this,   DrawableAnimationActivity.class);
        startActivity(intent);

    }

    public void getCanvas(View view) {
        Intent intent = new Intent(this,   ShapeDrawableActivity.class);
        startActivity(intent);

    }

    public void getTransformation(View view) {
        Intent intent = new Intent(this,   RotateTextViewActivity.class);
        startActivity(intent);

    }

    public void getOpengles(View view) {
        Intent intent = new Intent(this,   OpenGLActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

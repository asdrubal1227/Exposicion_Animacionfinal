package com.example.brayanasdrubal.animacionfinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;


public class ShapeDrawableActivity extends AppCompatActivity {

    DrawingView dv ;
    private Paint mPaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dv = new DrawingView(this);//Crea una vista
        setContentView(dv);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.STROKE);//Estilo del dibujo capa completa o lineal

        mPaint.setStrokeCap(Paint.Cap.ROUND);//Terminacion de la linea redonda, recta u otros
        mPaint.setStrokeWidth(12);//Ancho de la linea
    }

    public class DrawingView extends View {

        public int width;
        public  int height;
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {//Se dibuja el circulo del touch
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
        }


        ////////************touching events for painting**************///////



        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;//Sensibilidad, al tocar la pantalla cuanto tiene que esperar para hacer una lectura correcta

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);//Establece la posición en pantalla al hacer clic
            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y) { //Calculo matematico para dibujar las curvas
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {//Parece quadTo () dibuja una línea curva, en base a una función cuadrática(mas suavez),
            // o en otras palabras, una parábola. lineTo () simplemente dibuja una línea recta.
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
                //Toast.makeText(MainActivity.this,Float.toString(mX),Toast.LENGTH_LONG).show();
                circlePath.reset();
                circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
            }
        }

        private void touch_up() {
            mPath.lineTo(mX, mY);
            circlePath.reset();
            // confirmar el camino hacia fuera de la pantalla
            mCanvas.drawPath(mPath,  mPaint);
            // Lo eliminamos para no dibujar 2 veces lo mismo
            mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();//Lee posición de pantalla
            float y = event.getY();

            switch (event.getAction()) {// cuando el usuario toca primero la pantalla, el sistema ofrece un evento de toque
            // y un conjunto de valores de los ejes que incluyen la coordenadas X e Y del tacto y la información acerca de la presión,
            // el tamaño y orientación de la zona de contacto.
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }


}


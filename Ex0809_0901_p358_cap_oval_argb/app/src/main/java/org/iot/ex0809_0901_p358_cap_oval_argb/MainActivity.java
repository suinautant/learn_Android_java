package org.iot.ex0809_0901_p358_cap_oval_argb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(new MyGraphicsView(this));
   }

   private class MyGraphicsView extends View {
      public MyGraphicsView(Context context) {
         super(context);
      }

      @Override
      protected void onDraw(Canvas canvas) {
         super.onDraw(canvas);
         Paint paint = new Paint();
         paint.setAntiAlias(true);

         paint.setStrokeWidth(30);
//         canvas.drawLine(10, 10, 500, 100, paint);
         paint.setStrokeCap(Paint.Cap.SQUARE);
         Rect rect1 = new Rect(10, 10, 10+500, 10+100);
         canvas.drawRect(rect1, paint);

         paint.setStrokeCap(Paint.Cap.ROUND);
         Rect rect2 = new Rect(10, 200, 10+500, 200+100);
         canvas.drawRect(rect2, paint);

         paint.setStrokeCap(Paint.Cap.BUTT);
         Rect rect3 = new Rect(10, 350, 10+500, 350+100);
         canvas.drawRect(rect3, paint);
      }
   }
}
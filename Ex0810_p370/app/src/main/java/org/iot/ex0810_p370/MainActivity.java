package org.iot.ex0810_p370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(new MyPic(this));
   }

   private static class MyPic extends View {
      public MyPic(Context context) {
         super(context);
      }

      @Override
      protected void onDraw(Canvas canvas) {
         super.onDraw(canvas);
         Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monkeys);

         int picX = (this.getWidth() - bitmap.getWidth()) / 2;
         int picY = (this.getHeight() - bitmap.getHeight()) / 2;
         int cenX = this.getWidth() / 2;
         int cenY = this.getHeight() / 2;

         Paint paint = new Paint();
         paint.setColor(Color.GRAY);

//         p370
//         EmbossMaskFilter eMask;
//         eMask = new EmbossMaskFilter(new float[]{3, 3, 3,}, 0.5f, 5, 10);
//         paint.setMaskFilter(eMask);
//         canvas.drawCircle(cenX, cenY, 150, paint);

//          371
//         BlurMaskFilter bMask;
//         bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
//         paint.setMaskFilter(bMask);
//         canvas.drawBitmap(bitmap, picX, picY, paint);
//         bitmap.recycle();

      }
   }
}
package org.iot.ex0810_p368;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
         Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

         int cenX = this.getWidth() / 2;
         int cenY = this.getHeight() / 2;
         int picX = (this.getWidth() - bitmap.getWidth()) / 2;
         int picY = (this.getHeight() - bitmap.getHeight()) / 2;

//         canvas.rotate(45, cenX, cenY);
         //canvas.drawBitmap(bitmap, picX, picY, null);

//         canvas.translate(-150, 200);
//         canvas.drawBitmap(bitmap, picX, picY, null);

//         canvas.scale(2, 2, cenX, cenY);
//         canvas.drawBitmap(bitmap, picX, picY, null);

         canvas.skew(0.3f, 0.3f);
         canvas.drawBitmap(bitmap, picX, picY, null);

         bitmap.recycle();
      }
   }

}
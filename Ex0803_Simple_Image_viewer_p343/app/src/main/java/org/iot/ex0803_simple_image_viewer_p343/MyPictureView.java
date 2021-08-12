package org.iot.ex0803_simple_image_viewer_p343;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPictureView extends View {
   String imagePath = null;

   public MyPictureView(Context context, @Nullable AttributeSet attrs) {
      super(context, attrs);
   }

   @Override
   protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);

      if (imagePath != null) {
         canvas.drawColor(Color.BLACK);
         Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
         int y = (canvas.getHeight() - bitmap.getHeight()) / 2;
         int x = (canvas.getWidth() - bitmap.getWidth()) / 2;
         canvas.drawBitmap(bitmap, x, y, null);
         bitmap.recycle();
         System.out.println("MyPictureVIew ************************************" + imagePath);
      }
   }
}
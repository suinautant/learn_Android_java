package org.iot.ex0824_p440__1102_gallery_movie_poster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("갤러리 영화 포스터");

      Gallery gallery = (Gallery) findViewById(R.id.gallery);
      MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
      gallery.setAdapter(galAdapter);
   }

   public class MyGalleryAdapter extends BaseAdapter {
      Context context;
      Integer[] posterID = {
              R.drawable.suyangha01,
              R.drawable.suyangha02,
              R.drawable.suyangha03,
              R.drawable.suyangha04,
              R.drawable.suyangha05,
              R.drawable.suyangha06,
              R.drawable.suyangha07,
              R.drawable.suyangha08,
              R.drawable.suyangha09
      };

      String[] posterTitles = {
              "서양화 - 1",
              "서양화 - 2",
              "서양화 - 3",
              "서양화 - 4",
              "서양화 - 5",
              "서양화 - 6",
              "서양화 - 7",
              "서양화 - 8",
              "서양화 - 9"
      };

      public MyGalleryAdapter(Context context) {
         this.context = context;
      }

      @Override
      public int getCount() {
         return posterID.length;
      }

      @Override
      public Object getItem(int position) {
         return null;
      }

      @Override
      public long getItemId(int position) {
         return 0;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
         ImageView imageview = new ImageView(context);
         imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
         imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
         imageview.setPadding(5, 5, 5, 5);
         imageview.setImageResource(posterID[position]);

         imageview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
               ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
               ivPoster.setImageResource(posterID[position]);
               Toast.makeText(getApplicationContext(), posterTitles[position], Toast.LENGTH_SHORT).show();

               return false;
            }
         });

         return imageview;
      }

   }
}
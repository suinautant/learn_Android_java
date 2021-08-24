package org.iot.ex0823_p434_1101_movie_post;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("그리드뷰 영화 포스터");

      final GridView gv = (GridView) findViewById(R.id.gridView1);
      MyGridAdapter gAdapter = new MyGridAdapter(this);
      gv.setAdapter(gAdapter);
   }

   public class MyGridAdapter extends BaseAdapter {
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
      String[] posterTitle = {
              "서양화01",
              "서양화02",
              "서양화03",
              "서양화04",
              "서양화05",
              "서양화06",
              "서양화07",
              "서양화08",
              "서양화09"
      };

      public MyGridAdapter(Context c) {
         context = c;
      }

      public int getCount() {
         return posterID.length;
      }

      public Object getItem(int arg0) {
         return null;
      }

      public long getItemId(int arg0) {
         return 0;
      }

      public View getView(int position, View convertView, ViewGroup parent) {
         ImageView imageview = new ImageView(context);
         imageview.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
         imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
         imageview.setPadding(5, 5, 5, 5);

         imageview.setImageResource(posterID[position]);
         final int pos = position;
         imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
               AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
               ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
               ivPoster.setImageResource(posterID[pos]);
//               dlg.setTitle("큰 포스터");
               dlg.setTitle(posterTitle[pos]);
               dlg.setIcon(R.drawable.ic_launcher_foreground);
               dlg.setView(dialogView);
               dlg.setNegativeButton("닫기", null);
               dlg.show();
            }
         });

         return imageview;
      }
   }


}
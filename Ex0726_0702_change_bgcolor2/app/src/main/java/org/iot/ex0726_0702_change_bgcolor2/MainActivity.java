package org.iot.ex0726_0702_change_bgcolor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
   Button btn, btn1, btn2;
   LinearLayout baseLayout;
   ImageView img;

   @Override
   public boolean onContextItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
         case R.id.itemRed:
            baseLayout.setBackgroundColor(Color.RED);
            return true;
         case R.id.itemGreen:
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
         case R.id.itemBlue:
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
         case R.id.subRotate:
            float tmpGetRotate = btn.getRotation();
            tmpGetRotate += 45;
            btn.setRotation(tmpGetRotate);
            return true;
         case R.id.subSize:
            float tmpGetScale = btn.getScaleX();
            tmpGetScale += 2;
            btn.setScaleX(tmpGetScale);
            return true;
         case R.id.img1:
            img.setImageResource(R.drawable.pie);
            return true;
         case R.id.img2:
            img.setImageResource(R.drawable.q);
            return true;
         case R.id.img3:
            img.setImageResource(R.drawable.r);
            return true;
      }
      return false;
   }

   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
      super.onCreateContextMenu(menu, v, menuInfo);

      MenuInflater mInflaster = getMenuInflater();
      if (v == btn1) {
         menu.setHeaderTitle("배경색 변경");
         mInflaster.inflate(R.menu.menu1, menu);
      }
      if (v == btn2) {
         menu.setHeaderTitle("버튼 변경");
         mInflaster.inflate(R.menu.menu2, menu);
      }
      if (v == img) {
         menu.setHeaderTitle("사진 변경");
         mInflaster.inflate(R.menu.menu, menu);
      }
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("배경색 바꾸기 컨텍스트 메뉴");
      baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
      btn = (Button) findViewById(R.id.btn);
      btn1 = (Button) findViewById(R.id.btn1);
      btn2 = (Button) findViewById(R.id.btn2);
      img = (ImageView) findViewById(R.id.img);

      registerForContextMenu(btn1);
      registerForContextMenu(btn2);
      registerForContextMenu(img);
   }
}
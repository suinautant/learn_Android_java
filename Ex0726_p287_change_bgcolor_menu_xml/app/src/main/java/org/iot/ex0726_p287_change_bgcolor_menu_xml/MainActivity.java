package org.iot.ex0726_p287_change_bgcolor_menu_xml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
   LinearLayout baseLayout;
   Button button1;

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater mInflater = getMenuInflater();
      mInflater.inflate(R.menu.menu1, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
            float tmpGetRotate = button1.getRotation();
            tmpGetRotate += 45;
            button1.setRotation(tmpGetRotate);
            return true;
         case R.id.subSize:
            float tmpGetScale = button1.getScaleX();
            tmpGetScale += 2;
            button1.setScaleX(tmpGetScale);
            return true;
      }
      return false;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("배경색 바꾸기");

      baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
      button1 = (Button) findViewById(R.id.button1);


   }
}
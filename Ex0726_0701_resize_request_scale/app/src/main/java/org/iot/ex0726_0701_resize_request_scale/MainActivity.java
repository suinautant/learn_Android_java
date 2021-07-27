package org.iot.ex0726_0701_resize_request_scale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView text;
   EditText edit;
   ImageView img;

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
         case R.id.itemRotate:
            float rotateEditValue = Float.parseFloat(edit.getText().toString());
            System.out.println(rotateEditValue);
            img.setRotation(rotateEditValue);
            return true;
         case R.id.item1:
            img.setImageResource(R.drawable.pie);
            return true;
         case R.id.item2:
            img.setImageResource(R.drawable.q);
            return true;
         case R.id.item3:
            img.setImageResource(R.drawable.r);
            return true;
      }
      return false;
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater mInflater = getMenuInflater();
      mInflater.inflate(R.menu.menu, menu);
      return true;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("제주도 풍경");

      text = (TextView) findViewById(R.id.text);
      edit = (EditText) findViewById(R.id.edit);
      img = (ImageView) findViewById(R.id.img);
   }
}
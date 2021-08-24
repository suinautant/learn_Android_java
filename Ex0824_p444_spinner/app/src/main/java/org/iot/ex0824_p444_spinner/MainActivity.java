package org.iot.ex0824_p444_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("스피너 테스트");

      final String[] movie = {
              "서양화 - 1",
              "서양화 - 2",
              "서양화 - 3",
              "서양화 - 4",
              "서양화 - 5",
              "서양화 - 6",
              "서양화 - 7",
              "서양화 - 8",
              "서양화 - 9",
      };
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
      ImageView imageview = (ImageView) findViewById(R.id.imageview);
      Spinner spinner = (Spinner) findViewById(R.id.spinner);
      ArrayAdapter<String> adapter;
      adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie);
//      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie);
      spinner.setAdapter(adapter);

      spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("onItemSelected position : " + position + " / id : " + id);
            ImageView imageview = (ImageView) findViewById(R.id.imageview);
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setImageResource(posterID[position]);
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) { }
      });
   }

}
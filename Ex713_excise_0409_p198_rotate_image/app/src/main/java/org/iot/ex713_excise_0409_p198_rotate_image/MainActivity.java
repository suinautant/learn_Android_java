package org.iot.ex713_excise_0409_p198_rotate_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   Button button;
   ImageView imageView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setIcon(R.drawable.android);
      setTitle("연습 문제 4-9");

      button = (Button) findViewById(R.id.button);
      imageView = (ImageView) findViewById(R.id.imageView);

      button.setOnClickListener(new View.OnClickListener() {
         float angle;
         @Override
         public void onClick(View v) {
            angle += 10;
            imageView.setRotation(angle);
         }
      });


   }
}
package org.iot.ex0726_sliding_pane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      SlidingPaneLayout spLayout = (SlidingPaneLayout) findViewById(R.id.spLayout);
      ImageView imageView = (ImageView) findViewById(R.id.imageView2);
      Button btnOpen = (Button) findViewById(R.id.btnOpen);
      Button btnClose = (Button) findViewById(R.id.btnClose);

      btnOpen.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            spLayout.openPane();
         }
      });

      btnClose.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            spLayout.closePane();
         }
      });

      spLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
         @Override
         public void onPanelSlide(@NonNull View panel, float slideOffset) {
            imageView.setRotation(360);
         }

         @Override
         public void onPanelOpened(@NonNull View panel) {
            Toast.makeText(getApplicationContext(), "오픈 슬라이드", Toast.LENGTH_SHORT).show();

         }

         @Override
         public void onPanelClosed(@NonNull View panel) {
            Toast.makeText(getApplicationContext(), "클로즈 슬라이드", Toast.LENGTH_SHORT).show();

         }
      });


   }
}
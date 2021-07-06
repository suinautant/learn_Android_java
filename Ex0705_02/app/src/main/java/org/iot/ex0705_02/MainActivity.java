package org.iot.ex0705_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   // 버튼 생성
   Button btnNate;
   Button btnEmergency;
   Button btnGallery;
   Button btnFinish;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // 각 ID에 대한 버튼 접근
      btnNate = (Button) findViewById(R.id.btnNate);
      btnEmergency = (Button) findViewById(R.id.btnEmergency);
      btnGallery = (Button) findViewById(R.id.btnGallery);
      btnFinish = (Button) findViewById(R.id.btnFinish);

      // 버튼 배경 색상 설정
      btnNate.setBackgroundColor(Color.GRAY);
      btnEmergency.setBackgroundColor(Color.GREEN);
      btnGallery.setBackgroundColor(Color.RED);
      btnFinish.setBackgroundColor(Color.YELLOW);

      // 버튼 클릭 이벤트 리스터와 핸들러
      btnNate.setOnClickListener(v -> {
         Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
         startActivity(mlntent);
      });

      btnEmergency.setOnClickListener(v -> {
         Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
         startActivity(mlntent);
      });

      btnGallery.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(mlntent);
         }
      });

      btnFinish.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });
   }
}
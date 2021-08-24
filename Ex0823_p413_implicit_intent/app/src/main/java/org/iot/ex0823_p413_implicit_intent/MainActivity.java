package org.iot.ex0823_p413_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("암시적 인텐트 예제");
      android.util.Log.i("액티비티 테스트", "onCreate()");

      Button btnDial = (Button) findViewById(R.id.btnDial);
      Button btnWeb = (Button) findViewById(R.id.btnWeb);
      Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
      Button btnSearch = (Button) findViewById(R.id.btnSearch);
      Button btnSms = (Button) findViewById(R.id.btnSms);
      Button btnPhoto = (Button) findViewById(R.id.btnPhoto);
      Button btnFinish = (Button) findViewById(R.id.btnFinish);

      btnDial.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Uri uri = Uri.parse("tel:01012345678");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
         }
      });

      btnWeb.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Uri uri = Uri.parse("http://www.hanbit.co.kr");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
         }
      });

      btnGoogle.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Uri uri = Uri.parse("https://maps.google.co.kr/map?q=" + 37.559133 + "," + 126.927824 + "&z=" + 15);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
         }
      });

      btnSearch.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "안드로이드");
            startActivity(intent);
         }
      });

      btnSms.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.putExtra("sms_body", "안녕하세요?");
            intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
            startActivity(intent);
         }
      });

      btnPhoto.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
         }
      });

      btnFinish.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      android.util.Log.i("액티비티 테스트", "onDestroy()");
   }

   @Override
   protected void onPause() {
      super.onPause();
      android.util.Log.i("액티비티 테스트", "onPause()");
   }

   @Override
   protected void onRestart() {
      super.onRestart();
      android.util.Log.i("액티비티 테스트", "onRestart()");
   }

   @Override
   protected void onResume() {
      super.onResume();
      android.util.Log.i("액티비티 테스트", "onResume()");
   }

   @Override
   protected void onStart() {
      super.onStart();
      android.util.Log.i("액티비티 테스트", "onStart()");
   }

   @Override
   protected void onStop() {
      super.onStop();
      android.util.Log.i("액티비티 테스트", "onStop()");
   }
}
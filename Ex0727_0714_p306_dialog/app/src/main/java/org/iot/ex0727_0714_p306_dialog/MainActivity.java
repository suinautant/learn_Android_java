package org.iot.ex0727_0714_p306_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      String[] versionArray = new String[]{"pi", "q", "r"};
      boolean[] checkArray = new boolean[]{true, false, false};

      setTitle("대화 상자");
      Button btn1 = (Button) findViewById(R.id.btn1);
      btn1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("좋아하는 버전은?")
//                    .setMessage("이곳이 내용입니다")
                    .setIcon(R.mipmap.ic_launcher_round)
//                    .setItems(versionArray, new DialogInterface.OnClickListener() {
//                       @Override
//                       public void onClick(DialogInterface dialog, int which) {
//                          btn1.setText(versionArray[which]);
//                       }
//                    })
//                    .setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                       @Override
//                       public void onClick(DialogInterface dialog, int which) {
//                          btn1.setText(versionArray[which]);
//                       }
//                    })
                    .setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                          btn1.setText(versionArray[which]);
                       }
                    })
                    .setPositiveButton("닫기", null)
                    .show();
         }
      });
   }
}
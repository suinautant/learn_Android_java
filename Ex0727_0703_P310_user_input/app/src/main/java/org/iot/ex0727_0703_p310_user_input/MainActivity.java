package org.iot.ex0727_0703_p310_user_input;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
   TextView tvName, tvEmail;
   Button button1;
   EditText dlgEdtName, dlgEdtEmail;
   TextView toastText;
   View dialogView, toastView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("사용자 정보 입력");

      tvName = (TextView) findViewById(R.id.tvName);
      tvEmail = (TextView) findViewById(R.id.tvEmail);
      button1 = (Button) findViewById(R.id.btn1);

      button1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("사용자 정보 입력")
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setView(dialogView)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                          dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                          dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                          tvName.setText(dlgEdtName.getText().toString());
                          tvEmail.setText(dlgEdtName.getText().toString());
                       }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                          Toast toast = new Toast(MainActivity.this);
                          toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                          toastText = (TextView) toastView.findViewById(R.id.toastText1);
                          toastText.setText("취소했습니다");
                          toast.setView(toastView);
                          toast.show();
                       }
                    })
                    .show();
         }
      });

   }
}
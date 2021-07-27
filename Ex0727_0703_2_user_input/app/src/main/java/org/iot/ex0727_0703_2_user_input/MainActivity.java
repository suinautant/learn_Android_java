package org.iot.ex0727_0703_2_user_input;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
   Button button1;
   EditText dlgEdtName, dlgEdtEmail, edtName, edtEmail;
   TextView toastText;
   View dialogView, toastView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("사용자 정보 입력");

      edtName = (EditText) findViewById(R.id.edtName);
      edtEmail = (EditText) findViewById(R.id.edtEmail);
      button1 = (Button) findViewById(R.id.btn1);

      button1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {


            dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("사용자 정보 입력");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setView(dialogView);

            dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
            dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

            dlgEdtName.setText(edtName.getText().toString());
            dlgEdtEmail.setText(edtEmail.getText().toString());

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                  edtName.setText(dlgEdtName.getText().toString());
                  edtEmail.setText(dlgEdtEmail.getText().toString());
               }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                  Toast toast = new Toast(MainActivity.this);
                  Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                  int offsetX = (int) (Math.random() * display.getWidth());
                  int offsetY = (int) (Math.random() * display.getHeight());
                  toast.setGravity(Gravity.TOP | Gravity.RIGHT , offsetX, offsetY);
                  toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                  toastText = (TextView) toastView.findViewById(R.id.toastText1);
                  toastText.setText("취소했습니다");
                  toast.setView(toastView);
                  toast.show();
               }
            });
            builder.show();
         }
      });

   }
}
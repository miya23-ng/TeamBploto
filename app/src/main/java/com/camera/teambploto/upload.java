package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class upload extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    int a = 0;
    int b = 0;
    Uri uri1;
    Uri uri2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

    }

    public void ok_onClick(View v) {
        if (uri1 != null && uri2 != null) {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("確認")
                    .setMessage("写真を選択してください。")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }

    public void photo_onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
        if(a == 0){
            a++;
        }
        if(b == 1){
            b--;
        }
    }

    public void photo2_onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
        if(b == 0){
            b++;
        }
        if(a == 1){
            a--;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();

                if(a == 1) {
                    TextView text = findViewById(R.id.textView17);
                    text.setText(String.format("1枚目：%s", uri));
                    uri1 = resultData.getData();
                }
                if(b ==1) {
                    TextView text = findViewById(R.id.textView18);
                    text.setText(String.format("2枚目：%s", uri));
                    uri2 = resultData.getData();
                }
            }
        }
    }

    public void onBackPressed() {
    }
}
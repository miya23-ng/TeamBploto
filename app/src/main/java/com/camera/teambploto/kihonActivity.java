package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class kihonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kihon);
        RadioGroup radi = findViewById(R.id.radioGroup);
    }

    public void button7_onClick(View v) {
        RadioGroup radi = findViewById(R.id.radioGroup);

        int checkedId = radi.getCheckedRadioButtonId();
        String text = "";

        if (checkedId != -1){
            RadioButton radioButton = findViewById(checkedId);
            text =radioButton.getText().toString();

        }else{
            new AlertDialog.Builder(this)
                .setTitle("確認")
                .setMessage("性別を選択してください。")
                .setPositiveButton("OK",null)
                .show();

        }


        EditText nick = findViewById(R.id.nick);
        Intent i = new Intent();
        i.putExtra("nick" , nick.getText().toString() + text);
        setResult(RESULT_OK,i);

        int leng = nick.length();
        if(leng > 1 && checkedId != -1) {
            finish();
        }else if(leng < 2){
            new AlertDialog.Builder(this)
                .setTitle("確認")
                .setMessage("ニックネームを2文字以上入力してください。")
                .setPositiveButton("OK",null)
                .show();
            }

        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public void onBackPressed() {
    }
}

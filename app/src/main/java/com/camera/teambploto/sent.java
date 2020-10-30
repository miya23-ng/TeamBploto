package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class sent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);
    }

    public void button6_onClick(View v){
        CheckBox chk = findViewById(R.id.checkBox);
        if(chk.isChecked() == true) {
            finish();
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("確認")
                    .setMessage("同意ボタンにチェックしてください。")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}

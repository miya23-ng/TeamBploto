package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class anke2 extends AppCompatActivity {
    int straight = 0;
    int wave = 0;
    int natural =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anke2);

    }

    public void button5_onClick(View v) {
        straight = 0;
        wave = 0;
        natural = 0;
        RadioGroup radi = findViewById(R.id.radioGroup6);
        RadioGroup radi2 = findViewById(R.id.radioGroup7);
        RadioGroup radi3 = findViewById(R.id.radioGroup8);
        RadioGroup radi4 = findViewById(R.id.radioGroup9);
        RadioGroup radi5 = findViewById(R.id.radioGroup16);
        RadioGroup radi6 = findViewById(R.id.radioGroup17);
        RadioGroup radi7 = findViewById(R.id.radioGroup18);
        RadioGroup radi8 = findViewById(R.id.radioGroup19);
        RadioGroup radi9 = findViewById(R.id.radioGroup20);

        int checkedId = radi.getCheckedRadioButtonId();
        int checkedId2 = radi2.getCheckedRadioButtonId();
        int checkedId3 = radi3.getCheckedRadioButtonId();
        int checkedId4 = radi4.getCheckedRadioButtonId();
        int checkedId5 = radi5.getCheckedRadioButtonId();
        int checkedId6= radi6.getCheckedRadioButtonId();
        int checkedId7 = radi7.getCheckedRadioButtonId();
        int checkedId8 = radi8.getCheckedRadioButtonId();
        int checkedId9 = radi9.getCheckedRadioButtonId();

        if (checkedId != -1){
            RadioButton radioButton = findViewById(checkedId);

            switch (checkedId){
                case R.id.radioButton36 :
                    straight++;
                    break;

                case R.id.radioButton37 :
                    wave++;
                    break;

                case R.id.radioButton38 :
                    natural++;
                    break;
            }

        }

        if (checkedId2 != -1){
            RadioButton radioButton = findViewById(checkedId2);

            switch (checkedId2){
                case R.id.radioButton39 :
                    straight++;
                    break;

                case R.id.radioButton40 :
                    wave++;
                    break;

                case R.id.radioButton41 :
                    natural++;
                    break;

            }

        }

        if (checkedId3 != -1){
            RadioButton radioButton = findViewById(checkedId3);

            switch (checkedId3){
                case R.id.radioButton42 :
                    straight++;
                    break;

                case R.id.radioButton43 :
                    wave++;
                    break;

                case R.id.radioButton44 :
                    natural++;
                    break;

            }

        }

        if (checkedId4 != -1){
            RadioButton radioButton = findViewById(checkedId4);

            switch (checkedId4){
                case R.id.radioButton45 :
                    straight++;
                    break;

                case R.id.radioButton46 :
                    wave++;
                    break;

                case R.id.radioButton47 :
                    natural++;
                    break;

            }

        }

        if (checkedId5 != -1){
            RadioButton radioButton = findViewById(checkedId5);

            switch (checkedId5){
                case R.id.radioButton48 :
                    straight++;
                    break;

                case R.id.radioButton49 :
                    wave++;
                    break;

                case R.id.radioButton50 :
                    natural++;
                    break;

            }

        }
        if (checkedId6 != -1){
            RadioButton radioButton = findViewById(checkedId6);

            switch (checkedId6){
                case R.id.radioButton :
                    straight++;
                    break;

                case R.id.radioButton2 :
                    wave++;
                    break;

                case R.id.radioButton5 :
                    natural++;
                    break;

            }

        }

        if (checkedId7 != -1){
            RadioButton radioButton = findViewById(checkedId7);

            switch (checkedId7){
                case R.id.radioButton6 :
                    straight++;
                    break;

                case R.id.radioButton18 :
                    wave++;
                    break;

                case R.id.radioButton19 :
                    natural++;
                    break;

            }

        }

        if (checkedId8 != -1){
            RadioButton radioButton = findViewById(checkedId8);

            switch (checkedId8){
                case R.id.radioButton20 :
                    straight++;
                    break;

                case R.id.radioButton21 :
                    wave++;
                    natural++;
                    break;

            }

        }

        if (checkedId9 != -1){
            RadioButton radioButton = findViewById(checkedId9);

            switch (checkedId9){
                case R.id.radioButton56 :
                    straight++;
                    break;

                case R.id.radioButton57 :
                    wave++;
                    break;

                case R.id.radioButton58 :
                    natural++;
                    break;

            }

        }

        int jug = straight + wave + natural;
        if (jug >= 9) {
            if (straight > wave && straight > natural) {
                Toast.makeText(this, ("ストレートタイプでした。"), Toast.LENGTH_SHORT)
                        .show();
            }
            if (wave > straight && wave > natural) {
                Toast.makeText(this, ("ウェーブタイプでした。"), Toast.LENGTH_SHORT)
                        .show();
            }
            if (natural > straight && natural > wave) {
                Toast.makeText(this, ("ナチュラルタイプでした。"), Toast.LENGTH_SHORT)
                        .show();
            }
            if (natural == wave){
                Toast.makeText(this, ("ナチュラルタイプでした。"), Toast.LENGTH_SHORT)
                        .show();
            }
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("確認")
                    .setMessage("選択されていない問があります。")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}

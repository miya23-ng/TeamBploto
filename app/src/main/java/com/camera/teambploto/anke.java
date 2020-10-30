package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class anke extends AppCompatActivity {
    int straight = 0;
    int wave = 0;
    int natural =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anke);

    }

    public void button4_onClick(View v) {
        straight = 0;
        wave = 0;
        natural = 0;
        RadioGroup radi = findViewById(R.id.radioGroup2);
        RadioGroup radi2 = findViewById(R.id.radioGroup3);
        RadioGroup radi3 = findViewById(R.id.radioGroup4);
        RadioGroup radi4 = findViewById(R.id.radioGroup15);
        RadioGroup radi5 = findViewById(R.id.radioGroup5);
        RadioGroup radi6 = findViewById(R.id.radioGroup10);
        RadioGroup radi7 = findViewById(R.id.radioGroup11);
        RadioGroup radi8 = findViewById(R.id.radioGroup12);
        RadioGroup radi9 = findViewById(R.id.radioGroup13);
        RadioGroup radi10 = findViewById(R.id.radioGroup14);

        int checkedId = radi.getCheckedRadioButtonId();
        int checkedId2 = radi2.getCheckedRadioButtonId();
        int checkedId3 = radi3.getCheckedRadioButtonId();
        int checkedId4 = radi4.getCheckedRadioButtonId();
        int checkedId5 = radi5.getCheckedRadioButtonId();
        int checkedId6= radi6.getCheckedRadioButtonId();
        int checkedId7 = radi7.getCheckedRadioButtonId();
        int checkedId8 = radi8.getCheckedRadioButtonId();
        int checkedId9 = radi9.getCheckedRadioButtonId();
        int checkedId10 = radi10.getCheckedRadioButtonId();

        if (checkedId != -1){
            RadioButton radioButton = findViewById(checkedId);

            switch (checkedId){
                case R.id.radioButton3 :
                    straight++;
                    wave++;
                    break;

                case R.id.radioButton4 :
                    natural++;
                    break;
            }

        }

        if (checkedId2 != -1){
            RadioButton radioButton = findViewById(checkedId2);

            switch (checkedId2){
                case R.id.radioButton7 :
                    straight++;
                    break;

                case R.id.radioButton8 :
                    wave++;
                    break;

                case R.id.radioButton9 :
                    natural++;
                    break;

            }

        }

        if (checkedId3 != -1){
            RadioButton radioButton = findViewById(checkedId3);

            switch (checkedId3){
                case R.id.radioButton10 :
                    straight++;
                    break;

                case R.id.radioButton11 :
                    wave++;
                    break;

                case R.id.radioButton12 :
                    natural++;
                    break;

            }

        }

        if (checkedId4 != -1){
            RadioButton radioButton = findViewById(checkedId4);

            switch (checkedId4){
                case R.id.radioButton53 :
                    straight++;
                    break;

                case R.id.radioButton54 :
                    wave++;
                    break;

                case R.id.radioButton55 :
                    natural++;
                    break;

            }

        }

        if (checkedId5 != -1){
            RadioButton radioButton = findViewById(checkedId5);

            switch (checkedId5){
                case R.id.radioButton13 :
                    straight++;
                    break;

                case R.id.radioButton16 :
                    wave++;
                    break;

                case R.id.radioButton17 :
                    natural++;
                    break;

            }

        }
        if (checkedId6 != -1){
            RadioButton radioButton = findViewById(checkedId6);

            switch (checkedId6){
                case R.id.radioButton23 :
                    straight++;
                    break;

                case R.id.radioButton24 :
                    wave++;
                    break;

                case R.id.radioButton25 :
                    natural++;
                    break;

            }

        }

        if (checkedId7 != -1){
            RadioButton radioButton = findViewById(checkedId7);

            switch (checkedId7){
                case R.id.radioButton26 :
                    straight++;
                    break;

                case R.id.radioButton27 :
                    wave++;
                    break;

                case R.id.radioButton28 :
                    natural++;
                    break;

            }

        }

        if (checkedId8 != -1){
            RadioButton radioButton = findViewById(checkedId8);

            switch (checkedId8){
                case R.id.radioButton29 :
                    straight++;
                    break;

                case R.id.radioButton30 :
                    wave++;
                    break;

                case R.id.radioButton31 :
                    natural++;
                    break;

            }

        }

        if (checkedId9 != -1){
            RadioButton radioButton = findViewById(checkedId9);

            switch (checkedId9){
                case R.id.radioButton32 :
                    straight++;
                    break;

                case R.id.radioButton33 :
                    wave++;
                    break;

                case R.id.radioButton34 :
                    natural++;
                    break;

            }

        }

        if (checkedId10 != -1){
            RadioButton radioButton = findViewById(checkedId10);

            switch (checkedId10){
                case R.id.radioButton35 :
                    straight++;
                    break;

                case R.id.radioButton51 :
                    wave++;
                    break;

                case R.id.radioButton52 :
                    natural++;
                    break;

            }

        }
        int jug = straight + wave + natural;
        if (jug >= 10) {
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

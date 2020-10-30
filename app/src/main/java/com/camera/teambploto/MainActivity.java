package com.camera.teambploto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import org.opencv.core.Mat;


//AWSインポート
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        int jug = 1;
        String nickname;
        String gender;

    static {
        System.loadLibrary("native-lib");
    }

        private savedata save;
        private Runnable runnable;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            findViewById(R.id.kihonbutton).setOnClickListener(this);
            findViewById(R.id.ankbutton).setOnClickListener(this);
            findViewById(R.id.upbutton).setOnClickListener(this);
            findViewById(R.id.keibutton).setOnClickListener(this);
            findViewById(R.id.resubutton).setOnClickListener(this);
            findViewById(R.id.sentbutton).setOnClickListener(this);


            // (1) Cognitoで出力した認証定義です
            CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                    getApplicationContext(),
                    "ap-northeast-1:c0619af1-5d09-4fab-8b56-4e51a64f5cfb", // ID プールの ID
                    Regions.AP_NORTHEAST_1 // リージョン
            );

            // (2) DynamoDBのクライアントセッションを作成します
            AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);

            // (3) デフォルトではUS-EASTがリージョンで指定されてしまうため意図的にAP_NORTHEASTにしています
            Region apNortheast1 = Region.getRegion(Regions.AP_NORTHEAST_1);
            ddbClient.setRegion(apNortheast1);

            // (4) マッパーのインスタンス作成
            final DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);

            // (5) インターネットのアクセスを行うためにスレッドを作成し、その中でインサート処理を定義します
            runnable = new Runnable() {
                public void run() {
                    savedata save = new savedata();
                    save.setname("プロジェクト");
                    save.setgend("女性");
                    save.setskel("ウェーブ");
                    Date date = new Date();
                    save.setReleasedate(date.toString());
                    mapper.save(save);
                }

            };
                Thread mythread = new Thread(runnable);
            mythread.start();
        }

        public void onClick (View v) {
            switch (v.getId()) {

                case R.id.kihonbutton:
                    Intent i = new Intent(this, kihonActivity.class);
                    startActivityForResult(i,1 );
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;


                case R.id.ankbutton:
                    if(jug == 1){
                        new AlertDialog.Builder(this)
                                .setTitle("確認")
                                .setMessage("基本情報を入力してください。")
                                .setPositiveButton("OK",null)
                                .show();

                    } else if(jug == 2){
                        startActivity(new Intent(this, anke2.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else if(jug == 0){
                        startActivity(new Intent(this, anke.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                    break;


                case R.id.upbutton:
                    startActivity(new Intent(this, upload.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;

                case R.id.keibutton:
                    startActivity(new Intent(this, measu.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;

                case R.id.resubutton:
                    startActivity(new Intent(this, result.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;

                case R.id.sentbutton:
                    startActivity(new Intent(this, sent.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;

                default:
                    break;
            }
    }

    @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent i){
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String nick = i.getStringExtra("nick");
            if(nick.endsWith("男性") && jug == 1) {
                jug++;
            }else if(nick.endsWith("男性") && jug == 0){
                jug = jug + 2;
            }else if(nick.endsWith("女性") && jug == 1){
                jug = jug -1;
            }else if(nick.endsWith("女性") && jug == 2){
                jug = jug -2;
            }
            int size = nick.length();
            int cut = 2;
            nickname = nick.substring(0,size - cut);
            gender = nick.substring(size - cut);
            Toast.makeText(this, String.format("%sさん登録ありがとうございます。", nick.substring(0,size - cut)), Toast.LENGTH_SHORT)
                    .show();
        }

    }

}

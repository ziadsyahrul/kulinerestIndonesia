package com.ziadsyahrul.kulinerestindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    //TODO 1 membuat variable untuk logika coding kita
    private long ms = 0;
    private long splashTime = 5000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);

        //TODO 2 Membuat Thread
        Thread mythread = new Thread(){
            public void run(){
                try{
                    //TODO 3 Melakukan perulangan sampai ms > splashTime
                    while(splashActive && ms < splashTime){
                        if (!paused){
                            ms = ms + 10;
                            sleep(10);
                            progressBar.setProgress((int)ms);
                        }
                    }
                }catch (Exception e) {


                } finally {
                    //TODO 4 setelah perulangan selesai maka akan berpindah halaman menggunakan intent
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        //menjalankan object mythread
        mythread.start();

    }
}


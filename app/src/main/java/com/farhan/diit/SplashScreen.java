package com.farhan.diit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashScreen extends AppCompatActivity {

    int SPLASH_TIME = 1800;
    ProgressBar progressBar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.splashProgress);

        playProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ConnectivityManager cm =(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo[]=cm.getAllNetworkInfo();


                //checking internet connectivity
                for( i=0;i<networkInfo.length;++i){
                    if(networkInfo[i].getState()==NetworkInfo.State.CONNECTED){
                        startActivity(new Intent(SplashScreen.this,MainActivity.class));
                        finish();
                        break;
                    }
                }

                if(i==networkInfo.length){
                    Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SplashScreen.this,NoInternetActivity.class));
                    finish();

                }

            }
        }, SPLASH_TIME);


    }
    private void playProgress() {

        ObjectAnimator.ofInt(progressBar, "progress", 100)
                .setDuration(200).start();
    }
}
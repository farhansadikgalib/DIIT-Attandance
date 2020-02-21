package com.farhan.diit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NoInternetActivity extends AppCompatActivity {

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

    }

    public void try_again(View view) {


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo[] = cm.getAllNetworkInfo();


        //checking internet connectivity
        for (i = 0; i < networkInfo.length; ++i) {
            if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                Toast.makeText(this, "Internet Connected", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                 finish();
                break;
            }
        }

        if (i == networkInfo.length) {
            Toast.makeText(getApplicationContext(), "Internet is not Connected!!", Toast.LENGTH_LONG).show();

        }

    }
}

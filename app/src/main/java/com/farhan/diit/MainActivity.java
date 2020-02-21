package com.farhan.diit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InternetConnectionCheck();
        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://attendance.diit.edu.bd/login");
        webView.setWebViewClient(new WebViewClient());


    }






    @Override
    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you really want to exit ??").setCancelable(false).
                    setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                         //   System.exit(0);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();





        }
    }


    public void facebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/farhansadikgalib"));
        startActivity(i);
        return ;

    }

    public void github(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://github.com/farhansadikgalib"));
        startActivity(i);
        return ;
    }

    public void aboutme(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://about.me/farhansadikgalib"));
        startActivity(i);
        return ;


    }




    private void InternetConnectionCheck() {

        ConnectivityManager cm =(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        //get all networks information
        NetworkInfo networkInfo[]=cm.getAllNetworkInfo();

        int i;

        //checking internet connectivity
        for(i=0;i<networkInfo.length;++i){
            if(networkInfo[i].getState()==NetworkInfo.State.CONNECTED){
                Toast.makeText(getApplicationContext(),"Internet Connected",Toast.LENGTH_LONG).show();

                break;
            }
        }

        if(i==networkInfo.length){
            Toast.makeText(getApplicationContext(),"Internet Not Connected",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,NoInternetActivity.class));
            finish();
        }
    }


    public void developer(View view) {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.alartdialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}

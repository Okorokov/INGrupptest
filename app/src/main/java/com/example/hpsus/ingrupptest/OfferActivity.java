package com.example.hpsus.ingrupptest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OfferActivity extends AppCompatActivity {

    private TextView tvDesfull,tvDes;
    private Button btnExit,btnNext;
    private ImageView ivLogo;
    private Offer data;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        getSupportActionBar().setTitle(MainActivity.name);

        tvDesfull = (TextView) findViewById(R.id.tvDesfull);
        tvDes = (TextView) findViewById(R.id.tvDes);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnNext = (Button) findViewById(R.id.btnNext);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        webView = (WebView) findViewById(R.id.webView);
        data= new Offer();

        Intent intent = getIntent();

        data.setId(intent.getIntExtra(MainActivity.KEY_ID,1));
        data.setName(intent.getStringExtra(MainActivity.KEY_NAME));
        data.setDes(intent.getStringExtra(MainActivity.KEY_DES));
        data.setLogo(intent.getStringExtra(MainActivity.KEY_LOGO));
        data.setUrl(intent.getStringExtra(MainActivity.KEY_URL));
        data.setBtn(intent.getStringExtra(MainActivity.KEY_BTN));
        data.setBtn2(intent.getStringExtra(MainActivity.KEY_BTN2));
        data.setBrowser(intent.getBooleanExtra(MainActivity.KEY_BROWSER,true));
        data.setEnabled(intent.getBooleanExtra(MainActivity.KEY_ENABLED,true));
        data.setDescFull(intent.getStringExtra(MainActivity.KEY_DESC_FULL));

        Picasso.with(this).load(data.getLogo()).into(ivLogo);
        tvDesfull.setText(data.getDescFull());
        tvDes.setText(data.getDes());
        btnNext.setText(data.getBtn2());

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(data.getBrowser()){
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

                webView.loadUrl(data.getUrl());
            }else{
                Uri address = Uri.parse(data.getUrl());
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);
            }


            }
        });
    }
}

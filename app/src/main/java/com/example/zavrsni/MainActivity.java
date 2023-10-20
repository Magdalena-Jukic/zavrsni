package com.example.zavrsni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cijev;
    private ImageView hamburski_luk;
    private ImageView reducir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cijev=findViewById(R.id.iv_cijev);
        this.hamburski_luk=findViewById(R.id.iv_hamburski_luk);
        this.reducir=findViewById(R.id.iv_reducir);

        cijev.setOnClickListener(this);
        hamburski_luk.setOnClickListener(this);
        reducir.setOnClickListener(this);

    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.iv_cijev:
                startActivity(new Intent(getApplicationContext(), CijevActivity.class));
                break;
            case R.id.iv_hamburski_luk:
                startActivity(new Intent(getApplicationContext(), HamburskiLukActivity.class));
                break;
            case R.id.iv_reducir:
                startActivity(new Intent(getApplicationContext(), ReducirActivity.class));
                break;

        }

    }
}
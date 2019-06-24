package com.example.dormmanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dormmanagement.R;

public class BuildingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor);
        Button btnOne=findViewById(R.id.one);
        Button btnTwo=findViewById(R.id.two);
        Button btnThree=findViewById(R.id.three);
        Button btnFour=findViewById(R.id.four);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.one:
                intent=new Intent(BuildingActivity.this,BuildingoneActivity.class);
                startActivity(intent);
                break;
            case R.id.two:
                intent=new Intent(BuildingActivity.this,BuildingtwoActivity.class);
                startActivity(intent);
                break;
            case R.id.three:
                intent=new Intent(BuildingActivity.this,BuildingThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.four:
                intent=new Intent(BuildingActivity.this,BuildingfourActivity.class);
                startActivity(intent);
                break;
        }

    }
}

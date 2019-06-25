package com.example.dormmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dormmanagement.R;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Button  btnDor=findViewById(R.id.dormitory);
        Button  btnGra=findViewById(R.id.grade);
        Button  btnRep=findViewById(R.id.repair);
        Button  btnOutin=findViewById(R.id.outin);
        Button  btnBuli=findViewById(R.id.building);

        btnDor.setOnClickListener(this);
        btnGra.setOnClickListener(this);
        btnRep.setOnClickListener(this);
        btnOutin.setOnClickListener(this);
        btnBuli.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.dormitory:
                 intent=new Intent(PersonActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.grade:
                intent=new Intent(PersonActivity.this,GradeActivity.class);
                startActivity(intent);
                break;
            case R.id.repair:
                intent=new Intent(PersonActivity.this,RepairstuActivity.class);
                startActivity(intent);
                break;
            case R.id.outin:
                intent=new Intent(PersonActivity.this,OutinActivity.class);
                startActivity(intent);
                break;
            case R.id.building:
                intent=new Intent(PersonActivity.this,BuildingActivity.class);
                startActivity(intent);
                break;

        }
    }
}

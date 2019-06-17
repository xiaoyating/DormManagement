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

        Button btnDor=findViewById(R.id.dormitory);
        btnDor.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.dormitory:

                intent=new Intent(PersonActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}

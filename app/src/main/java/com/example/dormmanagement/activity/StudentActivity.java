package com.example.dormmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Student;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnInq,btnReqq,btnOut,btnPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitystudent);

        btnInq =findViewById(R.id.graded);
         btnReqq=findViewById(R.id.repaird);
         btnOut=findViewById(R.id.out);
         btnPersonal=findViewById(R.id.personal);

        btnInq.setOnClickListener(this);
        btnReqq.setOnClickListener(this);
        btnOut.setOnClickListener(this);
        btnPersonal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.graded:
                Intent intent = new Intent(StudentActivity.this,GradestuActivity.class);
            startActivity(intent);
            break;
            case R.id.repaird:
                 Intent intent1=new Intent(StudentActivity.this,RepairstuActivity.class);
                startActivity(intent1);
                break;
            case R.id.out:
                Intent intent2=new Intent(StudentActivity.this,StudentAddActivity.class);
                startActivity(intent2);
                break;
            case R.id.personal:
                Intent intent3=new Intent(StudentActivity.this,OneperActivity.class);
                startActivity(intent3);
                break;

        }
    }


}

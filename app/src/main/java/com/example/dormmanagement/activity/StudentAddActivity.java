package com.example.dormmanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Sign;
import com.example.dormmanagement.service.SignService;

public class StudentAddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPassword;
    private Button btnAdd;
    private SignService signService;
    private Button administrators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etName = findViewById(R.id.name);
        etPassword = findViewById(R.id.password);
        Button btnAdd = findViewById(R.id.student);
        Button administrators = findViewById(R.id.administrators);
        Button zhu = findViewById(R.id.register);
        zhu.setOnClickListener(this);
        //学生登录的点击事件
        btnAdd.setOnClickListener(this);
        signService= new SignService(this);
        administrators.setOnClickListener(this);


//                Room room = new Room();
//                room.setRoomName(etName.getText().toString());

//                Student student = new Student();
//                student.setname(etName.getText().toString());
//                StudentService service = new StudentService(StudentAddActivity.this);
//                service.insert(student);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent();
        switch (v.getId()) {
            case R.id.student:
                //比较用户名的密码是否正确，然后给出提示
              login1();
                break;
            case R.id.administrators:

                login();
                break;
            case R.id.register:
                intent = new Intent(StudentAddActivity.this, ZhuceActivity.class);
                startActivity(intent);
                break;






        }


//        Button btnStu = findViewById(R.id.administrators);
//        btnStu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                switch (v.getId()) {
//                    case R.id.administrators:
//                        intent = new Intent(StudentAddActivity.this, Person.class);
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });


            }

    private void login1() {
        Sign sign = new Sign();
        sign.setUsername(etName.getText().toString());
        sign.setPassword(etPassword.getText().toString());
        // 2. 判断
        boolean result = signService.login(sign);
        // 3. 跳转
        if(result) {
            Intent intent = new Intent(StudentAddActivity.this,ManagerActivity .class);
            startActivity(intent);
        } else {
            Toast.makeText(StudentAddActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
        }
    }




    private void login() {
        // 1. 获取用户名密码
        Sign sign = new Sign();
        sign.setUsername(etName.getText().toString());
        sign.setPassword(etPassword.getText().toString());
        // 2. 判断
        boolean result = signService.login(sign);
        // 3. 跳转
        if(result) {
            Intent intent = new Intent(StudentAddActivity.this,PersonActivity .class);
            startActivity(intent);
        } else {
            Toast.makeText(StudentAddActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
        }
    }


}

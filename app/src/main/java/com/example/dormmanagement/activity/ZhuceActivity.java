package com.example.dormmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Sign;
import com.example.dormmanagement.service.SignService;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText UserName,PassWord,PassWord2;
    private Button btnTurn;
    private TextView tvSuccess;

    private SignService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        UserName=findViewById(R.id.username);
        PassWord=findViewById(R.id.password);
        PassWord2=findViewById(R.id.password2);
        btnTurn=findViewById(R.id.btn_sure);
        tvSuccess=findViewById(R.id.tv_success);
        btnTurn.setOnClickListener(this);
        service= new SignService(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sure:
                register();
                break;
        }
    }


    private void register() {
        // 1. 比较两次输入的密码是否一致
        String pwd = PassWord.getText().toString();
        String pwd1 = PassWord2.getText().toString();
        String user= UserName.getText().toString();
        if(!pwd.equals("")&&pwd.equals(pwd1)&&!user.equals("")) {
            // 2. 获取输入的信息
            Sign sign = new Sign();
            sign.setUsername(UserName.getText().toString());
            sign.setPassword(PassWord.getText().toString());
            // 3. 去数据库注册
            boolean result = service.register(sign);
            // 4. 注册成功跳转到登录界面
            if (result) {
                Intent intent = new Intent(ZhuceActivity.this, StudentAddActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(ZhuceActivity.this, "注册失败", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(ZhuceActivity.this, "两次密码不一致或内容为空", Toast.LENGTH_LONG).show();
        }
    }

}

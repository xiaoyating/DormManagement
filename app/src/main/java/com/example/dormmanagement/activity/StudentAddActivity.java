package com.example.dormmanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dormmanagement.R;

public class StudentAddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPassword;
    private Button btnAdd;
    private Button administrators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etName = findViewById(R.id.name);
        etPassword = findViewById(R.id.password);
        btnAdd = findViewById(R.id.student);
        administrators = findViewById(R.id.administrators);
        //学生登录的点击事件
        btnAdd.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.student:
                Intent intent = new Intent(StudentAddActivity.this,StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.administrators:
                Intent intent1 = new Intent(StudentAddActivity.this, PersonActivity.class);
                startActivity(intent1);
                break;

        }

    }
}

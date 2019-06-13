package com.example.dormmanagement.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;
import com.example.dormmanagement.service.StudentService;

public class StudentAddActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPassword;
    private Button student;
    private Button administrators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etName = findViewById(R.id.name);
        etPassword=findViewById(R.id.password);
        Button btnAdd = findViewById(R.id.student);
        //学生登录的点击事件
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Room room = new Room();
//                room.setRoomName(etName.getText().toString());

                Student student=new Student();
                student.setname(etName.getText().toString());
                StudentService service = new StudentService(StudentAddActivity.this);
                service.insert(student);


            }
        });
    }
}

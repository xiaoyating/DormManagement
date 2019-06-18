package com.example.dormmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.service.RoomService;
import com.example.dormmanagement.service.RoomServiceImpl;

import java.util.Arrays;
import java.util.List;

public class RoomActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave,btnCancel;
    private EditText etRoomNumber,etStayNumber;
    private EditText etResidentNumber,etMonery;
    private Spinner spRoomSex;

    private List<String> sexes;
    private Room room;
    private RoomService roomService;
    private String flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_tianjia);

        roomService=new RoomServiceImpl(this);

        initView();
        initData();
    }



    private void initView() {
        etRoomNumber=findViewById(R.id.et_roomnumber);
        etStayNumber=findViewById(R.id.et_staynumber);
        etResidentNumber=findViewById(R.id.et_residentnumber);
        etMonery=findViewById(R.id.et_monery);

        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

//        spRoomSex.setAdapter(new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_dropdown_item,
//                sexes
//        ));
    }
    private void initData() {
        Intent intent=getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            room = (Room) bundle.getSerializable("room");
            if(room != null) {
                etRoomNumber.setText(room.getRoomnumber());
                etRoomNumber.setEnabled(false);
                etStayNumber.setText(String.valueOf(room.getStaynumber()));
                etResidentNumber.setText(String.valueOf(room.getResidentnumber()));
                etMonery.setText(String.valueOf(room.getMonery()));
                //spRoomSex.setSelection(sexes.indexOf(room.getSex()), true);
    }
}
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                updateRoom();
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    private void updateRoom() {
        if (room==null){
            room=new Room();
        }
        room.setRoomnumber(etRoomNumber.getText().toString());
        room.setStaynumber(Integer.valueOf(etStayNumber.getText().toString()));
        room.setResidentnumber(Integer.parseInt(etResidentNumber.getText().toString()));
        room.setMonery(Integer.parseInt(etMonery.getText().toString()));

        if ("修改".equals(flag)){
            roomService.modifyRealNumber(room);
        }else if ("添加".equals(flag)){
            roomService.insert(room);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("room", room);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

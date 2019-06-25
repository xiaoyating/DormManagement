package com.example.dormmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Repair;
import com.example.dormmanagement.service.RepairService;
import com.example.dormmanagement.service.RepairServiceImpl;

public class RepairActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText rtName,rtNamenumber;
    public EditText  rtProblem,rtPonenumber;
    private Button btnPreser1,btnCancel;
    private Repair repair;
    private RepairService repairService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);

        repairService =new RepairServiceImpl(this);
        initView();
        initData();
    }

    private void initView() {

        rtName=findViewById(R.id.rt_name);
        rtNamenumber=findViewById(R.id.rt_namenumber);
        rtProblem=findViewById(R.id.rt_problem);
        rtPonenumber=findViewById(R.id.rt_ponenumber);

        btnPreser1=findViewById(R.id.btn_preser1);
        btnCancel = findViewById(R.id.btn_cancel);
        btnPreser1.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    private void initData() {
        Intent intent=getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            repair = (Repair) bundle.getSerializable("repair");
            if (repair != null) {
                rtName.setText(repair.getRt_name());
                rtName.setEnabled(false);
                rtNamenumber.setText(String.valueOf(repair.getRt_namenumber()));
                rtProblem.setText(String.valueOf(repair.getRt_problem()));
                rtPonenumber.setText(String.valueOf(repair.getRt_ponenumber()));
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_preser1:
                updateRoom();
                break;
            case R.id.btn_cancel:
                finish();
        }
    }

    private void updateRoom() {
        if (repair==null){
            repair=new Repair();
        }
        repair.setRt_namei(String.valueOf(rtName.getText().toString()));
        repair.setRt_namenumber(Integer.parseInt(rtNamenumber.getText().toString()));
        repair.setRt_problem(String.valueOf(rtProblem.getText().toString()));
        repair.setRt_ponenumber(Integer.parseInt(rtPonenumber.getText().toString()));

        if ("修改".equals(flag)){
            repairService.modifyRepair(repair);
        }else if ("添加".equals(flag)){
            repairService.insert(repair);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("repair", repair);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

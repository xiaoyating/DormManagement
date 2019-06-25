package com.example.dormmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dormmanagement.R;
import com.example.dormmanagement.adapter.RepairAdapter;
import com.example.dormmanagement.model.Repair;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.service.RepairService;
import com.example.dormmanagement.service.RepairServiceImpl;
import com.example.dormmanagement.service.RoomService;

import java.util.ArrayList;
import java.util.List;

public class RepairstuActivity extends AppCompatActivity {
    private static final int ADD_REQUEST=100;
    private static final int MODIFY_REQUEST=101;

    private ListView repairList;
    private RepairAdapter repairAdapter;

    private RepairService repairService;
    private List<Repair> repairs;
    private int selectedPos;
    private Repair selectedRepair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repair_query);

        initData();
        repairList =findViewById(R.id.list_repair);
        repairAdapter=new RepairAdapter(repairs);
        repairList.setAdapter(repairAdapter);


        // 设置ListView的点击和长按的事件监听
        repairList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 将数据传递到RoomActivity界面显示
                selectedPos = position;
                selectedRepair= (Repair) parent.getItemAtPosition(position);

                Intent intent = new Intent(RepairstuActivity.this,RepairActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("repair", selectedRepair);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        repairList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // 弹出警告对话框，确认是否删除
                selectedRepair = (Repair) parent.getItemAtPosition(position);

                new AlertDialog.Builder(RepairstuActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                repairService.delete(selectedRepair.rt_name());
                                // 移除rooms中的数据，并刷新adapter
                                repairs.remove(position);
                                repairAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }

    private void initData() {
        // 从SQLite数据库获取宿舍列表
        repairService = new RepairServiceImpl(this);
        repairs = repairService.getRepair();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if(repairs == null) {
            repairs = new ArrayList<>();
        }
    }

    // 接收RoomActivity的返回的添加或修改后的room对象，更新rooms，刷新列表
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            // 更新rooms列表
            selectedRepair = (Repair) bundle.get("repair");
            if (requestCode == MODIFY_REQUEST) {
                repairs.set(selectedPos, selectedRepair);
            } else if (requestCode == ADD_REQUEST) {
                repairs.add(selectedRepair);
            }
            // 刷新ListView
            repairAdapter.notifyDataSetChanged();
        }
    }

    // 创建添加功能的选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 动态加载菜单
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    // 处理选项菜单的添加功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                // 跳转到RoomActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(RepairstuActivity.this, RepairActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

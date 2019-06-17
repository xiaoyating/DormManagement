package com.example.dormmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dormmanagement.R;
import com.example.dormmanagement.adapter.RoomAdapter;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.service.RoomService;
import com.example.dormmanagement.service.RoomServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_REQUEST=100;
    private static final int MODIFY_REQUEST=101;

    private ListView roomList;
    private RoomAdapter roomAdapter;

    private RoomService roomService;
    private List<Room> rooms;
    private int selectedPos;
    private Room selectedRoom;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay);

        // 从SQLite数据库获取数据
        initData();

        // 初始化ListView
        roomList = findViewById(R.id.list_room);
        roomAdapter = new RoomAdapter(rooms);
        roomList.setAdapter(roomAdapter);

        // 设置ListView的点击和长按的事件监听
        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 将数据传递到RoomActivity界面显示
                selectedPos = position;
                selectedRoom = (Room) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this,RoomActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("room", selectedRoom);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        roomList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // 弹出警告对话框，确认是否删除
                selectedRoom = (Room) parent.getItemAtPosition(position);

                new AlertDialog.Builder(MainActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                roomService.delete(selectedRoom.getRoomnumber());
                                // 移除rooms中的数据，并刷新adapter
                                rooms.remove(position);
                                roomAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }

    private void initData() {
        roomService = new RoomServiceImpl(this);
        rooms = roomService.getAllrooms();

        if (rooms==null){
            rooms=new ArrayList<>();
        }

    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data!=null){
            Bundle bundle=data.getExtras();
            if (bundle==null){
                return;
            }
            selectedRoom= (Room) bundle.get("room");
            if (resultCode == MODIFY_REQUEST) {
                rooms.set(selectedPos, selectedRoom);
            } else if (resultCode == ADD_REQUEST) {
                rooms.add(selectedRoom);
            }
            roomAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                // 跳转到RoomActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void savedInstanceState(int activity_stay) {

    }
}

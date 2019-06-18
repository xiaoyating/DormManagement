package com.example.dormmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Room;

import java.util.List;

public class RoomAdapter extends BaseAdapter {
    private List<Room> rooms;

    public RoomAdapter(List<Room> rooms){this.rooms=rooms;}
    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_stay_main, parent, false);
            holder=new ViewHolder();

            holder.tvNumber=convertView.findViewById(R.id.roomnumber);
            holder.tvStay = convertView.findViewById(R.id.staynumber);
            holder.tvResident = convertView.findViewById(R.id.residentnumber);
            holder.tvMonery = convertView.findViewById(R.id.monery);

            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Room room=rooms.get(position);
        holder.tvNumber.setText(room.getRoomnumber());
        holder.tvStay.setText(String.valueOf(room.getStaynumber()));
        holder.tvResident.setText(String.valueOf(room.getResidentnumber()));
        holder.tvMonery.setText(String.valueOf(room.getMonery()));

        return convertView;
    }
}
 class ViewHolder {
    TextView tvNumber;
    TextView tvStay;
    TextView tvResident;
    TextView tvMonery;

}

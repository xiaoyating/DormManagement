package com.example.dormmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dormmanagement.R;
import com.example.dormmanagement.model.Repair;

import java.util.List;

public class RepairAdapter extends BaseAdapter {
    private List<Repair> repairs;

    public RepairAdapter(List<Repair> repairs){this.repairs=repairs;}
    @Override
    public int getCount() {
        return repairs.size();
    }

    @Override
    public Object getItem(int position) {
        return repairs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder hol;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repair_main, parent, false);
            hol = new ViewHolder();

            hol.tvName=convertView.findViewById(R.id.name1);
            hol.tvNumber=convertView.findViewById(R.id.number1);
            hol.tvProblem=convertView.findViewById(R.id.problem1);
            hol.tvPonenumber=convertView.findViewById(R.id.poneumber1);

            convertView.setTag(hol);
        }else {
            hol= (ViewHolder) convertView.getTag();
        }
        Repair repair=repairs.get(position);
        hol.tvName.setText(repair.getRt_name());
        hol.tvNumber.setText(String.valueOf(repair.getRt_namenumber()));
        hol.tvProblem.setText(String.valueOf(repair.getRt_problem()));
        hol.tvPonenumber.setText(String.valueOf(repair.getRt_ponenumber()));

        return convertView;
    }
    class ViewHolder {
        TextView tvName;
        TextView tvNumber;
        TextView tvProblem;
        TextView tvPonenumber;

    }
}

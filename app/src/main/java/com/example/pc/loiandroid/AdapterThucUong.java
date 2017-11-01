package com.example.pc.loiandroid;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class AdapterThucUong extends BaseAdapter{
    Context context;
    ArrayList<ThucUong> list;
    int resourse;

    public AdapterThucUong(Context context,int resourse, ArrayList<ThucUong> list) {
        this.context = context;
        this.list = list;
        this.resourse = resourse;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(this.resourse,null);

        ImageView imgHinh = row.findViewById(R.id.imgHinh);
        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtNote = row.findViewById(R.id.txtNote);

        ThucUong thucUong = list.get(position);
        txtName.setText(thucUong.ten + "");
        txtNote.setText(thucUong.note);
        Bitmap bmHinh = BitmapFactory.decodeByteArray(thucUong.anh, 0, thucUong.anh.length);
        imgHinh.setImageBitmap(bmHinh);
        return null;
    }
}

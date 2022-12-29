package com.example.carepet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.carepet.Data.Data;
import com.example.carepet.databinding.ListviewItemBinding;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {
    ArrayList<Data> data;
    Context context;
    public ListviewAdapter(Context context, ArrayList<Data> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        final Data info = data.get(i);
        final ListviewItemBinding binding = ListviewItemBinding.inflate(LayoutInflater.from(context));

        binding.major.setText(info.getMajor()+"전문");
        binding.name.setText(" "+info.getName());
        binding.hospital.setText(info.getHospital());

        binding.call.setOnClickListener(l -> context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:"+info.getCall()))));

        return binding.getRoot();
    }
}

package com.sang.beshoes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sang.beshoes.databinding.FragmentQuanlyLoaigiayBinding;
import com.sang.beshoes.databinding.ItemLoaigiayBinding;
import com.sang.beshoes.mode.loaiGiayMode;

import java.util.ArrayList;

public class loaiGiayAdapter extends RecyclerView.Adapter<loaiGiayAdapter.ViewHolder> {
    Context context;
    ArrayList<loaiGiayMode> list;

    public loaiGiayAdapter(Context context, ArrayList<loaiGiayMode> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public loaiGiayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLoaigiayBinding binding = ItemLoaigiayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull loaiGiayAdapter.ViewHolder holder, int position) {
        loaiGiayMode mode = list.get(position);
        holder.binding.tvGiay.setText(mode.getTenLoai());
        Integer id = mode.getId();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLoaigiayBinding binding;
        public ViewHolder(@NonNull ItemLoaigiayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

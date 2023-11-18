package com.sang.beshoes.fagment.loai_giay;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sang.beshoes.R;
import com.sang.beshoes.adapter.loaiGiayAdapter;
import com.sang.beshoes.dao.loaiGiayDAO;
import com.sang.beshoes.databinding.FragmentQuanlyLoaigiayBinding;
import com.sang.beshoes.mode.loaiGiayMode;

import java.util.ArrayList;


public class quanly_loaigiay extends Fragment {
    ArrayList<loaiGiayMode> listLoaiSach;
    loaiGiayAdapter adapter;
    FragmentQuanlyLoaigiayBinding binding;
    loaiGiayDAO dao;
    Integer trangThai = -1;
    loaiGiayMode mode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentQuanlyLoaigiayBinding.inflate(inflater,container,false);
        listLoaiSach =  new ArrayList<>();
        dao =  new loaiGiayDAO(getContext());
        adapter =  new loaiGiayAdapter(getContext(),listLoaiSach);
        loadData();
        lisener();
        Log.e(TAG , "listLoaiSach"+listLoaiSach.size());
        return binding.getRoot();
    }
    public void lisener(){
        binding.btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new them_loaigiay()).addToBackStack(null).commit();
            }
        });
    }
    public void loadData(){
             listLoaiSach.addAll(dao.getListloaigiay());
             adapter =  new loaiGiayAdapter(getContext(),listLoaiSach);
             adapter.notifyDataSetChanged();
             binding.rcvLoaiGiay.setAdapter(adapter);
    }



}
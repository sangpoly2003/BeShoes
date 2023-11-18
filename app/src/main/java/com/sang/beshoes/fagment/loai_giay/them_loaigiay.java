package com.sang.beshoes.fagment.loai_giay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sang.beshoes.R;
import com.sang.beshoes.dao.loaiGiayDAO;
import com.sang.beshoes.databinding.FragmentQuanlyLoaigiayBinding;
import com.sang.beshoes.databinding.FragmentThemLoaigiayBinding;
import com.sang.beshoes.mode.loaiGiayMode;

import java.util.ArrayList;


public class them_loaigiay extends Fragment {
       FragmentThemLoaigiayBinding binding;
       Integer trangThai= -1 ;
       loaiGiayDAO dao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThemLoaigiayBinding.inflate(inflater,container,false);
         dao = new loaiGiayDAO(getContext());
        lisener();
        return binding.getRoot();
    }
    public void lisener(){
        binding.btnHoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
     binding.btnBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             getActivity().getSupportFragmentManager().popBackStack();
             Toast.makeText(getContext(), "sáng", Toast.LENGTH_SHORT).show();
         }
     });
    }
    public void save(){
        String tenLoai =  binding.edTenLoaiSach.getText().toString();
        if(tenLoai.isEmpty()){
            Toast.makeText(getContext(), "Vui lòng không để trống tên loại giày", Toast.LENGTH_SHORT).show();
        }else{
            loaiGiayMode Mode = new loaiGiayMode();
            Mode.setTenLoai(binding.edTenLoaiSach.getText().toString().trim());

            if(binding.swTrangThai.isChecked()){
                trangThai = 1;
            }else{
                trangThai = 0 ;
            }
            Mode.setTrangThai(trangThai);
            dao.addLoaiSach(Mode);
            getActivity().getSupportFragmentManager().popBackStack();
            Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();

        }
    }
}
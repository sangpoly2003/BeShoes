package com.sang.beshoes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.sang.beshoes.databinding.ActivityMainBinding;
import com.sang.beshoes.fagment.cong_viec.quanly_congviec;
import com.sang.beshoes.fagment.giay.quanly_giay;
import com.sang.beshoes.fagment.hoa_don.quanly_hoadon;
import com.sang.beshoes.fagment.khach_hang.quanly_khachhang;
import com.sang.beshoes.fagment.loai_giay.quanly_loaigiay;
import com.sang.beshoes.fagment.nhan_vien.quanly_nhanvien;
import com.sang.beshoes.fagment.thong_ke.thongke_doanhthu;
import com.sang.beshoes.fagment.top10.top10;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setNavi();
    }
    public void setNavi(){
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle =  new ActionBarDrawerToggle(MainActivity.this , binding.drawerLy , binding.toolbar,0,0);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        binding.drawerLy.addDrawerListener(drawerToggle);
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Fragment();
                if (item.getItemId() == R.id.giay) {
                    setTitle("Quản lý giày");
                    fragment = new quanly_giay();
                }else if (item.getItemId() == R.id.loai_giay){
                    setTitle("Quản lý loại giày");
                    fragment = new quanly_loaigiay();
                }else if (item.getItemId() == R.id.hoa_don){
                    setTitle("Quản lý hóa đơn");
                    fragment = new quanly_hoadon();
                }else if (item.getItemId() == R.id.nhan_vien){
                    setTitle("Quản lý nhân viên");
                    fragment = new quanly_nhanvien();
                }else if (item.getItemId() == R.id.khach_hang){
                    setTitle("Quản lý khách hàng ");
                    fragment = new quanly_khachhang();
                }else if (item.getItemId() == R.id.cv){
                    setTitle("Quản lý công việc");
                    fragment = new quanly_congviec();
                }else if (item.getItemId() == R.id.top10){
                    setTitle("Top 10");
                    fragment = new top10();
                }else if (item.getItemId() == R.id.thong_ke){
                    setTitle("Thông kê doanh số");
                    fragment = new thongke_doanhthu();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                binding.drawerLy.close();
                return true;
            }
        });


    }




}
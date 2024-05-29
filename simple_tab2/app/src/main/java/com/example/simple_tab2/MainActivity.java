package com.example.simple_tab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.simple_tab2.fragment.FindFragment;
import com.example.simple_tab2.fragment.HomeFragment;
import com.example.simple_tab2.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llHome, llFind, llMine;
    private ImageView ivHome, ivFind, ivMine;
    private TextView tvHome, tvFind, tvMine;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.fcv_fragment, homeFragment).commit();
        setBottomItemSelected(R.id.ll_home);

        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    private void initView() {
        llHome = findViewById(R.id.ll_home);
        llMine = findViewById(R.id.ll_mine);
        llFind = findViewById(R.id.ll_find);
        ivHome = findViewById(R.id.iv_home);
        ivFind = findViewById(R.id.iv_find);
        ivMine = findViewById(R.id.iv_mine);
        tvHome = findViewById(R.id.tv_home);
        tvFind = findViewById(R.id.tv_find);
        tvMine = findViewById(R.id.tv_mine);
    }

    private void resetBottomState() {
        ivHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.gray));
        ivFind.setSelected(false);
        tvFind.setTextColor(getResources().getColor(R.color.gray));
        ivMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.gray));
    }

    private void setBottomItemSelected(int id) {
        switch (id) {
            case R.id.ll_home:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.ll_find:
                ivFind.setSelected(true);
                tvFind.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.ll_mine:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.green));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        resetBottomState();
        setBottomItemSelected(id);
        switch (id) {
            case R.id.ll_home:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fcv_fragment, homeFragment).commit();

                break;
            case R.id.ll_find:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FindFragment findFragment = new FindFragment();
                fragmentTransaction.replace(R.id.fcv_fragment, findFragment).commit();


                break;
            case R.id.ll_mine:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MineFragment mineFragment = new MineFragment();
                fragmentTransaction.replace(R.id.fcv_fragment, mineFragment).commit();


                break;
            default:
                break;
        }
    }
}
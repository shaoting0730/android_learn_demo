package com.example.simple_tab3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.simple_tab3.adapter.MyFragmentAdapter;
import com.example.simple_tab3.fragment.FindFragment;
import com.example.simple_tab3.fragment.HomeFragment;
import com.example.simple_tab3.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private LinearLayout llHome, llFind, llMine;
    private ImageView ivHome, ivFind, ivMine;
    private TextView tvHome, tvFind, tvMine;

    private MyFragmentAdapter myFragmentAdapter;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(myFragmentAdapter);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                 onViewPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        onViewPagerSelected(0);



        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);

    }

    private void onViewPagerSelected(int position) {
        resetBottomState();
        switch (position){
            case 0:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.green));
                break;
            case 1:
                ivFind.setSelected(true);
                tvFind.setTextColor(getResources().getColor(R.color.green));
                break;
            case 2:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.green));
                break;
            default:
                break;
        }
    }

    private void resetBottomState() {
        ivHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.gray));
        ivFind.setSelected(false);
        tvFind.setTextColor(getResources().getColor(R.color.gray));
        ivMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.gray));
    }

    private void initData() {
        mFragmentList = new ArrayList<>();

        HomeFragment homeFragment = new HomeFragment();
        FindFragment findFragment = new FindFragment();
        MineFragment mineFragment = new MineFragment();

        mFragmentList.add(homeFragment);
        mFragmentList.add(findFragment);
        mFragmentList.add(mineFragment);
    }



    private void initView() {
        mViewPager = findViewById(R.id.vp);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.ll_home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_find:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_mine:
                mViewPager.setCurrentItem(2);
                break;
            default:
                break;
        }

    }
}
package com.example.simple_tab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.simple_tab4.adapter.MyFragmentAdapter;
import com.example.simple_tab4.fragment.FindFragment;
import com.example.simple_tab4.fragment.HomeFragment;
import com.example.simple_tab4.fragment.MineFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private MyFragmentAdapter mMyFragmentAdapter;

    private List<Fragment> mFragmentsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.vp);
        mBottomNavigationView = findViewById(R.id.bottom_menu);
        
        initData();

        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),
                mFragmentsList);
        mViewPager.setAdapter(mMyFragmentAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_find:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_mine:
                        mViewPager.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        final BadgeDrawable badge = mBottomNavigationView.getOrCreateBadge(R.id.menu_find);
        badge.setNumber(100);
        badge.setMaxNumber(3);



    }

    private void changeSelected(int position) {
        switch (position) {
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.menu_find);
                mBottomNavigationView.removeBadge(R.id.menu_find);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.menu_mine);
                break;
        }
    }

    private void initData() {
        mFragmentsList = new ArrayList<>();

        HomeFragment homeFragment = new HomeFragment();
        FindFragment findFragment = new FindFragment();
        MineFragment mineFragment = new MineFragment();

        mFragmentsList.add(homeFragment);
        mFragmentsList.add(findFragment);
        mFragmentsList.add(mineFragment);
    }

}
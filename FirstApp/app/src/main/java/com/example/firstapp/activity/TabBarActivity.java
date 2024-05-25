package com.example.firstapp.activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.firstapp.R;
import com.example.firstapp.fragment.home.HomeFragment;
import com.example.firstapp.fragment.mine.MineFragment;

public class TabBarActivity extends BaseActivity implements View.OnClickListener {
    TextView tabHomeImg;
    TextView tabHomeText;
    TextView tabMineImg;
    TextView tabMineText;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    HomeFragment homeFragment;
    MineFragment mineFragment;


    @Override
    protected void initData() {
        tabHomeImg.setBackgroundResource(R.mipmap.home_selected);
        tabHomeText.setTextColor(Color.rgb(0, 0, 255));
        tabMineText.setTextColor(Color.rgb(0, 0, 0));

        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.mine).setOnClickListener(this);

        homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_tabbar;
    }

    @Override
    protected void initView() {
        tabHomeImg = findViewById(R.id.home_img);
        tabHomeText = findViewById(R.id.home_text);
        tabMineImg = findViewById(R.id.mine_img);
        tabMineText = findViewById(R.id.mine_text);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (id) {
            case R.id.home:

                if(mineFragment != null){
                    fragmentTransaction.hide(mineFragment);
                }
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                changeSelectTabAction(R.mipmap.home_selected, tabHomeImg, tabHomeText);
                break;
            case R.id.mine:

                if(homeFragment != null){
                    fragmentTransaction.hide(homeFragment);
                }
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mineFragment);
                } else {
                    fragmentTransaction.show(mineFragment);
                }
                changeSelectTabAction(R.mipmap.mine_selected, tabMineImg, tabMineText);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void changeSelectTabAction(int change, TextView imgView,
                                       TextView textView) {
        tabHomeImg.setBackgroundResource(R.mipmap.home_unselect);
        tabMineImg.setBackgroundResource(R.mipmap.mine_unselect);

        tabHomeText.setTextColor(Color.rgb(0, 0, 0));
        tabMineText.setTextColor(Color.rgb(0, 0, 0));

        imgView.setBackgroundResource(change);
        textView.setTextColor(Color.rgb(0, 0, 255));
    }
}
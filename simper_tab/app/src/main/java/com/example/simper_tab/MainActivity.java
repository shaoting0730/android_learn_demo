package com.example.simper_tab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.simper_tab.fragment.HomeFragment;
import com.example.simper_tab.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tabHomeImg;
    TextView tabHomeText;
    TextView tabMineImg;
    TextView tabMineText;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    HomeFragment homeFragment;
    MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabBar();
    }

    private void initTabBar() {
        tabHomeImg = findViewById(R.id.home_img);
        tabHomeText = findViewById(R.id.home_text);
        tabMineImg = findViewById(R.id.mine_img);
        tabMineText = findViewById(R.id.mine_text);
        tabHomeImg.setBackgroundResource(R.drawable.tabbar_home_select);
        tabHomeText.setTextColor(Color.rgb(255, 0, 0));


        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.mine).setOnClickListener(this);


        homeFragment = new HomeFragment();

        fragmentManager = getFragmentManager();
        fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, homeFragment);
        fragmentTransaction.commit();


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
                changeSelectTabAction(R.drawable.tabbar_home_select, tabHomeImg, tabHomeText);
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
                changeSelectTabAction(R.drawable.tabbar_mine_select, tabMineImg, tabMineText);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void changeSelectTabAction(int change, TextView imgView,
                                       TextView textView) {
        tabMineImg.setBackgroundResource(R.drawable.tabbar_mine);
        tabHomeImg.setBackgroundResource(R.drawable.tabbar_home);
        tabHomeText.setTextColor(Color.rgb(0, 0, 0));
        tabMineText.setTextColor(Color.rgb(0, 0, 0));

        imgView.setBackgroundResource(change);
        textView.setTextColor(Color.rgb(255, 0, 0));
    }
}
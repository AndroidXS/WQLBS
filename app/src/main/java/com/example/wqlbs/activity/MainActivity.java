package com.example.wqlbs.activity;

import androidx.appcompat.app.AppCompatActivity;
import model.LogUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.example.wqlbs.R;
import com.example.wqlbs.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    void initView() {

    }

    @Override
    ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
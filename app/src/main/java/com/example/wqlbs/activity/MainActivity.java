package com.example.wqlbs.activity;

import com.example.wqlbs.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    void initView() {
        binding.text.setText(" ");
    }

    @Override
    ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
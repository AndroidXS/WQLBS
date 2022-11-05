package com.example.wqlbs.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

/**
 * ************************************
 * 项目名称: WQLBS
 *
 * @Author xushu
 * 创建时间: 2022/11/5 13:19
 * 用途：基础Activity
 * 修改记录：
 *************************************/
abstract class BaseActivity<V extends ViewBinding> extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewBinding().getRoot());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    abstract void initView();
    abstract V getViewBinding();
}

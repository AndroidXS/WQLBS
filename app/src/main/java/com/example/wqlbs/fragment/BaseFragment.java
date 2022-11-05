package com.example.wqlbs.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

/**
 * ************************************
 * 项目名称: WQLBS
 *
 * @Author xushu
 * 创建时间: 2022/11/5 13:40
 * 用途：基础Fragment
 * 修改记录：
 *************************************/
public abstract class BaseFragment <V extends ViewBinding> extends Fragment {
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return getViewBinding().getRoot();
    }

    abstract void initView();
    abstract V getViewBinding();
}

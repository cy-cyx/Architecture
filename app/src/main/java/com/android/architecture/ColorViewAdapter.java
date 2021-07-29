package com.android.architecture;

import androidx.databinding.BindingAdapter;

/**
 * create by caiyx in 2021/7/29
 *
 * BindingAdapter用于代码赋值的
 */
public class ColorViewAdapter {

    @BindingAdapter("bgColor")
    public static void setBgColor(ColorView view, int c) {
        view.setColor(c);
        view.invalidate();
    }
}

package com.android.architecture;

import android.graphics.Color;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

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

    @InverseBindingAdapter(attribute = "bgColor")  // event不写默认{attribute}AttrChanged
    public static int getBgColor(ColorView view){
        int color = view.getColor();
        if (color == Color.parseColor("#ff00ff")) {
            return Color.parseColor("#ff0000");
        } else {
            return Color.parseColor("#ff00ff");
        }
    }

    @BindingAdapter("bgColorAttrChanged")
    public static void setColorAttrChanged(ColorView view, final InverseBindingListener listen){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.onChange();
            }
        });
    }
}

package com.android.architecture

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * create by caiyx in 2021/5/18
 *
 * 自定View，对应的ViewAdapter[ColorViewAdapter]
 */
class ColorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    var color = Color.BLUE

    init {
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorView, 0, 0)
        for (i in 0 until ta.indexCount) {
            when (val attr: Int = ta.getIndex(i)) {
                R.styleable.ColorView_bgColor -> {
                    color = ta.getColor(attr, Color.WHITE)
                }
            }
        }
        ta.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(100, 100)
    }

//   一种遗弃的写法
//    companion object {
//        @BindingAdapter("app:bgColor")
//        fun setBgColor(view: ColorView, c: Int) {
//            view.color = c
//            view.invalidate()
//        }
//    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = color
        canvas?.drawRect(0f, 0f, right.toFloat(), height.toFloat(), paint)
    }
}
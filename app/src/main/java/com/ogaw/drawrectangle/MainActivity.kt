package com.ogaw.drawrectangle

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textArea = findViewById<LinearLayout>(R.id.dynamicArea)
        val rectangleList = mutableListOf<View>()

        findViewById<Button>(R.id.button_add).apply {
            this.setOnClickListener{
                val view = View(context)
                // 成功例 1
//                view.layoutParams = ViewGroup.LayoutParams(100, 100)
//                view.setBackgroundColor(Color.BLUE)

                // マージンありで四角を作成する方法
//                var tempLayoutParams = ViewGroup.LayoutParams()
//                tempLayoutParams.width = 100
//                tempLayoutParams.height = 100
//
//                view.layoutParams = tempLayoutParams

                val marginParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                ).apply {
                    this.width = 100
                    this.height = 100
                    this.topMargin = 100
                    this.leftMargin = 100
                }

                view.layoutParams = marginParams
                view.setBackgroundColor(Color.BLUE)

                rectangleList.add(view)
                textArea.addView(view)
            }
        }

        findViewById<Button>(R.id.button_remove).apply {
            this.setOnClickListener{
                Log.d(TAG, rectangleList.toString())

                val lastIndex = rectangleList.size
                if (lastIndex > 0) {
                    Log.d(TAG, lastIndex.toString())
                    textArea.removeViewAt(lastIndex - 1)
                    rectangleList.removeAt(lastIndex - 1)
                }
            }
        }
    }
}
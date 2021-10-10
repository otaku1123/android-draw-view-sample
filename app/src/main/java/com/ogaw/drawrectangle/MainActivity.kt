package com.ogaw.drawrectangle

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textArea = findViewById<FrameLayout>(R.id.dynamicArea)
        val rectangleList = mutableListOf<View>()

        findViewById<Button>(R.id.button_add).apply {
            this.setOnClickListener{
                val view = View(context)

                val marginParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                ).apply {
                    this.width = (rectangleList.size + 1) * 10
                    this.height = (rectangleList.size + 1) * 10
                    this.topMargin = (rectangleList.size + 1) * 100
                    this.leftMargin = (rectangleList.size + 1) * 100
                }

                val border = GradientDrawable()
//                border.setColor(Color.WHITE)
                border.setStroke(2, Color.BLUE)
                view.background = border

                view.layoutParams = marginParams

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
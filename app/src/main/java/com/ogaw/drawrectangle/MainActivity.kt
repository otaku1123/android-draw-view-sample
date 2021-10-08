package com.ogaw.drawrectangle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
                val textView = TextView(context)
                textView.text = "hello world${rectangleList.size}"
                textView.textSize = 15f

                rectangleList.add(textView)
                textArea.addView(textView)
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
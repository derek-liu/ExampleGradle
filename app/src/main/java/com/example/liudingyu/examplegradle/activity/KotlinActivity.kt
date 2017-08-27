package com.example.liudingyu.examplegradle.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.liudingyu.examplegradle.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val txtView = findViewById(R.id.txt) as TextView
        val goBtn = findViewById(R.id.go) as Button
        goBtn.setOnClickListener { view: View ->
            when (view.id) {
                R.id.go -> {
                    txtView.setText("Click Derek")
                    Toast.makeText(this@KotlinActivity, "Toast", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}

package com.example.basicstopwatch

import android.graphics.Color.green
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var stopwatchText: TextView
    private lateinit var stopButton: Button
    private lateinit var startButton: Button
    private lateinit var resetButton: Button


    private lateinit var handler: Handler
private lateinit var runnable: Runnable

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    stopButton = findViewById(R.id.stopButton)
    startButton = findViewById(R.id.startButton)
    resetButton = findViewById(R.id.resetButton)
        stopButton.isEnabled = false
resetButton.isEnabled = false
        stopwatchText = findViewById(R.id.stopWatch)
        handler = Handler()
        runnable = Runnable {
            stopwatchText.text = (stopwatchText.text.toString().toInt() + 1).toString()
            handler.postDelayed(runnable, 1000)

        }
        startButton.setOnClickListener {
            handler.post(runnable)
            stopButton.isEnabled = true
            resetButton.isEnabled = true
            startButton.isEnabled = false
            Toast.makeText(this, "Stopwatch has been started", Toast.LENGTH_SHORT).show()



        stopButton.setOnClickListener {
            handler.removeCallbacks(runnable)
            startButton.isEnabled = true
            resetButton.isEnabled = false
            stopButton.isEnabled = false
            Toast.makeText(this, "Stopwatch has been stoped", Toast.LENGTH_SHORT).show()

        }
        resetButton.setOnClickListener {
            handler.removeCallbacks(runnable)
            stopwatchText.text = "0"
            startButton.isEnabled = true
            stopButton.isEnabled = false
            resetButton.isEnabled = false
            Toast.makeText(this, "Stopwatch has been reseted", Toast.LENGTH_SHORT).show()

        }


    }
}}
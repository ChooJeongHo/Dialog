package com.example.dialog

import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var et :EditText
    lateinit var saveBt :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et = findViewById(R.id.et)
        saveBt = findViewById(R.id.saveBt)

        saveBt.setOnClickListener {
            var str = et.text.toString()

            var pref : SharedPreferences = getSharedPreferences("wordPref", MODE_PRIVATE)
            var edit : SharedPreferences.Editor = pref.edit()
            edit.putString("content",str)
            edit.putString("name","개똥이")
            edit.putInt("age",1000)
            edit.commit()
        }

        var btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            var str  = ""
            var pref : SharedPreferences = getSharedPreferences("wordPref", MODE_PRIVATE)
            str = pref.getString("content","nothing")!!

            var ab : AlertDialog.Builder = AlertDialog.Builder(this)
            ab.setIcon(R.mipmap.ic_launcher)
            ab.setTitle("제목이 들어갑니다")
            ab.setMessage("내용이 들어갑니다")
            ab.setNegativeButton("취소") { dialog , which->

            }
            ab.setPositiveButton("확인", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }
            })
            ab.setCancelable(false)
            ab.show()


        }
    }
}
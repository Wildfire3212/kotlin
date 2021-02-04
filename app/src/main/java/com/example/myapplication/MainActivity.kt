package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
private const val REQUEST_CODE = 1
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camara.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also { startActivityForResult(takePictureIntent, REQUEST_CODE)
                }
            }
        }
        }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
                val imagen = data?.extras?.get("data") as Bitmap
                img.setImageBitmap(imagen)
            }else {
                super.onActivityResult(requestCode, resultCode, data)
                }
            }
        }

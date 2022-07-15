package com.example.easyscan

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.github.drjacky.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton


class MainActivity : AppCompatActivity() {

private lateinit var logo: ImageView
private lateinit var fab: ExtendedFloatingActionButton
private lateinit var fab2: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       logo = findViewById(R.id.logo)
        fab = findViewById(R.id.fab)
        fab2 = findViewById(R.id.fab2)

        fab.setOnClickListener(View.OnClickListener {

                ImagePicker.with(this)
                    //...

                    .cameraOnly()
                    .crop()
                    .createIntent()

        })
        fab2.setOnClickListener(View.OnClickListener {
            ImagePicker.with(this)
                //...

                .galleryOnly()
                .crop()
                .createIntent()

        }
        )
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val uri = it.data?.data!!
            // Use the uri to load the image
        }
    }

}
package com.example.homework18

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.homework18.MainActivity2.Companion.startMainActivity2
import com.example.homework18.MainActivity2.Companion.startMainActivity2AndDownloadTitle

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    // выпадающее меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // функционал выпадающего меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.third_item_close_app -> finishAffinity()
            R.id.fourth_item_smth_happends -> finishAffinity()
            R.id.first_item_open_second_activity -> startMainActivity2(this, getString(R.string.bold), getString(R.string.italic))
            R.id.second_item_open_second_activity_and_show_text -> startMainActivity2AndDownloadTitle(this, getString(R.string.click))
        }
        return super.onOptionsItemSelected(item)
    }
}
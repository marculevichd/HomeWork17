package com.example.homework18

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // жирный текст
        val firstTextViewInSecondActivity =
            findViewById<TextView>(R.id.firstTextViewInSecondActivity)
        val data1: String = intent.getStringExtra(KEY1) ?: getString(R.string.nullInString)
        firstTextViewInSecondActivity.text = data1


        // курсивный текст
        val secondTextViewInSecondActivity =
            findViewById<TextView>(R.id.secondTextViewInSecondActivity)
        val data2: String = intent.getStringExtra(KEY2) ?: getString(R.string.nullInString)
        secondTextViewInSecondActivity.text = data2

        // установить тайтл
        val data3: String = intent.getStringExtra(KEY3) ?: getString(R.string.nullInString)
        supportActionBar?.title = data3
    }

//     companion object для открытия второй активити и передачи текста

    companion object {
        private const val KEY1 = "1"
        private const val KEY2 = "2"
        private const val KEY3 = "3"

        fun startMainActivity2(context: Context, string1: String, string2: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY1, string1)
            intent.putExtra(KEY2, string2)
            context.startActivity(intent)
        }

        fun startMainActivity2AndDownloadTitle(context: Context, string: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY3, string)
            context.startActivity(intent)
        }
    }


    // выпадающее меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu2, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // функционал выпадающего меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.second_activity_first_item_close_application -> finishAffinity()
            R.id.second_activity_second_item_return_on_first_activity -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


}
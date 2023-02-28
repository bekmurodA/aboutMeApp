package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

data class MyName(
    var Name:String="",
    var NickName:String=""
)

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    val myName:MyName= MyName(Name = "Bekmurod Abduxamidov")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName
        binding.doneButton.setOnClickListener{addNickname(it)}
    }

    private fun addNickname(view:View){
        binding.apply {
            myName?.NickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameText.visibility= View.VISIBLE
            nicknameEdit.visibility= View.GONE
            view.visibility = View.GONE
        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
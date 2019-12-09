package com.android.tugaskotlin3.View

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.android.tugaskotlin3.Database.UserDao
import com.android.tugaskotlin3.Database.UserDatabase
import com.android.tugaskotlin3.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable

    private var btSignIn: Button? = null
    private var btSignUp: Button? = null
    private var edtEmail: EditText? = null
    private var edtPassword: EditText? = null
    private var database: UserDatabase? = null

    private var userDao: UserDao? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        animationDrawable = linearLay.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Check User...")
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.progress = 0


        database = Room.databaseBuilder(this, UserDatabase::class.java!!, "mi-database.db")
            .allowMainThreadQueries()
            .build()

        userDao = database!!.userDao


        btSignIn = findViewById(R.id.btSignIn)
        btSignUp = findViewById(R.id.btSignUp)

        edtEmail = findViewById(R.id.emailinput)
        edtPassword = findViewById(R.id.passwordinput)



        btSignUp!!.setOnClickListener { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java)) }
        btSignIn!!.setOnClickListener {
            if (!emptyValidation()) {
                progressDialog!!.show()
                Handler().postDelayed({
                    val user = userDao!!.getUser(edtEmail!!.text.toString(), edtPassword!!.text.toString())
                    if (user != null) {
                        val i = Intent(this@LoginActivity, MainActivity::class.java)
                        i.putExtra("User", user)
                        startActivity(i)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show()
                    }
                    progressDialog!!.dismiss()
                }, 1000)

            } else {
                Toast.makeText(this@LoginActivity, "Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun emptyValidation(): Boolean {
        return if (TextUtils.isEmpty(edtEmail!!.text.toString()) || TextUtils.isEmpty(edtPassword!!.text.toString())) {
            true
        } else {
            false
        }
    }
}
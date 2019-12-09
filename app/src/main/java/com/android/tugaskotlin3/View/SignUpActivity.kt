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
import com.android.tugaskotlin3.Model.User
import com.android.tugaskotlin3.R
import kotlinx.android.synthetic.main.signup_activity.*


class SignUpActivity : AppCompatActivity() {
    lateinit var animationDrawable: AnimationDrawable

    private var edtName: EditText? = null
    private var edtLastName: EditText? = null
    private var edtEmail: EditText? = null
    private var edtPassword: EditText? = null

    private var btCancel: Button? = null
    private var btRegister: Button? = null

    private var userDao: UserDao? = null

    private var progressDialog: ProgressDialog? = null

    private val isEmpty: Boolean
        get() = if (TextUtils.isEmpty(edtEmail!!.text.toString()) ||
            TextUtils.isEmpty(edtPassword!!.text.toString()) ||
            TextUtils.isEmpty(edtName!!.text.toString()) ||
            TextUtils.isEmpty(edtLastName!!.text.toString())
        ) {
            true
        } else {
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)


        animationDrawable = siglay.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Registering...")
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.progress = 0


        edtName = findViewById(R.id.nameinput)
        edtLastName = findViewById(R.id.lastnameinput)
        edtEmail = findViewById(R.id.emailinput)
        edtPassword = findViewById(R.id.passwordinput)

        btCancel = findViewById(R.id.btCancel)
        btRegister = findViewById(R.id.btRegister)

        userDao = Room.databaseBuilder(this, UserDatabase::class.java!!, "mi-database.db")
            .allowMainThreadQueries()
            .build()
            .userDao

        btCancel!!.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            finish()
        }

        btRegister!!.setOnClickListener {
            if (!isEmpty) {

                progressDialog!!.show()

                Handler().postDelayed({
                    val user = User(
                        edtName!!.text.toString(), edtLastName!!.text.toString(),
                        edtEmail!!.text.toString(), edtPassword!!.text.toString()
                    )
                    userDao!!.insert(user)
                    progressDialog!!.dismiss()
                    startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                }, 1000)

            } else {
                Toast.makeText(this@SignUpActivity, "Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

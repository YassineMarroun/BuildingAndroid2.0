package com.yassine.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variablesAndConstants();
    }

    /*
    Here we talk about variables and constants
     */
    private fun variablesAndConstants() {

        //Variables
        var myFirstVariable = "Hello"
        var myFirstNumber = 1

        println(myFirstVariable)

        myFirstVariable = "Changing the value"
        println(myFirstVariable)

        var mySecondVariable = "This is second"
        println(mySecondVariable)

        mySecondVariable = myFirstVariable
        println(mySecondVariable)

        myFirstVariable = "Done"
        println(myFirstVariable)

        //Constants
        //A constant cannot change its value
        val myFirstConstant = "Fixed value"
        println(myFirstConstant)
    }
}
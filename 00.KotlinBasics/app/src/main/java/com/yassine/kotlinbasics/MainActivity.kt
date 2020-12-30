package com.yassine.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variablesAndConstants()
        //dataTypes()
        ifStatement()
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

        val mySecondConstant = myFirstVariable
        println(mySecondConstant)
    }

    /*
    Here we talk about data types
     */
    private fun dataTypes() {

        //String
        val myString = "Hello"
        val myString2 = "How are you?"
        val myString3 = myString + " " + myString2
        println(myString3)

        //Integers (Byte, Short, Int, Long)
        val myInt = 1
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        //Decimals (Float, Double)
        val myFloat = 1.5f
        val myDouble = 1.5
        val myDouble2 = 2.6
        val myDouble3 = 1
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        //Boolean
        val myBool = true
        val myBool2 = false
        println(myBool == myBool2)
        println(myBool && myBool2)
    }

    /*
    Here we talk about if statement
     */
    private fun ifStatement() {
        val myNumber = 5;

       //Conditional operators
        // > greater than
        // < less than
        // >= greater or equal to
        // <= less than or equal to
        // == equal
        // != unequal

        //Logical operators
        // && and operator
        // || or operator
        // ! not operator

        if(myNumber <= 10 && myNumber > 5) {
            println("$myNumber is less or equal to 10 and greater than 5")
        } else {
            //Else sentence
            println("$myNumber is greater than 10 or less or equal to 5")
        }
    }
}
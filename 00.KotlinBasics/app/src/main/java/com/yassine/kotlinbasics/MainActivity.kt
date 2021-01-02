package com.yassine.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variablesAndConstants()
        //dataTypes()
        //ifStatement()
        //whenStatement()
        arrays()
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
        val myNumber = 60;

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

        if(myNumber <= 10 && myNumber > 5 || myNumber == 52) {
            //If sentence
            println("$myNumber is less or equal to 10 and greater than 5 or equal to 52")
        } else if(myNumber == 60) {
            //Else if sentence
            println("$myNumber is equal to 60")
        } else if(myNumber != 70) {
            //Else if sentence
            println("$myNumber is unequal to 70")
        } else {
            //Else sentence
            println("$myNumber is greater than 10 or less or equal to 5 or unequal to 52")
        }
    }

    /*
    Here we talk about when statement
     */
    private fun whenStatement() {

        //When with String
        val country = "Colombia"

        when (country) {
            "Spain", "Mexico", "Peru", "Colombia", "Argentina" -> {println("The language is Spanish")}
            "U.S." -> {println("The language is English")}
            "France" -> {println("The language is French")}
            else -> {println("The language is unknown")}
        }

        //When with Int
        val age = 10;

        when (age) {
            0, 1, 2 -> {(println("You're a baby"))}
            in 3..10 -> {println("You're a child")}
            in 11..17 -> {println("You are a teenager")}
            in 18..69 -> {println("You are an adult")}
            in 70..99 -> {println("You are old")}
            else -> {println("Unknown age")}
        }
    }

    /*
    Here we talk about Arrays
     */
    private fun arrays() {

        val name = "Yassine"
        val surname = "Marroun"
        val company = "Infocare"
        val age = "33"

        //Creating an Array
        val myArray = arrayListOf<String>()

        //Adding data one by one
        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)
        println(myArray)

        //Adding a dataset
        myArray.addAll(listOf("Hello", "Welcome"))
        println(myArray)

        //Accessing data
        val myCompany = myArray[2]
        println(myCompany)

        //Modifying data
        myArray[5] = "Bye"
        println(myArray)

        //Deleting data
        myArray.removeAt(4)
        println(myArray)

        //For loop, used to traverse through any data structure
        myArray.forEach {
            println(it)
        }

        //Count number of elements in an array
        println(myArray.count())

        //Accessing the first and last element of an array
        myArray.first()
        myArray.last()

        //Remove all elements from an array
        println(myArray.clear())
        println(myArray.count())
    }
}
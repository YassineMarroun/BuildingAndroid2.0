package com.yassine.kotlinbasics

class Programmer(val name: String, var age: Int, val languages: Array<Language>, val friends: Array<Programmer>? = null) {

    enum class Language {
        KOTLIN,
        JAVA,
        C,
        JAVASCRIPT
    }

    fun code() {
        for (language in languages) {
            println("I'm coding $language")
        }
    }
}
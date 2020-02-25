package com.example.swipequizkotlin

data class Question(
    var question : String,
    var answer : Boolean
) { companion object {
    val questions = arrayOf(
        "A val and a var are the same",
        "Mobile Application Development grants 12 ECTS",
        "A Unit in kotlin corresponds to a void in Java ",
        "In Kotlin when replaces a switch operator in java"
    )

    val answers = arrayOf(
        false,
        false,
        true,
        true
    )
}
}
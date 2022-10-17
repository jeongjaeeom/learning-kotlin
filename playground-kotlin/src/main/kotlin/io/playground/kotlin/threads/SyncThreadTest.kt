package io.playground.kotlin.threads

var n: Int = 0;

@Synchronized
fun produce() {
    for (i in 1..100000) {
        n++
    }
}

@Synchronized
fun consume() {
    for (i in 1..100000) {
        n--
    }
}

fun main() {
    println("Hello World!")

    val thread1 = Thread {
        produce()
    }

    val thread2 = Thread {
        consume()
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println("n :${n}")
}
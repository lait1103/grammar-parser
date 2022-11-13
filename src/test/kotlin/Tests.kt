package com.h0tk3y.spbsu.parallel

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Tests {
    class Tests {
        // Example from the task
        @Test
        fun test1() {
            assertEquals(
                pars(File("/Users/vsdmitri/Desktop/Term3/TI/HW/parser/src/test/kotlin/resources/test1.txt")),
                "0 = 0;\n" +
                        "1 + 2 = 3;\n" +
                        "(1 + 2) * 3 = 9;\n" +
                        "a = 5;\n" +
                        "a + 2 = 7;\n"
            )
        }

        // Example from the task with deleted spaces
        @Test
        fun test2() {
            assertEquals(
                pars(File("/Users/vsdmitri/Desktop/Term3/TI/HW/parser/src/test/kotlin/resources/test2.txt")),
                "0 = 0;\n" +
                        "1+2 = 3;\n" +
                        "(1+2)*3 = 9;\n" +
                        "a = 5;\n" +
                        "a+2 = 7;\n"
            )
        }

        @Test
        fun test3() {
            assertEquals(
                pars(File("/Users/vsdmitri/Desktop/Term3/TI/HW/parser/src/test/kotlin/resources/test3.txt")),
                "a = 1;\n" +
                        "b = 2;\n" +
                        "c = 3;\n" +
                        "d = 4;\n" +
                        "e = 5;\n" +
                        "a * b * c * d = 24;\n"
            )
        }
    }
}
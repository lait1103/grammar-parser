package com.h0tk3y.spbsu.parallel

import MyParser
import helpMeLexer
import helpMeParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File


fun pars(file: File): String {
    val myParser = MyParser()
    val result = java.lang.StringBuilder()
    file.forEachLine { inp ->
        val inputStream: CharStream = CharStreams.fromString(
            inp
        )

        result.append(inp.dropLast(1).split('=')[0].trim() + " = " + myParser.visitStart(
            helpMeParser(
                CommonTokenStream(helpMeLexer(inputStream))
            ).start()
        )?.toString() + ";\n")

    }
    return result.toString()
}

fun main(args: Array<String>) {
    print(pars(File(args[0])))
}
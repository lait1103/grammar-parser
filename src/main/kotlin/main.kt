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
    var calculations = ""
    file.forEachLine { inp ->
        val inputStream: CharStream = CharStreams.fromString(
            inp
        )

        calculations += inp.dropLast(1).split('=')[0].trim() + " = " + myParser.visitStart(
            helpMeParser(
                CommonTokenStream(helpMeLexer(inputStream))
            ).start()
        )?.toString() + ";\n"

    }
    return calculations
}

fun main(args: Array<String>) {
    print(pars(File(args[0])))
}
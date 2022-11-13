
import helpMeBaseVisitor
import helpMeVisitor

class MyParser : helpMeBaseVisitor<Int?>(), helpMeVisitor<Int?> {
    val valNames = mutableMapOf<String, Int?>()
    override fun visitExpression(ctx: helpMeParser.ExpressionContext): Int? {
        if (ctx.DIGIT() != null) return ctx.DIGIT().toString().toIntOrNull()
        if (ctx.VARNAME() != null) return valNames[ctx.VARNAME().toString()]
        if (ctx.children.first().toString() == "(")
            return visitExpression(ctx.expression().first())
        return if (ctx.children[1].toString() == "+") visitExpression(
            ctx.expression().first()
        )!! + visitExpression(ctx.expression()[1])!!
        else visitExpression(ctx.expression().first())!! * visitExpression(ctx.expression()[1])!!
    }

    override fun visitVariable(ctx: helpMeParser.VariableContext): Int? {
        valNames[ctx.VARNAME().toString()] = visitExpression(ctx.expression())
        return visitExpression(ctx.expression())
    }

    override fun visitStart(ctx: helpMeParser.StartContext): Int? {
        if (ctx.variable() != null)
            return visitVariable(ctx.variable())
        if (ctx.expression() != null)
            return visitExpression(ctx.expression())
        return null
    }
}
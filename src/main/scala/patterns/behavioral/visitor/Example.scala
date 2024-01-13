package patterns.behavioral.visitor

abstract class Element(val text: String) {
    def accept(visitor: Visitor): Unit
}

class Title(text: String) extends Element(text) {
    override def accept(visitor: Visitor): Unit = {
        visitor.visit(this)
    }
}

class Text(text: String) extends Element(text) {
    override def accept(visitor: Visitor): Unit = {
        visitor.visit(this)
    }
}

class Hyperlink(text: String, val url: String) extends Element(text) {
    override def accept(visitor: Visitor): Unit = {
        visitor.visit(this)
    }
}

class Document(parts: List[Element]) {
    def accept(visitor: Visitor): Unit = {
        parts.foreach(p => p.accept(visitor))
    }
}

trait Visitor {
    def visit(title: Title): Unit

    def visit(text: Text): Unit

    def visit(hyperlink: Hyperlink): Unit
}

class HtmlExporterVisitor extends Visitor {
    val line: String = java.lang.System.lineSeparator() // System.getProperty("line.separator")
    val builder = new StringBuilder

    def getHtml(): String = builder.toString

    override def visit(title: Title): Unit = {
        builder.append(s"<h1>${title.text}</h1>").append(line)
    }

    override def visit(text: Text): Unit = {
        builder.append(s"<p>${text.text}</p>").append(line)
    }

    override def visit(hyperlink: Hyperlink): Unit = {
        builder.append(s"""<a href=\"${hyperlink.url}\">${hyperlink.text}</a>""").append(line)
    }
}

class PlainTextExporterVisitor extends Visitor {
    val line: String = java.lang.System.lineSeparator()
    val builder = new StringBuilder

    def getText(): String = builder.toString

    override def visit(title: Title): Unit = {
        builder.append(title.text).append(line)
    }

    override def visit(text: Text): Unit = {
        builder.append(text.text).append(line)
    }

    override def visit(hyperlink: Hyperlink): Unit = {
        builder.append(s"${hyperlink.text} (${hyperlink.url})").append(line)
    }
}

object VisitorExample {
    def main(args: Array[String]): Unit = {
        val document = new Document(
            List(
                new Title("The Visitor Pattern Example"),
                new Text("The visitor pattern helps us add extra functionality without changing the classes."),
                new Hyperlink("Go check it online!", "https://www.google.com/"),
                new Text("Thanks!")
            )
        )
        val htmlExporter = new HtmlExporterVisitor
        val plainTextExporter = new PlainTextExporterVisitor
        System.out.println(s"Export to html:")
        document.accept(htmlExporter)
        System.out.println(htmlExporter.getHtml())
        System.out.println(s"Export to plain:")
        document.accept(plainTextExporter)
        System.out.println(plainTextExporter.getText())
    }
}
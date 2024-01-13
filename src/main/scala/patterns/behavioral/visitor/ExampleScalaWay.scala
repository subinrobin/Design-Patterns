package patterns.behavioral.visitor

abstract class ElementSW(text: String) {
    def accept(visitor: VisitorSW): Unit
}

case class TitleSW(text: String) extends ElementSW(text) {
    override def accept(visitor: VisitorSW): Unit = {
        visitor.visit(this)
    }
}

case class TextSW(text: String) extends ElementSW(text) {
    override def accept(visitor: VisitorSW): Unit = {
        visitor.visit(this)
    }
}

case class HyperlinkSW(text: String, val url: String) extends ElementSW(text) {
    override def accept(visitor: VisitorSW): Unit = {
        visitor.visit(this)
    }
}

class DocumentSW(parts: List[ElementSW]) {
    def accept(visitor: VisitorSW): Unit = {
        parts.foreach(p => p.accept(visitor))
    }
}

trait VisitorSW {
    def visit(element: ElementSW): Unit
}

class HtmlExporterVisitorSW extends VisitorSW {
    val line: String = java.lang.System.lineSeparator()
    val builder = new StringBuilder

    def html: String = builder.toString

    override def visit(element: ElementSW): Unit = {
        element match {
            case TitleSW(text) =>
                builder.append(s"<h1>${text}</h1>").append(line)
            case TextSW(text) =>
                builder.append(s"<p>${text}</p>").append(line)
            case HyperlinkSW(text, url) =>
                builder.append(s"""<a href=\"${url}\">${text}</a>""").append(line)
        }
    }
}

class PlainTextExporterVisitorSW extends VisitorSW {
    val line: String = java.lang.System.lineSeparator()
    val builder = new StringBuilder

    def text: String = builder.toString

    override def visit(element: ElementSW): Unit = {
        element match {
            case TitleSW(text) =>
                builder.append(text).append(line)
            case TextSW(text) =>
                builder.append(text).append(line)
            case HyperlinkSW(text, url) =>
                builder.append(s"${text} (${url})").append(line)
        }
    }
}

object VisitorExampleSW {
    def main(args: Array[String]): Unit = {
        val document = new DocumentSW(
            List(
                new TitleSW("The Visitor Pattern Example"),
                new TextSW("The visitor pattern helps us add extra functionality without changing the classes."),
                new HyperlinkSW("Go check it online!", "https://www.google.com/"),
                new TextSW("Thanks!")
            )
        )
        val htmlExporter = new HtmlExporterVisitorSW
        val plainTextExporter = new PlainTextExporterVisitorSW
        System.out.println(s"Export to html:")
        document.accept(htmlExporter)
        System.out.println(htmlExporter.html)
        System.out.println(s"Export to plain:")
        document.accept(plainTextExporter)
        System.out.println(plainTextExporter.text)
    }
}
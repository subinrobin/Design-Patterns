package patterns.behavioral.visitor

abstract class ElementSWF(text: String) {
    def accept(visitor: ElementSWF => Unit): Unit = {
        visitor(this)
    }
}

case class TitleSWF(text: String) extends ElementSWF(text)

case class TextSWF(text: String) extends ElementSWF(text)

case class HyperlinkSWF(text: String, val url: String) extends ElementSWF(text)

class DocumentSWF(parts: List[ElementSWF]) {
    def accept(visitor: ElementSWF => Unit): Unit = {
        parts.foreach(p => p.accept(visitor))
    }
}

object VisitorExampleSWF {
    val line: String = java.lang.System.lineSeparator()

    def htmlExporterVisitorSWF(builder: StringBuilder): ElementSWF => Unit = {
        case TitleSWF(text) =>
            builder.append(s"<h1>${text}</h1>").append(line)
        case TextSWF(text) =>
            builder.append(s"<p>${text}</p>").append(line)
        case HyperlinkSWF(text, url) =>
            builder.append(s"""<a href=\"${url}\">${text}</a>""").append(line)
    }

    def plainTextExporterVisitorSWF(builder: StringBuilder): ElementSWF => Unit = {
        case TitleSWF(text) =>
            builder.append(text).append(line)
        case TextSWF(text) =>
            builder.append(text).append(line)
        case HyperlinkSWF(text, url) =>
            builder.append(s"${text} (${url})").append(line)
    }

    def main(args: Array[String]): Unit = {
        val document = new DocumentSWF(
            List(
                TitleSWF("The Visitor Pattern Example"),
                TextSWF("The visitor pattern helps us add extra functionality without changing the classes."),
                HyperlinkSWF("Go check it online!", "https://www.google.com/"),
                TextSWF("Thanks!")
            )
        )
        val html = new StringBuilder
        System.out.println(s"Export to html:")
        document.accept(htmlExporterVisitorSWF(html))
        System.out.println(html.toString())
        val plain = new StringBuilder
        System.out.println(s"Export to plain:")
        document.accept(plainTextExporterVisitorSWF(plain))
        System.out.println(plain.toString())
    }
}
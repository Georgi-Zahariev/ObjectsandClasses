import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //"{title}, {content}, {author}" -> ["{title}", "{content}", "{author}"]
        Scanner scanner = new Scanner(System.in);
        String[] articlesParts = scanner.nextLine().split(", ");
        String title = articlesParts[0];
        String content = articlesParts[1];
        String author = articlesParts[2];

        Article article = new Article(title, content, author);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int count = 1; count <= commandsCount; count++) {
            String command = scanner.nextLine();
            //"{име на команда}: {нова стойност}".split(": ") -> ["{име на командата}", "{нова стойност}"]
            String commandName = command.split(": ")[0]; //Edit, ChangeAuthor, Rename
            String newValue = command.split(": ")[1];
            switch(commandName) {
                case "Edit":
                    //зададем нов content на статията
                    article.setContent(newValue);
                    break;
                case "ChangeAuthor":
                    //зададем нов автор на статията
                    article.setAuthor(newValue);
                    break;
                case "Rename":
                    //зададем ново заглавие на статията
                    article.setTitle(newValue);
                    break;
            }

        }
        //{title} - {content}: {author}
        System.out.println(article);
    }
}
class Article {
    //полета
    private String title;
    private String content;
    private String author;

    //методи
    //конструктор -> създаваме обект (инстанция) от този клас
    public Article(String title, String content, String author) {
        //създава се нов празен обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //задава нова стойност на полето content
    public void setContent(String newContent) {
        this.content = newContent;
    }

    //задава нова стойност на полето author
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    //задава нова стойност на полето title
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }


    //{title} - {content}: {author}
    @Override
    public String toString() {
        //обект в стринг
        //return this.title + " - " + this.content + ": " + this.author;
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }
}

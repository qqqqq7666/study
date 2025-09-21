package construct.ex;

public class Book {
    String title;
    String author;
    int page;

    Book(String title, String author, int page){
        this.title = title;
        this.author = author;
        this.page = page;
    }

    Book(String title, String author){
        this(title, author, 0);
    }

    Book(){
        this("","",0);
    }

    void displayInfo(){
        System.out.println("title: " + this.title + ", author: " + this.author + ", page: " + this.page);
    }
}

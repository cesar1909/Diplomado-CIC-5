package mx.ipn.cic.listviewexample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements Serializable {

    private int id;

    private String title;

    private int pages;

    private String author;

    private String editorial;

    public BookModel() {
    }

    public BookModel(int id, String title, int pages, String author, String editorial) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.editorial = editorial;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }

    public static List<BookModel> defaults(int count) {

        List<BookModel> list = new ArrayList<BookModel>();

        for (int i = 1; i <= count; i++) {

            BookModel book = new BookModel(
                    i,
                    "Title " + i,
                    i*i,
                    "Author " + i,
                    "Editorial " + i);

            list.add(book);

        }

        return list;

    }

}






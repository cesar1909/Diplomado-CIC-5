package mx.ipn.cic.masterdetailexample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements Serializable {

    private int id;

    private String title;

    private String author;

    private String editorial;

    private int pages;

    public BookModel() {
    }

    public BookModel(int id, String title, String author, String editorial, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.pages = pages;
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

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static List<BookModel> defaults(int count) {

        List<BookModel> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            BookModel bookModel = new BookModel(i,
                    "Title " + i,
                    "Author " + i,
                    "Editorial " + i,
                    i * i);

            list.add(bookModel);

        }


        return list;

    }
}

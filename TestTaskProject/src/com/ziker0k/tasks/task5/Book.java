package com.ziker0k.tasks.task5;

public class Book extends Item {
    private final int pages;

    public Book(int volume, int price, int pages) {
        super(volume, price);
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                "} " + super.toString();
    }
}

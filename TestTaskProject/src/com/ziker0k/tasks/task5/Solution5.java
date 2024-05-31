package com.ziker0k.tasks.task5;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        Safe safe = new Safe(50);
        List<Item> items = new ArrayList<>();
        items.add(new Book(2, 100, 123));
        items.add(new Book(3, 200, 222));
        items.add(new Book(7, 50, 345));
        items.add(new Book(10, 60, 521));
        items.add(new Book(12, 400, 500));
        items.add(new Book(3, 20, 42));
        items.add(new Book(5, 10, 23));
        items.add(new Book(8, 100, 55));
        items.add(new Book(19, 500, 821));
        items.add(new Book(10, 112, 87));
        items.add(new Book(13, 200, 254));

        items = safe.addItems(items);

        System.out.println("Невошедшие предметы: " + items + "\n");

        System.out.println(safe + "\n");

        System.out.println("Цена всех предметов в сейфе " + safe.getFullPrice());
    }
}

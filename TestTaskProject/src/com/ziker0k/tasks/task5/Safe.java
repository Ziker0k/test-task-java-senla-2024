package com.ziker0k.tasks.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Safe {
    private final List<Item> items;
    private final int volume;
    private int remainingVolume;

    public Safe(int volume) {
        this.volume = volume;
        remainingVolume = volume;
        items = new ArrayList<>();
    }

    public List<Item> addItems(List<Item> items) {
        items.sort(Comparator.comparingInt(Item::getPrice).reversed());
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (addItem(item)) {
                remainingVolume -= item.getVolume();
                items.remove(i);
                i--;
            }
        }
        return items;
    }

    public boolean addItem(Item item) {
        if (item.getVolume() <= remainingVolume) {
            return this.items.add(item);
        }
        return false;
    }

    public int getFullPrice() {
        return items.stream()
                .mapToInt(Item::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Safe{" + System.lineSeparator() +
                "items=" + items + System.lineSeparator() +
                "volume=" + volume + System.lineSeparator() +
                "remainingVolume=" + remainingVolume +
                '}';
    }
}

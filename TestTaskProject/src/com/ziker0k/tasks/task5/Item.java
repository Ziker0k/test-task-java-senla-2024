package com.ziker0k.tasks.task5;

public abstract class Item {
    private int volume;
    private int price;

    public Item(int volume, int price) {
        this.volume = volume;
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "volume=" + volume +
                ", price=" + price +
                '}';
    }
}

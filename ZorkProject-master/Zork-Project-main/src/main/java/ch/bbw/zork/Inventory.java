package ch.bbw.zork;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> bag;
    //private  boolean isInventory;
    private Item item;

    public Inventory() {
        this.bag = new ArrayList<>();
    }

    public boolean isInInventory(Item anItem) {
        for (int i = 0; i < bag.size(); ) {
            if (bag.get(i).equals(anItem)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void addItem(Item item) {
        bag.add(item);
    }

    public void removeItem(Item item) {
        for (int i = 0; i < bag.size(); i++) {
            if (item.getItemName().equals(bag.get(i).getItemName()) && item.getItemType().equals(bag.get(i).getItemType())) {
                bag.remove(i);
            }
        }
    }

    public void printInventory() {
        if (bag.size() == 0) {
            System.out.println("There is nothing in your inventory! :)");
        } else if (bag.size() > 0) {

            for (int i = 0; i < bag.size(); i++) {
                System.out.println(bag.get(i).toString());
            }
        } else {
            System.out.println("There is nothing in your inventory! :)");
        }
    }

    public int numberOfItems() {
        return bag.size();
    }
}

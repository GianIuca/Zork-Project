package ch.bbw.zork;


import java.util.ArrayList;

public class Item {

    private String itemName;
    private String weight;
    private String itemType;
    private boolean isWeapon;
    private boolean isMedicine;
    private boolean isFood;

    public Item(String itemName) {
        this.itemName = itemName;
        this.itemType = this.itemType;
        this.weight = this.weight;
    }

    public Item(String itemName, String itemType, String weight) {
        super();
        this.itemName = itemName;
        this.itemType = itemType;
        this.weight = weight;

        isWeapon = itemType.equals("weapon");
        isMedicine = itemType.equals("medicine");
        isFood = itemType.equals("food");
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public String getWeight() {
        return weight;
    }

    public void removeItem(Item item, ArrayList<Item> roomItems) {
        for (int i = 0; i < roomItems.size(); i++) {
            if (roomItems.get(i).equals(item))
                roomItems.remove(i);
        }
    }

    public Item stringToItem(String aString) {
        Item item;
        if (!isItem(aString)) {
            return null;
        } else {
            item = new Item(aString, itemType, weight);
            return item;
        }
    }

    public boolean isItem(String aString) {
        if (aString.equals(itemName))
            return true;
        return false;
    }


}
package ch.bbw.zork;import java.util.Set;import java.util.ArrayList;import java.util.Arrays;import java.util.HashMap;import java.util.Iterator;import java.util.List;class Room {    private Item item;    private Item item1;    private Item key;    private Riddle riddle;    private boolean locked;    private String roomName;    private String description;    private ArrayList<Item> itemList;              //this is the room inventory    private HashMap<String, Room> exits;        // stores exits of this room.    /**     * Create a room described "description". Initially, it has no exits.     * "description" is something like "a kitchen" or "an open court yard".     */    public Room(String description) {        this.description = description;        exits = new HashMap<String, Room>();    }    public Room(String description, Item item, Item key) {        this.description = description;        this.item = item;        this.key = key;        itemList = new ArrayList<Item>();        exits = new HashMap<String, Room>();    }    public Room(String description, Item item, Item item1, Item key) {        this.description = description;        this.item = item;        this.key = key;        itemList = new ArrayList<Item>();        exits = new HashMap<String, Room>();    }    public Room() {        // default constructor.        roomName = "DEFAULT ROOM";        description = "DEFAULT DESCRIPTION";        itemList = new ArrayList<Item>();        exits = new HashMap<String, Room>();    }    public Room(String roomName, Item item, Quiz quiz, boolean locked, Item key) {        this.roomName = roomName;        this.item = item;        this.riddle = quiz;        this.locked = locked;        this.key = key;        itemList = new ArrayList<Item>();        exits = new HashMap<String, Room>();    }    public Room(String roomName, Item item, Item item1, Quiz quiz, boolean locked, Item key) {        this.roomName = roomName;        this.item = item;        this.item1 = item1;        this.riddle = quiz;        this.locked = locked;        this.key = key;        itemList = new ArrayList<Item>();        exits = new HashMap<String, Room>();    }    /**     * Define the exits of this room.  Every direction either leads to     * another room or is null (no exit there).     */    public void setExits(Room north, Room east, Room south, Room west) {        exits.put("north", north);        exits.put("east", east);        exits.put("south", south);        exits.put("west", west);    }    /**     * Return the description of the room (the one that was defined in the     * constructor).     */    public String shortDescription() {        return "Room: " + roomName + "\n\n" + description;    }    public String longDescription() {        StringBuilder stringBuilder = new StringBuilder("You are in " + description + ".\n");        stringBuilder.append(exitString());        return stringBuilder.toString();    }    /**     * Return a string describing the room's exits, for example     * "Exits: north west ".     */    private String exitString() {        String returnString = "Exits:";        Set keys = exits.keySet();        for (Iterator iter = keys.iterator(); iter.hasNext(); )            returnString += " " + iter.next();        return returnString;    }    /**     * Return the room that is reached if we go from this room in direction     * "direction". If there is no room in that direction, return null.     */    public Room nextRoom(String direction) {        return (Room) exits.get(direction);    }    public String getRoomName() {        return roomName;    }    public void setRoomName(String roomName) {        this.roomName = roomName;    }    public String getDescription() {        return ("You are  " + description);    }    public void setDescription(String description) {        this.description = description;    }    public ArrayList<Item> getRoomInventory() {        itemList.add(key);        itemList.add(item);        return itemList;    }    //takes the string array of the items in the room and puts it in an ArrayList of items    public void setRoomInventory(String[] items) {        List<String> stringItems = Arrays.asList(items);        ArrayList<Item> realList = new ArrayList<Item>(stringItems.size());        for (int i = 0; i < realList.size(); i++) {            if (stringItems.get(i).equals("none")) {                i++;            } else {                realList.add(item.stringToItem(stringItems.get(i)));            }        }        this.itemList = realList;    }    public Item getItem() {        return item;    }    public void setItem(Item item) {        this.item = item;    }    public Item getKey() {        return key;    }    public void setKey(Item key) {        this.key = key;    }    public ArrayList<Item> getItemList() {        return itemList;    }    public void setItemList(ArrayList<Item> itemList) {        this.itemList = itemList;    }    public HashMap<String, Room> getExits() {        return exits;    }    public Item getItem1() {        return item1;    }    public void setItem1(Item item1) {        this.item1 = item1;    }    public Riddle getRiddle() {        return riddle;    }    public boolean startRiddle() {        return riddle.start();    }    public void setRiddle(Riddle riddle) {        this.riddle = riddle;    }    public boolean isLocked() {        return locked;    }    public void setLocked(boolean locked) {        this.locked = locked;    }    /*      * public boolean inRoom(String string) {             for(int i=0;i<itemList.size();i++) {                   if(itemList.get(i).equals(string))                          return true;             }             return false;      }      */}
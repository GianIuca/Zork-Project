package ch.bbw.zork.test;

import ch.bbw.zork.*;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    @org.junit.jupiter.api.Test
    public void testNewCommands() {
        Command testCommand = new Command("hellothisisatest");
        assert ("hellothisisatest".equals(testCommand.getCommandWord()));
    }

    @org.junit.jupiter.api.Test
    public void testNewCommandsSecondWord() {
        Command testCommand = new Command("testFirstWord", "testSecondWord");
        assert ("testFirstWord".equals(testCommand.getCommandWord()) && "testSecondWord".equals(testCommand.getSecondWord()));
    }

    @org.junit.jupiter.api.Test
    public void testHasSecondWord() {
        Command testCommand = new Command("help", "me");
        assertTrue(testCommand.hasSecondWord());

        Command testCommand1 = new Command("help");
        assertFalse(testCommand1.hasSecondWord());
    }

    @org.junit.jupiter.api.Test
    public void testIsCommand() {
        CommandWords commandWords = new CommandWords();

        assertTrue(commandWords.isCommand("map"));
        assertFalse(commandWords.isCommand("mop"));
    }

    @org.junit.jupiter.api.Test
    public void testInv() {
        Inventory inventory = new Inventory();
        Item sword = new Item("Sword", "Weapon", "1 Kg");
        Item dagger = new Item("Dagger", "Weapon", "0.4 Kg");
        Item dagger2 = new Item("Dagger2", "Weapon", "7 Kg");

        inventory.addItem(sword);
        inventory.addItem(dagger);

        assertTrue(inventory.isInInventory(sword));
        assertFalse(inventory.isInInventory(dagger2));
    }

    @org.junit.jupiter.api.Test
    public void testRooms() {
        Room room = new Room();
        Item sword = new Item("Sword", "Weapon", "1 Kg");
        Item sword2 = new Item("Sword2", "Weapon", "1 Kg");
        Item key2 = new Item("key2", "key", "0.28 Kg");

        room.setItem1(sword);
        room.setItem(sword2);
        room.setKey(key2);


        assertEquals(room.getItem1(), sword);
        assertEquals(room.getItem(), sword2);
        assertEquals(room.getKey(), key2);
    }

    @org.junit.jupiter.api.Test
    public void testLockedRoom() {
        Item sword = new Item("Sword", "Weapon", "1 Kg");
        Item sword2 = new Item("Sword2", "Weapon", "1 Kg");
        Item key2 = new Item("key2", "key", "0.28 Kg");
        Quiz quiz4 = new Quiz("What provides the strength and power to walk through walls?", "door");
        Room room = new Room("the treasure room of the King.", sword, sword2, quiz4, true, key2);

        assertTrue(room.isLocked());
        assertEquals(room.getKey(), key2);
        assertEquals(room.getRiddle(), quiz4);
    }
}

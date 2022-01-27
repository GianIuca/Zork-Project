package ch.bbw.zork.test;

import ch.bbw.zork.Command;
import ch.bbw.zork.CommandWords;
import ch.bbw.zork.Inventory;
import ch.bbw.zork.Item;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}

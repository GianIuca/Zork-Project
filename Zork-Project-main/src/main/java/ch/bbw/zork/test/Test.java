package ch.bbw.zork.test;

import ch.bbw.zork.Command;
import ch.bbw.zork.CommandWords;

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
}

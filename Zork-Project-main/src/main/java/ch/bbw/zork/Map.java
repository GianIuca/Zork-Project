package ch.bbw.zork;

public class Map {
    public static void show(Room currentroom) {
        System.out.println("you are in " + currentroom.getDescription());
        System.out.println("This dungeon:\n" +
                "          Throneroom\n" +
                "              ↑\n" +
                "              |\n" +
                "           Hallway--→ Treasureroom\n" +
                "              ↑\n" +
                "              |\n" +
                "Brewery ←--Library--→ Smithy\n" +
                "              ↑\n" +
                "              |\n" +
                "           Garden\n");


    }
}

package ch.bbw.zork;

import java.util.Scanner;


public class Quiz implements Riddle {

    Scanner scanner = new Scanner(System.in);
    String question;
    String answer;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean start() {
        System.out.println("A riddle has shown up");
        riddle();
        if (solved) {
            System.out.println("The riddle is solved, well done");
            return true;
        }
        return false;
    }

    @Override
    public void riddle() {
        System.out.println(question);
        String string = "";
        boolean solved = false;
        while (!solved) {
            string = scanner.nextLine();
            if (string.equals(answer)) {
                solved = true;
            }
        }
    }
}
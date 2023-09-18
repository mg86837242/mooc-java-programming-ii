package mooc.logic;

import java.util.stream.IntStream;

import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int times) {
        IntStream.range(0, times).forEach(index -> {
            System.out.println("Application logic is working");
            ui.update();
        });
    }
}

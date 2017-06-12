package Year_1.Dev02_4;


public class GUIConstructor extends GUIMenuCreator {

    @Override
    public GUIManager instantiate(String option, Runnable exitAction) {
        GUIManager guiManager = new GUIManager();

        switch (option) {
            // Main window
            case "1":
                guiManager.elements = new ListIterator<>();
                guiManager.elements.add(new Button("Input window", new Point(150.0f, 100.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
                        () -> {
                            System.out.println("To input window");
                            Program.guiManager = instantiate("3", () -> System.exit(0));
                        }
                ));
                guiManager.elements.add(new Button("Label window", new Point(150.0f, 200.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
                        () -> {
                            System.out.println("To label window");
                            Program.guiManager = instantiate("2", () -> System.exit(0));
                        }
                ));
                guiManager.elements.add(new Button("Exit", new Point(150.0f, 300.0f), 30, CustomColor.BLACK, 150.0f, 40.0f,
                        () -> {
                            exitAction.run();
                            // Exit button
                        }));
                break;

            // Label window
            case "2":
                guiManager.elements = new ListIterator<>();
                guiManager.elements.add(new Label("I am a label", new Point(150.0f, 30.0f), 30, CustomColor.WHITE));
                guiManager.elements.add(new Button("Back", new Point(150.0f, 200.0f), 30, CustomColor.BLACK, 150.0f, 40.0f,
                        () -> {
                            System.out.println("Triggered");
                            Program.guiManager = instantiate("1", () -> System.exit(0));
                        }));
                break;

            // Input window
            case "3":
                guiManager.elements = new ListIterator<>();
                guiManager.elements.add(new Button("Back", new Point(150.0f, 200.0f), 30, CustomColor.BLACK, 150.0f, 40.0f,
                        () -> {
                            System.out.println("Triggered");
                            Program.guiManager = instantiate("1", () -> System.exit(0));
                        }));
                break;
        }
        return guiManager;
    }
}

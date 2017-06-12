package Year_1.Dev02_4;


public class GUIConstructor extends GUIMenuCreator {

    @Override
    public GUIManager instantiate(String option, Runnable exitAction) {
        GUIManager guiManager = new GUIManager();

        switch (option) {
            // Main window
            case "1":
                guiManager.elements = new ListIterator<>();
                guiManager.elements.add(new Label("Hi Ahmed", new Point(150.0f, 30.0f), 30, CustomColor.WHITE));
                guiManager.elements.add(new Button("Click me!", new Point(150.0f, 100.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
                        () -> {
                            System.out.println("Action triggered!");
                            guiManager.elements = new ListIterator<>();
                            guiManager.elements.add(new Button("Exit", new Point(150.0f, 200.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
                                    () -> {
                                        exitAction.run();
                                    }));
                        }
                ));
                break;
        }
        return guiManager;
    }
}

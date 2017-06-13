package Year_1.Dev02_4;


public class GUIConstructor extends GUIMenuCreator {

    @Override
    public GUIManager instantiate(String option, Runnable exitAction) {
        GUIManager guiManager = new GUIManager();

        switch (option) {
            // Main window
            case "1":
                GUIElementCreator buttonConstructor = new ButtonConstructor();
                GUIElementCreator labelConstructor = new LabelConstructor();
                guiManager.elements = new ListIterator<>();
                guiManager.elements.add(labelConstructor.instantiate("Hi Ahmed", new Point(150.0f, 30.0f), 30, CustomColor.WHITE));
                guiManager.elements.add(buttonConstructor.instantiate("Click me!", new Point(150.0f, 100.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
                        () -> {
                            System.out.println("Action triggered!");
                            guiManager.elements = new ListIterator<>();
                            guiManager.elements.add(buttonConstructor.instantiate("Exit", new Point(150.0f, 200.0f), 30, CustomColor.BLACK, 200.0f, 40.0f,
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

package Year_1.Dev02_4;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.Group;


public class Program extends Application{

    public static double WIDTH;
    public static double HEIGHT;

    private GraphicsContext gc;

    private Image backgroundImage;

    public static GUIManager guiManager;
    private IDrawVisitor drawVisitor;
    private IUpdateVisitor updateVisitor;
    private IDrawingManager drawingManager;
    private IInputManager inputManager;

    @Override
    public void start(Stage stage) {
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        WIDTH = (int) bounds.getWidth()/2;
        HEIGHT = (int) bounds.getHeight()/2;

        // Size of window
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        stage.setResizable(true);
        stage.setFullScreen(false);

        Scene scene = new Scene(root);

        // Mouse
        scene.setOnMouseMoved(Mouse::move);
        scene.setOnMousePressed(Mouse::pressed);
        scene.setOnMouseDragged(Mouse::pressed);
        scene.setOnMouseReleased(Mouse::released);
        scene.setOnScroll(Mouse::scroll);

        // Size of window managed in real-time
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            WIDTH = (double) newValue;
            if (WIDTH < 1)
                WIDTH = 1;
            canvas.setWidth(WIDTH);
        });
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            HEIGHT = (double) newValue;
            if (HEIGHT < 1)
                HEIGHT = 1;
            canvas.setHeight(HEIGHT);
        });

        stage.setScene(scene);
        stage.sizeToScene();

        gc = canvas.getGraphicsContext2D();
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.show();

        this.backgroundImage = new Image("/Year_1/Dev02_4/Images/coffee.jpg");

        GUIConstructor guiConstructor = new GUIConstructor();
        this.guiManager = guiConstructor.instantiate("1", () -> System.exit(0));

        this.drawingManager = new FXDrawingAdapter(gc);
        this.drawVisitor = new DefaultDrawVisitor(this.drawingManager);
        this.inputManager = new FXMouse();
        this.updateVisitor = new DefaultUpdateVisitor(this.inputManager);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                float dt = 0;

                render(dt);
            }
        }.start();
    }

    public void render(float dt) {
        gc.clearRect(0,0, WIDTH, HEIGHT);

        gc.drawImage(this.backgroundImage, 0, 0, WIDTH, HEIGHT);
        this.guiManager.update(this.updateVisitor, dt);
        this.guiManager.draw(this.drawVisitor);

        Mouse.update();
    }

    public static void main(String[]args) {
        launch();
    }

}

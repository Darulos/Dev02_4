package Year_1.Dev02_4;

/*
 Copied from https://github.com/Mavenir/INFDEV02-4-Assignment/blob/master/src/edu/hr/infdev024/Mouse.java
 Copyright Mavenir, 2017
 */

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class Mouse {

    private static float x;
    private static float y;

    // click
    private static boolean left_pressed;
    private static boolean left_released;
    private static boolean right_pressed;
    private static boolean right_released;

    // scroll
    private static boolean scroll_up;
    private static boolean scroll_down;

    // drag
    private static boolean dragged;
    private static float start_x;
    private static float start_y;

    public static void move(MouseEvent e) {
        x = (float) e.getX();
        y = (float) e.getY();
    }

    public static void pressed(MouseEvent e) {
        move(e);
        if (!left_pressed && !right_pressed) {
            start_x = x;
            start_y = y;
        }
        if (e.getButton() == MouseButton.PRIMARY)
            left_pressed = true;
        if (e.getButton() == MouseButton.SECONDARY)
            right_pressed = true;
    }

    public static void released(MouseEvent e) {
        move(e);
        if (e.getButton() == MouseButton.PRIMARY)
            left_pressed = false;
        if (e.getButton() == MouseButton.SECONDARY)
            right_pressed = false;
    }

    public static void scroll(ScrollEvent e) {
        if (e.getDeltaY() > 0) {
            scroll_up = true;
        } else if (e.getDeltaY() < 0) {
            scroll_down = true;
        }
    }

    public static void update() {
        left_released = left_pressed;
        right_released = right_pressed;
        scroll_up = false;
        scroll_down = false;
        if (left_pressed || right_pressed) {
            double diff_x = x - start_x;
            double diff_y = y - start_y;
            double d = 15;
            if (Math.abs(diff_x) > d || Math.abs(diff_y) > d) {
                dragged = true;
            }
        } else {
            dragged = false;
        }
    }

    public static float getX() {
        return x;
    }

    public static float getY() {
        return y;
    }

    public static float getStartX() {
        return start_x;
    }

    public static float getStartY() {
        return start_y;
    }

    public static void setStartX(float x) {
        start_x = x;
    }

    public static void setStartY(float y) {
        start_y = y;
    }

    public static boolean isInside(double xc, double yc, double w, double h) {
        return xc <= x && x <= xc + w && yc <= y && y <= yc + h;
    }

    public static boolean isDownLeft() {
        return left_pressed;
    }

    public static boolean isDownRight() {
        return right_pressed;
    }

    public static boolean isPressed() {
        return isPressedLeft() || isPressedRight();
    }

    public static boolean isPressedLeft() {
        return !left_pressed && left_released && !isDragged();
    }

    public static boolean isPressedRight() {
        return !right_pressed && right_released && !isDragged();
    }

    public static boolean isScrolled() {
        return scroll_up || scroll_down;
    }

    public static boolean isScrolledUp() {
        return scroll_up;
    }

    public static boolean isScrolledDown() {
        return scroll_down;
    }

    public static boolean isDragged() {
        return dragged;
    }
}
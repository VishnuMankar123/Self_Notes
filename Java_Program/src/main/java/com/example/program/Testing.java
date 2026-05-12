package com.example.program;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

public class Testing {

    public static void main(String[] args) throws Exception {

        ProcessBuilder pb = new ProcessBuilder(
                "cmd", "/c", "start", "",
                "C:\\Program Files\\Notepad++\\notepad++.exe"
        );
        pb.start();

        Thread.sleep(4000);

        Robot robot = new Robot();

        // New file
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(1000);

        while (true) {

            String text = String.valueOf(LocalDateTime.now());

            for (char c : text.toCharArray()) {
                typeCharacter(robot, c);
                Thread.sleep(50);
            }

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(1000);
        }
    }

    private static void typeCharacter(Robot robot, char c) {

        switch (c) {

            case ' ':
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
                break;

            case ':':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;

            case '-':
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                break;

            default:

                if (Character.isLetter(c)) {

                    boolean upper = Character.isUpperCase(c);
                    int keyCode = KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(c));

                    if (upper) robot.keyPress(KeyEvent.VK_SHIFT);

                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);

                    if (upper) robot.keyRelease(KeyEvent.VK_SHIFT);

                } else if (Character.isDigit(c)) {

                    int keyCode = KeyEvent.VK_0 + (c - '0');
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                }
        }
    }
}

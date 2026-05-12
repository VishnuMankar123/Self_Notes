package com.example.program;


public class TestingController {

    public static void main(String[] args) throws Exception {

        while (true) {

            System.out.println("1 minute completed at: " + java.time.LocalDateTime.now());

            Thread.sleep(60000); // 60000 milliseconds = 1 minute
        }
    }
}

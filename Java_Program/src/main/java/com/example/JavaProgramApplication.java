package com.example;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.eclipse.paho.client.mqttv3.*;

@SpringBootApplication
public class JavaProgramApplication {

	/*public static void main(String[] args) throws MqttException, InterruptedException {
        String broker = "tcp://localhost:1883";
        String clientId = "javaSubscriber";

        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());

        client.setCallback(new MqttCallback() {

            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("Connection lost! Reason: " + cause);
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) {
                System.out.println("Received → Topic: " + topic +
                        ", Message: " + new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {}
        });

        client.connect();

        String topic = "demo/topic";
        client.subscribe(topic, 1);

        System.out.println("Subscribed to: " + topic);
        System.out.println("Waiting for messages...");

        // Keep subscriber alive forever
        while (true) {
            Thread.sleep(1000);
        }
    }*/
}



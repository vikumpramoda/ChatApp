package com.company.client;

import java.io.IOException;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

        Client client =new Client();
        client.start();

        //what if you can capture user input the scanner class
        client.sendMessage("Hello from the Client");
        client.sendMessage("How are You");
        client.sendMessage("I'm Fine");
        client.sendMessage("Thank you");
        client.sendMessage("Exit");

        System.out.println("Client finished the execution ...");

    }
}

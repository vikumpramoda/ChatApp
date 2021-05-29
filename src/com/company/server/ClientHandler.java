package com.company.server;

import java.io.*;
import java.net.Socket;


public class ClientHandler implements Runnable {
    private Socket client;
    public ClientHandler(Socket socket) {

        this.client=socket;
    }

    @Override
    public void run() {

        try{
            Thread.sleep(30000);
            InputStream inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());


            String inputData;
            while((inputData = bufferedReader.readLine() )!= null){

                System.out.println("Client says " + inputData);
                //send data to client
                switch (inputData){
                    case "Hello from the Client":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are You":
                        outputStream.writeBytes("I'm Fine, how are you?\n");
                        break;
                    case "I'm Fine":
                        outputStream.writeBytes("Okay good to know. \n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("You are welcome\n");
                        break;
                    default:outputStream.writeBytes("I didn't understand that. ");

                }

                if(inputData.equals("Exit")){
                    break;
                }

            }
            client.close();

        }catch (InterruptedException | IOException e){
            e.printStackTrace();
        }


    }

}

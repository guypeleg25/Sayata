package com.example.demo.ClientHandler;

import com.example.demo.Util.Constants;

import java.util.*;
import java.net.*;
import java.io.*;

public class Client
{

    public static void main(String[] args)
    {

        Socket connection;
        ObjectOutputStream output;
        ObjectInputStream input;
        Scanner myInput;
        Object obj;
        String msg="";

        try
        {
            connection=new Socket(Constants.SERVER_IP,Constants.SERVER_PORT);
            output=new ObjectOutputStream(connection.getOutputStream());
            input=new ObjectInputStream(connection.getInputStream());
            myInput=new Scanner(System.in);


            while(true)
            {
                System.out.println("Enter String");
                msg=myInput.nextLine();

                output.writeObject(msg);
                output.flush();

                obj=input.readObject();
                System.out.println(obj.toString());
            }
        }

        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
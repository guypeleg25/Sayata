package com.example.demo;

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
            connection=new Socket("localhost",8000);
            output=new ObjectOutputStream(connection.getOutputStream());
            input=new ObjectInputStream(connection.getInputStream());
            myInput=new Scanner(System.in);


            while(true)
            {
                System.out.println("Enter String");
                msg=myInput.nextLine();

                output.writeObject(msg);
                output.flush();

                obj=(Object)input.readObject();
                System.out.println(obj.toString());
            }
        }

        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }

        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

    }

}
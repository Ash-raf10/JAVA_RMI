package rmiPrac5.Client;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;


import rmiPrac5.classes.StudentData;
import rmiPrac5.classes.StudentService;

public class Client {

    // Host or IP of Server


    public static void main(String[] args) {
        th m = new th();

        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(m);
            t.start();
        }
    }
}
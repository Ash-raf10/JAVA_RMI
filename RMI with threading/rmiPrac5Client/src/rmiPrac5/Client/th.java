package rmiPrac5.Client;

import rmiPrac5.classes.StudentData;
import rmiPrac5.classes.StudentService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class th implements Runnable {

    private static final String HOST = "localhost";
    private static final int PORT = 6969;
    private static Registry registry;


    public void run() {

            // Search the registry in the specific Host, Port.
            try {
                registry = LocateRegistry.getRegistry(HOST, PORT);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            // Lookup WeatherService in the Registry.
            StudentService service = null;
            try {
                service = (StudentService) registry.lookup(StudentService.class.getSimpleName());
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }


            StudentData student = null;
            try {
                student = service.getStudents(4);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            System.out.println(student.getStdID());
            System.out.println(student.getStdName());

            StudentData studentData = null;
            try {
                studentData = service.getStudentsList();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            List<StudentData> list = studentData.getStudentList();
            for (StudentData s : list) {
                System.out.println(s.getStdID() + "  " + s.getStdName());

            }
            System.out.println();


        }

    }



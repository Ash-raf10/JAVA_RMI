package rmiPrac5.classes;

import java.rmi.Remote;
import java.rmi.RemoteException;




public interface StudentService extends Remote {




  public StudentData getStudents(int id) throws RemoteException;
  public StudentData getStudentsList() throws RemoteException;

}
package mvc;
import java.io.*;
import java.beans.*;


public abstract class Model extends Publisher implements Serializable {

    String fileName = null;
    Model test;
    public void changed() {
        notifySubscribers();
    }




}
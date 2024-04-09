package mvc;
import java.io.*;
import java.beans.*;


public abstract class Model extends Publisher implements Serializable {


    String fileName = null;


//    protected PropertyChangeSupport mPcs =
//            new PropertyChangeSupport(this);
//
//    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
//        mPcs.firePropertyChange(propertyName, oldValue, newValue);
//    }

    //    public void serializeModel(String filename) {
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
//            out.writeObject(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Model deserializeModel(String filename) {
//        Model model = null;
//        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
//            model = (Model) in.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return model;
//    }
    Model test;
    public void changed() {
        notifySubscribers();
    }




}
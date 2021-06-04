package app.controller;

import app.domain.model.Company;
import app.domain.model.Store;

import java.io.*;
import java.util.List;

public class FileController {

    Company company;

    List<Store> stores;

    public FileController ()  {
        this.company = App.getInstance().getCompany();
        this.stores = this.company.getListStores();
    }

    public void runFileInputStreams() {
        try {
            for (Store store : this.stores) {
                String fileName = store.getFileName();
                FileInputStream iFile = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(iFile);
                while (iFile.available() > 0) {

                    Object o = in.readObject();
                    if(o != null) {
                        store.importObject(o);
                    }
                }
                in.close();
                iFile.close();
                System.out.println("\nFile: " + fileName + " imported successfully.");
            }
        }catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

    }

    public void runFileOutputStreams() throws IOException {
        for (Store store : this.stores) {
            String fileName = "ser/" + store.getObjectName() + ".txt";
            File writeFile = new File(fileName);
            writeFile.createNewFile();
            FileOutputStream oFile = new FileOutputStream(writeFile,false);
            ObjectOutputStream out = new ObjectOutputStream(oFile);
            for (Object o : store.getListObjects()){
                out.writeObject(o);
            }
            out.close();
            System.out.println("\nFile: " + fileName + " exported successfully.");
        }
    }

}

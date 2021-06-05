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

            for (Store store : this.stores) {
                String fileName = store.getFileName();
                try{
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
                    System.out.println("File: " + fileName + " imported successfully.");
                }catch (EOFException eof) {
                    System.out.println("File: " + fileName + " is empty.");
                }catch (IOException i) {
                    System.out.println("File: " + fileName + " is missing.");
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    return;
                }catch (IllegalArgumentException i) {
                    System.out.println("Error importing client, already exists.");
                }

            }

    }

    public void runFileOutputStreams() throws IOException {
        for (Store store : this.stores) {
            try{
                String fileName = store.getFileName();
                File writeFile = new File(fileName);
                writeFile.createNewFile();
                FileOutputStream oFile = new FileOutputStream(writeFile,false);
                ObjectOutputStream out = new ObjectOutputStream(oFile);
                for (Object o : store.getListObjects()){
                    if (o != null){
                        out.writeObject(o);
                    }
                }
                out.close();
                System.out.println("File: " + fileName + " exported successfully.");
            }catch (NullPointerException n) {
                n.printStackTrace();
            } catch (IllegalArgumentException i) {

            }
        }
    }

}

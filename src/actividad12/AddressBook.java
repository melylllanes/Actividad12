/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author melissa.a.lopez
 */
public class AddressBook implements Serializable {

    static HashMap<String, String> contacto = new HashMap<>();

    static File file = new File(System.getProperty("user.dir") + "/src/contactos.csv");

    public static void list() {

        if (contacto.isEmpty() == true) {
            System.out.println("No hay ningun contacto guardado.");

        }

        contacto.keySet().forEach((i) -> {
            System.out.println("Telefono: " + i + " Nombre: " + contacto.get(i));

        });
    }

    public static HashMap<String, String> create(String telefono, String nombre) {

        contacto.put(telefono, nombre);

        return contacto;
    }

    public static HashMap<String, String> delete(String telefono) {

        if (contacto.containsKey(telefono)) {
            System.out.println("Contacto borrado.");

        } else {
            System.out.println("No existe el contacto que introdujo.");
        }

        contacto.remove(telefono);
        return contacto;
    }

    public static void load() throws IOException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(contacto);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//String eol = System.getProperty("line.separator");

    /*try (Writer writer = new FileWriter(file,true)) {
            //BufferedWriter bw = new BufferedWriter(writer);

            for (Map.Entry<String, String> entry : contacto.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);

              
            }

           // bw.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }*/
    public static void save() throws IOException {

        /*try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }*/
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author melissa.a.lopez
 */
public class AddressBook {

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

    public static void load() {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }

    }

    public static void save() throws IOException {

        String eol = System.getProperty("line.separator");

        try (FileWriter writer = new FileWriter(file)) {
            PrintWriter pw = new PrintWriter(writer);

            contacto.entrySet().forEach((entry) -> {
                pw.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);
            });

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

}

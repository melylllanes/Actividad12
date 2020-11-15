/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author melissa.a.lopez
 */
public class Actividad12 {

    public static void showMenu() throws IOException {

        Scanner input = new Scanner(System.in);
        boolean resValida = false;
        String res = null;
        String nombre;
        String telefono;

        while (!resValida || "Y".equals(res) || "y".equals(res)) {

            System.out.println("--Contactos--");
            System.out.println("1. Mostrar contactos.");
            System.out.println("2. Crear un nuevo contacto.");
            System.out.println("3. Borrar un contacto.");
            System.out.println("0. Salir.");
            System.out.print("Escoge una opcion:");
            String opcion = input.nextLine();
            System.out.println("-----------------------------------------------------------------------");

            switch (opcion) {
                case "1":
                    AddressBook.list();
                    System.out.println("-----------------------------------------------------------");
                    break;
                case "2":
                    System.out.print("Introduce el Nombre del contacto: ");
                    nombre = input.nextLine();
                    System.out.print("Introduce el telefono del contacto: ");
                    telefono = input.nextLine();
                    AddressBook.create(telefono, nombre);
                    System.out.println("-----------------------------------------------------------");
                    AddressBook.load();
                    AddressBook.save();

                    break;
                case "3":
                    System.out.print("Introduce el telefono que deseas borrar: ");
                    telefono = input.nextLine();
                    AddressBook.delete(telefono);
                    System.out.println("-----------------------------------------------------------");
                    AddressBook.load();
                    AddressBook.save();

                    break;
                case "0":
                    resValida = true;
                    break;
                default:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("**Opcion NO valida**");
                    System.out.println("Introduzca una opcion VALIDA");
                    System.out.println("-----------------------------------------------------------");

            }

        }

    }

    public static void main(String[] args) throws IOException {
        showMenu();
    }

}

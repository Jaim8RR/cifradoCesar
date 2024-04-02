/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cifradocesar;

import java.util.Scanner;

/**
 *
 * @author dev
 */
public class CifradoCesar {

    /**
     * @param args the command line arguments
     */
    static Scanner scFile;
    static int desplazamiento;
    public static void main(String[] args) {
        menu();
  
        
    }

    private static void menu() {
           Scanner sc;
           int opcion;
        do {
                  System.out.println("Que quieres hacer?");
        System.out.println("1.- Cifrar");
        System.out.println("2.- Descifrar con clave");
        System.out.println("2.- Descifrar sin clave");
        sc = new Scanner(System.in);
        opcion = Integer.parseInt(sc.nextLine());
        } while (opcion!=1||opcion!=2||opcion!=3);
  
        
        
    }
    
}

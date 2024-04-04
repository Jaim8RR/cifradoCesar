/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cifradocesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ## Resolucion del los Ejercicios 10,11 y 12.
 *
 * ### 10.- Cifrado César (https://es.wikipedia.org/wiki/Cifrado_C%C3%A9sar) En
 * criptografía, el cifrado César, también conocido como cifrado por
 * desplazamiento, código de César o desplazamiento de César, es una de las
 * técnicas de cifrado más simples y más usadas. Es un tipo de cifrado por
 * sustitución en el que una letra en el texto original es reemplazada por otra
 * letra que se encuentra un número fijo de posiciones más adelante en el
 * alfabeto. Por ejemplo, con un desplazamiento de 3, la A sería sustituida por
 * la D (situada 3 lugares a la derecha de la A), la B sería reemplazada por la
 * E, etc. Este método debe su nombre a Julio César, que lo usaba para
 * comunicarse con sus generales. Haz un programa java que recoja como
 * parámetros de su método main, un primer parámetro con un fichero de texto, y
 * posteriormente un número (que se corresponderá con el desplazamiento para el
 * cifrado). Este programa deberá cifrar el texto y con el resultado escribir un
 * fichero nuevo (con el mismo nombre pero con extensión .cfr).
 *
 * ### 11.- Descifrado César Haz un programa java que reciba como parámetros un
 * fichero de texto y un desplazamiento. Deberá realizar el descifrado y enviar
 * el resultado a un fichero (con el mismo nombre pero con extensión .uncfr).
 *
 * ### 12.- Descifrado César sin clave Igual que el anterior, pero sólo
 * recibirás el nombre del fichero a descifrar. Para descifrar un texto cifrado,
 * es necesario conocer el desplazamiento con el que se codificó para recuperar
 * la letra. No obstante, si no se conoce dicho desplazamiento, se puede
 * deducir. Si el texto está en español se sabe que, estadísticamente, la letra
 * que más se utiliza es la letra “e” (tanto mayúscula como minúscula). Por
 * tanto, se puede asumir que la letra que más aparece en el texto cifrado es la
 * representación de la “e” y con ello deducir el desplazamiento.
 *
 * @author dev
 */
public class CifradoCesar {

    /**
     * @param args the command line arguments
     */
    static Scanner scTerminal = new Scanner(System.in);
    static Scanner scFile = null;

    public static void main(String[] args) {
        //File file = new File(args[0]);
        File file = new File("./txt/Ejemplo.txt");
        //int desplazamiento= Integer.parseInt(args[1]);
        int desplazamiento = 3;
        menu(desplazamiento, file);

    }

    private static void menu(int desplazamiento, File file) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Que quieres hacer?");
            System.out.println("1.- Cifrar");// esto hace lo del 10
            System.out.println("2.- Descifrar con clave");// esto hace lo del 11
            System.out.println("2.- Descifrar sin clave");// esto hace lo del 12
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    cifrar(desplazamiento, file);
                    break;
                case 2:
                    descifrarConClave(desplazamiento);
                    break;
                case 3:
                    descifrarSinClave();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 1 || opcion != 2 || opcion != 3);

    }

    private static File pedirArchivo() {
        scTerminal = new Scanner(System.in);

        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = scTerminal.nextLine();

        File archivo = new File(nombreArchivo);

        return archivo;

    }

    private static void cifrar(int desplazamiento, File file) {
        Alfabeto alfabeto;
        //pedirArchivo();
        String linea;
        char letra;
        String lineaCifrada = "";
        try {
            scFile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer archivo(no se ha encontrado)");
            Logger.getLogger(CifradoCesar.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            linea = scFile.nextLine();
            for (int i = 0; i < linea.length(); i++) {
                letra = linea.charAt(i);
                alfabeto = new Alfabeto();
                for (int j = 0; j < alfabeto.getAlfabetoMin().length; j++) {
                    if (letra == alfabeto.getAlfabetoMin()[j]) {
                        System.out.println("posicion:" + (j + desplazamiento) % alfabeto.getAlfabetoMin().length);
                        lineaCifrada += alfabeto.getAlfabetoMin()[(j + desplazamiento) % alfabeto.getAlfabetoMin().length];
                        System.out.println("sumo la " + alfabeto.getAlfabetoMin()[(j + desplazamiento) % alfabeto.getAlfabetoMin().length]);
                    } else if (letra == alfabeto.getAlfabetoMay()[j]) {
                        System.out.println("posicion:" + (j + desplazamiento) % alfabeto.getAlfabetoMay().length);
                        lineaCifrada += alfabeto.getAlfabetoMay()[(j + desplazamiento) % alfabeto.getAlfabetoMay().length];
                        System.out.println("sumo la " + alfabeto.getAlfabetoMay()[(j + desplazamiento) % alfabeto.getAlfabetoMin().length]);

                    }

                }
                if (letra == ' ') {
                    System.out.println("meto un espacio");
                    lineaCifrada += ' ';
                }

            }
            lineaCifrada += "\n";
            try (FileWriter fw = new FileWriter("./txt/cifrado.txt")) {
                fw.write(lineaCifrada);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (scFile.hasNextLine());

    }

    private static void descifrarConClave(int desplazamiento) {//esto hace lo del 11
        String linea;
        char letra;
        File descifrado = new File("./txt/descifrado.txt");
        File cifrado = new File("./txt/cifrado.txt");
        String lineaDescifrada = "";
        Alfabeto alfabeto;
        try {
            scFile = new Scanner(cifrado);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer archivo(no se ha encontrado)");
            Logger.getLogger(CifradoCesar.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            linea = scFile.nextLine();
            for (int i = 0; i < linea.length(); i++) {
                letra = linea.charAt(i);
             alfabeto = new Alfabeto();
                for (int j = 0; j < alfabeto.getAlfabetoMin().length; j++) {
                    if (letra == alfabeto.getAlfabetoMin()[j]) {
                        if (j - desplazamiento < 0) {
                            lineaDescifrada += alfabeto.getAlfabetoMin()[j + desplazamiento % alfabeto.getAlfabetoMin().length];
                        }
                        if (j - desplazamiento > 0) {
                            lineaDescifrada += alfabeto.getAlfabetoMin()[j - desplazamiento % alfabeto.getAlfabetoMin().length];
                        }

                    } else if (letra == alfabeto.getAlfabetoMay()[j]) {
                        if (j - desplazamiento < 0) {
                            lineaDescifrada += alfabeto.getAlfabetoMay()[j + desplazamiento % alfabeto.getAlfabetoMay().length];

                        }
                        if (j - desplazamiento > 0) {
                            lineaDescifrada += alfabeto.getAlfabetoMay().length - j - desplazamiento % alfabeto.getAlfabetoMay().length;
                        }

                    }

                 

                }
                if (letra == ' ') {
                    System.out.println("meto un espacio");
                    lineaDescifrada += ' ';
                }

            }
            lineaDescifrada += "\n";
                try (FileWriter fw = new FileWriter(descifrado)) {
                    fw.write(lineaDescifrada);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        } while (scFile.hasNextLine());

    }

    private static void descifrarSinClave() {//deberá de descifrar con todos los desplazamientos posibles hasta encontrar el texto original contando el numero de letras e, el texto con mas e sera el texto original
        String linea;
        char letra;
        File descifrado = new File("./txt/descifrado.txt");
        File cifrado = new File("./txt/cifrado.txt");
        String lineaDescifrada = "";
        Alfabeto alfabeto = new Alfabeto();
        int contadorE = 0;
        int contadorMaxE = 0;
        int desplazamientoEncontrado = 0;
        try {
            scFile = new Scanner(cifrado);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer archivo(no se ha encontrado)");
            Logger.getLogger(CifradoCesar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < alfabeto.getAlfabetoMay().length; i++) {
            descifrarConClave(i);
            do {
                try {
                    scFile = new Scanner(descifrado);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                do {
                    linea = scFile.nextLine();
                    for (int j = 0; j < linea.length(); j++) {
                        letra = linea.charAt(j);
                        if (letra == 'e' || letra == 'E') {
                            contadorE++;
                        }
                    }
                } while (scFile.hasNext());
                if (contadorE > contadorMaxE) {
                    contadorMaxE = contadorE;
                    contadorE = 0;
                    desplazamientoEncontrado = i;
                }

            } while (scFile.hasNext());

        }
        descifrarConClave(desplazamientoEncontrado);
    }

}

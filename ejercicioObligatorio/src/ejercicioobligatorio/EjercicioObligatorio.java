package ejercicioobligatorio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EjercicioObligatorio {

    /**
     * @param args the command line arguments
     */
    private static void mostrarLista(Socio[] socios) {
        for (int i = 0; i < socios.length; i++) {
            System.out.println(socios[i].toString());
        }
    }

    public static void main(String[] args) {
        int opcion = 8;
        Scanner teclado = new Scanner(System.in);

        Socio[] socios = new Socio[5];

        socios[0] = new Socio(130, "Pedro", "21-11-1984");
        socios[1] = new Socio(14, "Fedro", "12-01-1987");
        socios[2] = new Socio(15, "Cedro", "12-01-1986");
        socios[3] = new Socio(116, "Dedro", "12-01-1985");
        socios[4] = new Socio(12, "Zedro", "12-03-1984");

        //Comparadores
        //Comparador por edad. 9.19
        Comparator<Socio> comparadorA = (sa, sb) -> sa.edad().compareTo(sb.edad());
        //Compara menor socio, misma edad. 9.20
        Comparator<Socio> comparadorB = comparadorA.thenComparing((sa, sb) -> sa.getId().compareTo(sb.getId()));
        //Ordena por fecha de nacimiento. 9.21
        Comparator<Socio> comparadorC = (sa, sb) -> sa.getFechaNacimiento().compareTo(sb.getFechaNacimiento());
        //Ordena alfabéticamente. 9.22
        Comparator<Socio> comparadorD = (sa, sb) -> sa.getNombre().compareTo(sb.getNombre());

        do {

            //Menu
            
            System.out.println("Elija una opción del menu");
            System.out.println("1. Lista sin ordenar.");
            System.out.println("2. Ordenada por edad:");
            System.out.println("3. Ordenada por ID de socio en caso de igualdad de edad");
            System.out.println("4. Ordenada por fecha de nacimiento");
            System.out.println("5. Lista ordenada por orden alfabético");
            System.out.println("6. Lista ordenada por orden alfabético inverso");
            System.out.println("0. Salir.");

            opcion = teclado.nextInt();
            while (opcion > 7 || opcion < 0) {
                System.out.println("Introduzca una opción valida.");
                opcion = teclado.nextInt();
            }
            switch (opcion) {
                case 1 -> {

                    //Mostrar sin ningún patrón de ordenación.
                    System.out.println("---------------------------------\n");
                    System.out.println("Lista sin ordenar.\n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
                case 2 -> {

                    Arrays.sort(socios, comparadorA);
                    System.out.println("---------------------------------\n");
                    System.out.println("Lista ordenada por edad.\n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
                case 3 -> {

                    Arrays.sort(socios, comparadorB);
                    System.out.println("---------------------------------\n");
                    System.out.println("Lista ordenada por ID de socio en caso de igualdad de edad.\n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
                case 4 -> {

                    Arrays.sort(socios, comparadorC);
                    System.out.println("---------------------------------\n");
                    System.out.println("Lista ordenada por fecha de nacimiento \n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
                case 5 -> {

                    Arrays.sort(socios, comparadorD);
                    System.out.println("---------------------------------\n");
                    System.out.println("Lista ordenada por orden alfabético \n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
                case 6 -> {
                    //Ordena alfabéticamente de manera inversa. 9.23
                    System.out.println("---------------------------------\n");
                    Arrays.sort(socios, comparadorD.reversed());
                    System.out.println("Lista ordenada por orden alfabético inverso \n");
                    mostrarLista(socios);
                    System.out.println("---------------------------------\n");
                }
            }
        } while (opcion != 0);
    }
}

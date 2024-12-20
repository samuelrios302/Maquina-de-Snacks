package maquinaSnacks;

import maquinaSnacks.Snack;
import maquinaSnacks.Snacks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    static Scanner entrada = new Scanner(System.in);
    static List<Snack> listaSnacksComprados = new ArrayList<>();

    public static int inputIdSnack() {
        int idSnack = 0;
        try {
            System.out.print("\nIngrese el ID del Snack a comprar: ");
            idSnack = entrada.nextInt();
        }
        catch (Exception e) {
            System.out.println("\nError, vuelve a intentarlo = " + e);
            inputIdSnack();
        }
        finally {
            return idSnack;
        }
    }

    public static int opcion_menu(){
        int opcion = 0;
        try {
            System.out.print("Mi opcion es: ");
            opcion = entrada.nextInt();

            if  (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
                System.out.println("\nOpcion no valida\n");
                menu();
            }
        }
        catch (Exception e) {
            System.out.println("\nOpcion no valida del menú\n");
            menu();
        }
        finally {
            return opcion;
        }
    }

    public static int menu(){
       System.out.println("\n*** Maquina de Snacks ***\n");
       Snacks.mostrarSnacks();
        System.out.println("""
                \n1. Comprar Snack.
                2. Visualizar Ticket.
                3. Agregar nuevo snack
                4. Salir del menú
                """);
       var opcion = MaquinaSnacks.opcion_menu();
       return opcion;
    }


    public static void comprarSnacks() {
        var idSnack = inputIdSnack();
        List<Snack> listaSnacks = Snacks.getListaSnaks();
        boolean isComprado = false;
        for (Snack snack : listaSnacks) {
            if (snack.getIdSnack() == idSnack) {
                isComprado = true;
                MaquinaSnacks.listaSnacksComprados.add(snack);
                break;
            }
        }

        if (isComprado) {
            System.out.println("\nProducto agregado con exito!\n");
            entrada.nextLine();
            entrada.nextLine();
            limpiarConsola();
        }
        else {
            System.out.println("\nNo se puede agregar un producto no existente\n");
            entrada.nextLine();
            entrada.nextLine();
            limpiarConsola();
        }


    }

    public static void mostrarTicket(){
        int total = 0;
        System.out.println("\nProducto  Precio\n");
        for (Snack snack : MaquinaSnacks.listaSnacksComprados) {
            System.out.println(snack.getNombreSnack() + "    $" + snack.getPrecioSnack());
            total += snack.getPrecioSnack();
        }

        System.out.println("\nTotal: $" + total);

        entrada.nextLine();
        entrada.nextLine();
        limpiarConsola();
    }
    
    public static void agregarProducto(){
        System.out.print("Ingrese el nombre del producto: ");
        entrada.nextLine();
        String nombre = entrada.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        int precio = Integer.parseInt(entrada.nextLine());


        var producto = new Snack(nombre,precio);
        Snacks.agregarSnackMaquina(producto);

        entrada.nextLine();
        limpiarConsola();
    }

    public static void ejecutarAcciones() {
        int opcion = 0;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:

                    Snacks.mostrarSnacks();
                    MaquinaSnacks.comprarSnacks();
                    break;
                case 2:
                    MaquinaSnacks.mostrarTicket();
                    break;
                case 3:
                    MaquinaSnacks.agregarProducto();
                    break;
                case 4:
                    System.out.println("\nEl programa se cerrará!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpcion no valida\n");
                    break;
            }
        } while (opcion != 4);
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Imprime líneas en blanco
        }
    }

    public static void main(String[] args) {
        try {
            ejecutarAcciones();
        }
        catch (Exception e) {
            System.out.println("Algo pasó: "+ e);
        }
    }
}

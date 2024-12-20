package maquinaSnacks;

import maquinaSnacks.Snack;
import maquinaSnacks.Snacks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    static Scanner entrada = new Scanner(System.in);
    // Lista para almacenar todos los snacks comprados
    static List<Snack> listaSnacksComprados = new ArrayList<>();

    // Ingreso de un ID valida de Snack
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

    // Opcion valida del menu (Falta por corregir)
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

    // Menu de opciones
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

    // Metodo para comprar Snacks
    public static void comprarSnacks() {
        var idSnack = inputIdSnack();
        // Obtenemos todos los snaks que contiene la maquina
        List<Snack> listaSnacks = Snacks.getListaSnaks();
        boolean isComprado = false;
        for (Snack snack : listaSnacks) {
            // Si el id ingresado corresponde a un snack ya registrado, lo agregamos a la lista de snacks comprados
            if (snack.getIdSnack() == idSnack) {
                isComprado = true;
                MaquinaSnacks.listaSnacksComprados.add(snack); // Agregamos
                break;
            }
        }

        // Mensajes si se completaron las opciones o no

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

    // Mostramos el ticket de compra de todos los snacks
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

    // Metodo para agregar productos nuevos a la maquina de Snacks
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

    // Metodo de la logica del programa
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

    // Metodo para "limpiar" consola
    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Imprime líneas en blanco
        }
    }

    // Metodo principal
    public static void main(String[] args) {
        try {
            ejecutarAcciones();
        }
        catch (Exception e) {
            System.out.println("Algo pasó: "+ e);
        }
    }
}

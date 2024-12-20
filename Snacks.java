package maquinaSnacks;

import java.util.ArrayList;
import java.util.List;
import maquinaSnacks.Snack;

public class Snacks {
    // Lista para almacenar los snacks que se registren
    private static List<Snack> listaSnaks = new ArrayList<>();

    // Metodo para agregar un snack a la maquina
    public static void agregarSnackMaquina(Snack snack) {
        Snacks.listaSnaks.add(snack);
        System.out.println("\nProducto registrado correctamente!\n");
    }

    // Metodo para mostrar los snacks
    public static void mostrarSnacks(){
        System.out.println("\nSnacks En Inventario\n");
        for (Snack snack : Snacks.listaSnaks) {
            System.out.println(snack);
        }
    }

    // Metodo para obtener la lista de los snacks en maquina
    public static List getListaSnaks() {
        return Snacks.listaSnaks;
    }


}

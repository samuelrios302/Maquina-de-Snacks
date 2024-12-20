package maquinaSnacks;

import java.util.ArrayList;
import java.util.List;
import maquinaSnacks.Snack;

public class Snacks {
    private static List<Snack> listaSnaks = new ArrayList<>();

    public static void agregarSnackMaquina(Snack snack) {
        Snacks.listaSnaks.add(snack);
        System.out.println("\nProducto registrado correctamente!\n");
    }

    public static void mostrarSnacks(){
        System.out.println("\nSnacks En Inventario\n");
        for (Snack snack : Snacks.listaSnaks) {
            System.out.println(snack);
        }
    }

    public static List getListaSnaks() {
        return Snacks.listaSnaks;
    }


}

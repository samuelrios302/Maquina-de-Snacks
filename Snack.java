package maquinaSnacks;

import java.util.Objects;

public class Snack {
    private static int contadorSnacks;
    private int idSnack;
    private String nombreSnack;
    private int precioSnack;

    public Snack(String nombre, int precio) {
        this.idSnack = (++Snack.contadorSnacks);
        this.nombreSnack = nombre;
        this.precioSnack = precio;
    }

    public int getIdSnack() {
        return this.idSnack;
    }

    public void setNombreSnack(String nombre) {
        this.nombreSnack = nombre;
    }

    public String getNombreSnack() {
        return this.nombreSnack;
    }

    public void setPrecioSnack(int precio) {
        this.precioSnack = precio;
    }

    public int getPrecioSnack() {
        return this.precioSnack;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + idSnack +
                ", nombreSnack='" + nombreSnack + '\'' +
                ", precioSnack=" + precioSnack +
                '}';
    }

}

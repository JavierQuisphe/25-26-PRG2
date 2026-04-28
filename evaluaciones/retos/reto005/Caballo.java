public class Caballo {
    private String nombre;
    private int posicion;

    public Caballo(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
    }

    public void avanzar(int casillas) {
        this.posicion += casillas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }
}
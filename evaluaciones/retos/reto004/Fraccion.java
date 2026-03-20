public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion (int numerador, int denominador) {}
    public Fraccion (int numero){}
    public Fraccion (Fraccion fraccion){}
    public Fraccion(){}

    public Fraccion clonar(){

    }

    public void sumar(Fraccion fraccion){}
    public void restar(Fraccion fraccion){}
    public void multiplicar(Fraccion fraccion){}
    public void dividir(Fraccion fraccion){}
    public void potenciar(int exponente){}

    public boolean esMayor(){}
    public boolean esMenor(){}
    public boolean equals(){}

    public void mostrar(){}

    public void invertir(){}
    public void oponer(){}

    public void simplificar(){}

    public int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }
}
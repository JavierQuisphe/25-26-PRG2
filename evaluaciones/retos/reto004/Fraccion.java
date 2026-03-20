public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion (int numerador, int denominador) {
        this.numerador   = numerador;
        this.denominador = denominador;
    }
    public Fraccion (int numero){
        this(numero, 1);
    }
    public Fraccion (Fraccion fraccion){
        this(fraccion.numerador, fraccion.denominador);
    }
    public Fraccion(){
        this(0, 1);
    }

    public Fraccion clonar(){
        return new Fraccion(this);
    }

    public void sumar(Fraccion fraccion){
        this.numerador   = this.numerador * fraccion.denominador
                         + fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
    }
    public void restar(Fraccion fraccion){
        this.numerador   = this.numerador * fraccion.denominador
                         - fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
    }
    public void multiplicar(Fraccion fraccion){
        this.numerador   = this.numerador   * fraccion.numerador;
        this.denominador = this.denominador * fraccion.denominador;
    }
    public void dividir(Fraccion fraccion){
        this.numerador   = this.numerador   * fraccion.denominador;
        this.denominador = this.denominador * fraccion.numerador;
    }
    public void potenciar(int exponente){
        if (exponente == 0) {
            this.numerador   = 1;
            this.denominador = 1;
        } else if (exponente > 0) {
            int baseNum = this.numerador;
            int baseDen = this.denominador;
            for (int i = 1; i < exponente; i++) {
                this.numerador   *= baseNum;
                this.denominador *= baseDen;
            }
        }
    }

    public boolean esMayor(Fraccion fraccion){
        return this.numerador * fraccion.denominador
             > fraccion.numerador * this.denominador;
    }
    public boolean esMenor(Fraccion fraccion){
        return this.numerador * fraccion.denominador
             < fraccion.numerador * this.denominador;
    }
    public boolean equals(Fraccion fraccion){
        return this.numerador   == fraccion.numerador
            && this.denominador == fraccion.denominador;
    }

    public void mostrar(){
        System.out.println(numerador + "/" + denominador);
    }

    public void invertir(){
        int temporal = this.numerador;
        this.numerador   = this.denominador;
        this.denominador = temporal;
    }
    public void oponer(){
        this.numerador = -this.numerador;
    }

    public void simplificar(){
        int mcd = calcularMCD(Math.abs(numerador), denominador);
        this.numerador   = this.numerador   / mcd;
        this.denominador = this.denominador / mcd;
    }

    public int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }
}

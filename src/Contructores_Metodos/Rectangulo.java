package Contructores_Metodos;

public class Rectangulo {
    int base;
    int altura;

    public Rectangulo(int base, int altura){
        this.base = base;
        this.altura= altura;
    }

    int calcularArea(){
        return  base * altura;
    }

    int calcularPerimetro(){
         return  (2*base) + (2*altura);

    }

    void mostrar(){
        System.out.println("---Rectangulo----");
        System.out.println("Base: " + base);
        System.out.println("Altura " + altura);
        System.out.println("Area " + calcularArea());
        System.out.println("Perimetro " + calcularPerimetro());
    }
    public static void main(String[] args) {
        Rectangulo figura = new Rectangulo(24, 67);
        figura.mostrar();
    }
}

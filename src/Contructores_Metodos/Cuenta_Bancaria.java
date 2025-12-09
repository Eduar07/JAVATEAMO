package Contructores_Metodos;

public class Cuenta_Bancaria {

    String titular;
    int numeroCuenta;
    double saldo;


    public Cuenta_Bancaria(){
        titular = "Eduar Humberto Guerero vergel";
        numeroCuenta = 0000000006;
        saldo = 1000;
    }

    void depositar(double cantidad){
        saldo = saldo + cantidad;
        System.out.println("El valor depositado fue: " + cantidad);
    }
    void retirar(double cantidad){
        saldo = saldo - cantidad;
        if(cantidad>saldo){
            System.out.println("No tienes saldo suficiente");
        }else{
            System.out.println("El valor retirado es " + cantidad);
        }
    }

    void mostrarSaldo(){
        System.out.println("EL nombre del titular es :" + titular);
        System.out.println("EL numero de cuenta es :" + numeroCuenta);
        System.out.println("EL saldo es :" + saldo);

    }

    public static void main(String[] args) {
  Cuenta_Bancaria cliente = new Cuenta_Bancaria();
  cliente.mostrarSaldo();
  cliente.depositar(50000);
  cliente.mostrarSaldo();
  cliente.retirar(20000);
  cliente.mostrarSaldo();
    }
}



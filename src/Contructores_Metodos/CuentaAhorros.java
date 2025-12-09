package Contructores_Metodos;

public class CuentaAhorros {
    String titular;
    double saldo;
    double tasaIntereses;



    public  CuentaAhorros(String titular, double saldo, double tasaIntereses ){
        this.titular = titular;
        this.saldo = saldo;
        this.tasaIntereses = tasaIntereses;
    }

    void depositar(double cantidad){
        saldo = saldo + cantidad;
        System.out.println("EL cliente ha depositado " + cantidad);
        System.out.println("EL nuevo saldo del cliente es " + saldo);
    }

    void retirar(double quitar){
        if(quitar > saldo){
            System.out.println("No tienes saldo suficiente para retirar ese deposito");
        }else{
            saldo = saldo - quitar;
            System.out.println("Retirastes: $" + quitar);
            System.out.println(("Nuevo saldo: $ " + saldo));
        }
    }

    void aplicarintereses(){
        double interes = saldo * tasaIntereses/ 100;
        saldo = saldo + interes;
        System.out.println("El interes aplicado es: " + interes);
        System.out.println("NUevo saldo: $ " + saldo);
    }

    void mostrarinformacion(){
        System.out.println("EL nombre del titular es " + titular);
        System.out.println("Saldo actual: $ " + saldo);
        System.out.println("EL interses es: " + tasaIntereses);
    }
    public static void main(String[] args) {
        CuentaAhorros Banco = new CuentaAhorros("eduar guerrero", 2300000, 5);
        Banco.mostrarinformacion();
        Banco.retirar(1000000000);
        Banco.depositar(250000);
        System.out.println("--- Aplicando interés mensual (Mes 1) ---");
        Banco.aplicarintereses();
        System.out.println("--- Aplicando interés mensual (Mes 2) ---");
        Banco.aplicarintereses();
        System.out.println("--- Aplicando interés mensual (Mes 3) ---");
        Banco.aplicarintereses();
        System.out.println("--- ESTADO FINAL DESPUÉS DE 3 MESES ---");
        Banco.mostrarinformacion();



    }

}

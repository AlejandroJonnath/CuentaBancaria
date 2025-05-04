package org.Clase1;

// CuentaAhorros hereda de CuentaBancaria
public class CuentaAhorro extends CuentaBancaria {
    // Atributo que indica si la cuenta está activa o no
    private boolean activa;

    // Constructor que recibe el saldo inicial y la tasa anual
    public CuentaAhorro(float saldoInicial, float tasaAnual) {
        // Llama al constructor de la clase padre (CuentaBancaria)
        super(saldoInicial, tasaAnual);

        // Determina si la cuenta está activa: si saldo >= 50, es activa
        this.activa = saldoInicial >= 50;
    }

    // Método sobrescrito para depositar dinero
    @Override
    public void depositar(float cantidad) {
        // Solo se permite el depósito si la cuenta está activa
        if (!activa) {
            System.out.println("Cuenta inactiva. No se puede depositar.");
            return; // Termina la función
        }
        // Si está activa, invoca al método depositar de la clase padre
        super.depositar(cantidad);
    }

    // Método sobrescrito para retirar dinero
    @Override
    public void retirar(float cantidad) {
        // Solo se permite el retiro si la cuenta está activa
        if (!activa) {
            System.out.println("Cuenta inactiva. No se puede retirar.");
            return; // Termina la función
        }
        // Si está activa, invoca al método retirar del padre
        super.retirar(cantidad);
    }

    // Método sobrescrito para generar el extracto mensual
    @Override
    public void extractoMensual() {
        // Si se realizaron más de 4 retiros, se cobra $10 por cada retiro adicional
        if (numRetiros > 4) {
            int retirosExtra = numRetiros - 4; // Calcula cuántos retiros extra hay
            comisionMensual += retirosExtra * 10; // Suma a la comisión mensual
        }

        // Llama al método extractoMensual de la clase padre
        super.extractoMensual();

        // Actualiza el estado de la cuenta según el saldo actual
        activa = saldo >= 50;
    }

    // Método sobrescrito para mostrar información de la cuenta
    @Override
    public void mostrarCuenta() {
        // Llama al método mostrarCuenta de la clase padre
        super.mostrarCuenta();

        // Muestra si la cuenta está activa usando operador ternario
        System.out.println("¿Cuenta activa?: " + (activa ? "Sí" : "No"));
    }
}

package org.Clase1;

// CuentaCorriente hereda de CuentaBancaria
public class CuentaCorriente extends CuentaBancaria {
    // Atributo nuevo: sobregiro permitido (inicia en 0)
    private float sobregiro = 0;

    // Constructor que recibe saldo inicial y tasa anual
    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        // Llama al constructor del padre
        super(saldoInicial, tasaAnual);
    }

    // Método sobrescrito para retirar dinero
    @Override
    public void retirar(float cantidad) {
        // Si hay suficiente saldo, se retira normalmente
        if (cantidad <= saldo) {
            saldo -= cantidad; // Resta directamente del saldo
        } else {
            // Si no hay suficiente saldo, se permite sobregiro
            float diferencia = cantidad - saldo; // Lo que falta
            sobregiro += diferencia; // Se acumula en sobregiro
            saldo = 0; // Se deja el saldo en cero
        }
        numRetiros++; // Aumenta el contador de retiros
    }

    // Método sobrescrito para depositar dinero
    @Override
    public void depositar(float cantidad) {
        // Si hay sobregiro, se debe cubrir primero
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                // Si el depósito alcanza para cubrir sobregiro
                cantidad -= sobregiro; // Resta el sobregiro al depósito
                sobregiro = 0; // Se elimina el sobregiro
                saldo += cantidad; // Lo que sobra se suma al saldo
            } else {
                // Si el depósito no alcanza, solo reduce el sobregiro
                sobregiro -= cantidad;
            }
        } else {
            // Si no hay sobregiro, se deposita normalmente
            saldo += cantidad;
        }
        consignaciones++; // Aumenta el contador de consignaciones
    }

    // Método sobrescrito para generar extracto mensual
    @Override
    public void extractoMensual() {
        // Usa la lógica general del extracto de la clase padre
        super.extractoMensual();
    }

    // Método exclusivo para imprimir información completa
    public void imprimir() {
        System.out.println("Saldo: " + saldo); // Muestra el saldo
        System.out.println("Comisión mensual: " + comisionMensual); // Muestra comisión
        System.out.println("Total de transacciones: " + (consignaciones + numRetiros)); // Suma de depósitos y retiros
        System.out.println("Sobregiro actual: " + sobregiro); // Muestra el sobregiro
    }
}

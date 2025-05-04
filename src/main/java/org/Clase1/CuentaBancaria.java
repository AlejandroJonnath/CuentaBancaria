package org.Clase1;

/*
1)	Desarrollar un programa un Java que modele una cuenta bancaria mediante POO esta clase va a tener los siguientes atributos,
    que tiene que ser de acceso protegido.

o	Saldo, tipo float
o	Numero de consignaciones con valor inicial 0, tipo int
o	Número de retiros con valor inicial 0, tipo int
o	Tasa anual de interés(porcentaje), tipo flotante
*/
public class CuentaBancaria {
    protected float saldo; //Creamos el Saldo
    protected int consignaciones = 0; //Creamos las consignaciones empezadas en 0
    protected int numRetiros= 0; //Creamos los números de retiros empezados en 0
    protected float tasaAnual; //Creamos la tasa anual
    protected float comisionMensual = 0; //Creamos la comisión mensual empezada en 0

//2) La clase Cuenta tiene un constructor que inicializa los atributos saldo y tasa anual con valores pasados como parámetros
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo= saldo;
        this.tasaAnual= tasaAnual;
    }
    //Método para poder hacer el depósito
    //Verificación que no se pueda depositar 0 o números negativos
    public void depositar(float cantidad) {
        if (cantidad <= 0) { //Valida primero la cantidad
            System.out.println("Deposita de 0.1 centavos en adelante");
            return;
        }
        saldo = saldo + cantidad; //Actualiza el saldo
        consignaciones++; //Añadimos las consignaciones por cada depósito
    }

    //Método para poder retirar dinero del Banco
    public void retirar(float cantidad) {
        if (cantidad <= 0) {  //Verificamos si la cantidad es menor a 0 o 0
            System.out.println("No puedes retirar este tipo de productos");
            return;
        }
        if (cantidad > saldo) { //Si la cantidad es mayor al saldo, entonces se aplica
            System.out.println("No puedes retirar plata que no tienes");
            return;
        }
        saldo = saldo - cantidad; //Se actualiza el saldo
        numRetiros++;
    }

    //Método para calcular el porcentaje de interés mensual y actualizar el saldo
    public void calcularInteresMensual() {
        float tasaMensual = tasaAnual / 12; //Dividir para 12 porque quiero ver mensual
        float interesMensual = saldo * tasaMensual; //Creamos el interés mensual haciendo la operación
        saldo = saldo + interesMensual; //Añadimos el interés al saldo
    }


    public void extractoMensual() {
        saldo = saldo - comisionMensual;
        calcularInteresMensual();
    }


    //Creamos el método mostrarCuenta() para poder mostrar los datos como saldo, consig, retiros, tasa anual y comisión
    public void mostrarCuenta(){
        System.out.println("El saldo es: " + saldo);
        System.out.println("Consignaciones: " + consignaciones);
        System.out.println("Numero de retiros: " + numRetiros);
        System.out.println("Tasa Anual: " + tasaAnual);
        System.out.println("Comision Mensual: " + comisionMensual);
    }

}




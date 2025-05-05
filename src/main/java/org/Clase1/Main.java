package org.Clase1;

import java.util.Scanner; // Sirve para que el usuario escriba

/*
Realiza un método main que implemente un objeto.
Cuenta de ahorros y llame a los métodos correspondientes y de igual manera un objeto cuenta corriente todos los datos
deben ser ingresados por teclado y al elegir cada una de las opciones debe implementarse un menú.
*/

public class Main { // Clase principal donde inicia el programa
    public static void main(String[] args) { // Método main: punto de entrada de la aplicación
        Scanner scaneao = new Scanner(System.in); // Creamos un Scanner llamado 'scaneao' para leer datos del usuario

        // Declaramos dos variables para guardar las cuentas; inicialmente no apuntan a ningún objeto
        CuentaAhorro cuentaAhorros = null;  // Variable para almacenar la cuenta de ahorros
        CuentaCorriente cuentaCorriente = null; // Variable para almacenar la cuenta corriente

        int opcion; // Variable para guardar la opción seleccionada en el menú principal

        // Bucle do-while para mostrar el menú principal hasta que el usuario elija salir (opción 0)
        do {
            // Mostramos las diferentes opciones que puede elegir el usuario
            System.out.println("\n===== Banco de ITQ =====");
            System.out.println("1. Crear Cuenta de Ahorros"); // Opción 1: crear una cuenta de ahorros
            System.out.println("2. Crear Cuenta Corriente"); // Opción 2: crear una cuenta corriente
            System.out.println("3. Operar Cuenta de Ahorros"); // Opción 3: acceder al submenú de cuenta de ahorros
            System.out.println("4. Operar Cuenta Corriente"); // Opción 4: acceder al submenú de cuenta corriente
            System.out.println("0. Salir"); // Opción 0: salir del programa
            System.out.print("Opción: "); // Mensaje solicitando la opción
            opcion = scaneao.nextInt(); // Leemos la opción ingresada por el usuario

            // Evaluamos la opción elegida usando switch
            switch (opcion) {
                case 1 -> // Si elige 1, llamamos al método crearCuentaAhorros y guardamos el objeto
                        cuentaAhorros = crearCuentaAhorros(scaneao);
                case 2 -> // Si elige 2, llamamos al método crearCuentaCorriente y guardamos el objeto
                        cuentaCorriente = crearCuentaCorriente(scaneao);
                case 3 -> // Si elige 3, abrimos el submenú para operar la cuenta de ahorros
                        operarCuentaAhorro(scaneao, cuentaAhorros);
                case 4 -> // Si elige 4, abrimos el submenú para operar la cuenta corriente
                        operarCuentaCorriente(scaneao, cuentaCorriente);
                // No necesitamos case 0 porque el bucle terminará cuando opcion == 0
            }

        } while (opcion != 0); // Repite mientras la opción no sea 0 (salir)

        // Mensaje de despedida
        System.out.println("Gracias por preferirnos, atentamente clase del profe Elvis");
        scaneao.close(); // Cerramos el Scanner para liberar recursos del sistema
    }

    // ========================================================================
    // Método para crear una Cuenta de Ahorros solicitando datos al usuario
    private static CuentaAhorro crearCuentaAhorros(Scanner sc) {
        System.out.print("Saldo inicial: "); // Pedimos el saldo inicial
        float saldo = sc.nextFloat(); // Leemos el saldo ingresado
        System.out.print("Tasa anual (%): "); // Pedimos la tasa anual de interés
        float tasa = sc.nextFloat(); // Leemos la tasa ingresada
        return new CuentaAhorro(saldo, tasa); // Creamos y devolvemos la CuentaAhorro
    }

    // ========================================================================
    // Método para crear una Cuenta Corriente solicitando datos al usuario
    private static CuentaCorriente crearCuentaCorriente(Scanner sc) {
        System.out.print("Saldo inicial: "); // Pedimos el saldo inicial
        float saldo = sc.nextFloat(); // Leemos el saldo ingresado
        System.out.print("Tasa anual (%): "); // Pedimos la tasa anual de interés
        float tasa = sc.nextFloat(); // Leemos la tasa ingresada
        return new CuentaCorriente(saldo, tasa); // Creamos y devolvemos la CuentaCorriente
    }

    // ========================================================================
    // Submenú para operar sobre la Cuenta de Ahorro
    private static void operarCuentaAhorro(Scanner sc, CuentaAhorro cuenta) {
        // Verificamos si la cuenta existe (no es null)
        if (cuenta == null) {
            // Si no existe, mostramos mensaje y salimos del método
            System.out.println("Bro, para hacer eso debes crear una cuenta de Ahorros");
            return;
        }

        int opcion; // Variable para guardar la opción del submenú de ahorro
        do {
            // Mostramos el submenú de operaciones de la cuenta de ahorros
            System.out.println("\n--- Cuenta de Ahorros ---");
            System.out.println("1. Depositar"); // Opción para depositar dinero
            System.out.println("2. Retirar"); // Opción para retirar dinero
            System.out.println("3. Generar extracto"); // Opción para generar extracto mensual
            System.out.println("4. Mostrar información"); // Opción para mostrar datos de la cuenta
            System.out.println("0. Volver"); // Opción para regresar al menú principal
            System.out.print("Opción: "); // Mensaje solicitando la opción
            opcion = sc.nextInt(); // Leemos la opción ingresada

            // Evaluamos la opción ingresada
            switch (opcion) {
                case 1 -> { // Si elige depositar
                    System.out.print("Cantidad a depositar: "); // Pedimos cantidad a depositar
                    cuenta.depositar(sc.nextFloat()); // Llamamos al método depositar de la cuenta
                }
                case 2 -> { // Si elige retirar
                    System.out.print("Cantidad a retirar: "); // Pedimos cantidad a retirar
                    cuenta.retirar(sc.nextFloat()); // Llamamos al método retirar de la cuenta
                }
                case 3 -> { // Si elige generar extracto
                    cuenta.extractoMensual(); // Llamamos a extractoMensual para calcular comisiones e intereses
                    System.out.println("Extracto generado."); // Mensaje de confirmación
                }
                case 4 -> // Si elige mostrar información, llamamos a mostrarCuenta
                        cuenta.mostrarCuenta();
            }

        } while (opcion != 0); // Repite mientras la opción no sea 0
    }

    // ========================================================================
    // Submenú para operar sobre la Cuenta Corriente
    private static void operarCuentaCorriente(Scanner sc, CuentaCorriente cuenta) {
        // Verificamos si la cuenta existe (no es null)
        if (cuenta == null) {
            // Si no existe, mostramos mensaje y salimos del método
            System.out.println("Primero debe crear una cuenta corriente.");
            return;
        }

        int opcion; // Variable para guardar la opción del submenú de corriente
        do {
            // Mostramos el submenú de operaciones de la cuenta corriente
            System.out.println("\n--- Cuenta Corriente ---");
            System.out.println("1. Depositar"); // Opción para depositar dinero
            System.out.println("2. Retirar"); // Opción para retirar dinero
            System.out.println("3. Generar extracto"); // Opción para generar extracto mensual
            System.out.println("4. Mostrar información"); // Opción para mostrar datos de la cuenta
            System.out.println("0. Volver"); // Opción para regresar al menú principal
            System.out.print("Opción: "); // Mensaje solicitando la opción
            opcion = sc.nextInt(); // Leemos la opción ingresada

            // Evaluamos la opción ingresada
            switch (opcion) {
                case 1 -> { // Si elige depositar
                    System.out.print("Cantidad a depositar: "); // Pedimos cantidad a depositar
                    cuenta.depositar(sc.nextFloat()); // Llamamos al método depositar de la cuenta corriente
                }
                case 2 -> { // Si elige retirar
                    System.out.print("Cantidad a retirar: "); // Pedimos cantidad a retirar
                    cuenta.retirar(sc.nextFloat()); // Llamamos al método retirar de la cuenta corriente
                }
                case 3 -> { // Si elige generar extracto
                    cuenta.extractoMensual(); // Llamamos a extractoMensual para calcular comisiones e intereses
                    System.out.println("Extracto generado."); // Mensaje de confirmación
                }
                case 4 -> // Si elige mostrar información, llamamos a imprimir
                        cuenta.imprimir();
            }

        } while (opcion != 0); // Repite mientras la opción no sea 0
    }
}

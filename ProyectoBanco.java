/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectobanco;

/**
 *
 * @author CHEVEZ
 */
public class ProyectoBanco{
    public static void main(String[] args) {
 
        // ===== Prueba 1: Encapsulamiento =====
        System.out.println("=== Prueba 1: Encapsulamiento ===");
        CuentaBancaria miCuenta = new CuentaBancaria("001", "Carlos Lopez", 1000);
 
        // miCuenta.saldo = 50000;
        // Esta linea esta comentada porque da error de compilacion: el atributo
        // saldo es private, o sea que solo se puede usar dentro de la clase
        // CuentaBancaria. Desde Main hay que usar depositar() o retirar().
        System.out.println("Saldo (con getter): L. " + miCuenta.getSaldo());
 
        // ===== Prueba 2: Atributos publicos =====
        System.out.println();
        System.out.println("=== Prueba 2: Atributos publicos ===");
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);
 
        // ===== Prueba 3: CuentaAhorro =====
        System.out.println();
        System.out.println("=== Prueba 3: CuentaAhorro ===");
        CuentaAhorro ahorro = new CuentaAhorro("002", "Maria Perez", 3000, 5);
        ahorro.retirarConComision(100);   // retiro 1
        ahorro.retirarConComision(100);   // retiro 2
        ahorro.retirarConComision(100);   // retiro 3
        ahorro.retirarConComision(100);   // retiro 4 (aqui ya cobra comision)
        System.out.println("Saldo despues de 4 retiros: L. " + ahorro.getSaldo());
 
        // ===== Prueba 4: Interes mensual =====
        System.out.println();
        System.out.println("=== Prueba 4: Interes mensual ===");
        System.out.println("Saldo antes del interes: L. " + ahorro.getSaldo());
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo despues del interes: L. " + ahorro.getSaldo());
 
        // ===== Prueba 5: CuentaCorriente =====
        System.out.println();
        System.out.println("=== Prueba 5: CuentaCorriente ===");
        CuentaCorriente corriente = new CuentaCorriente("003", "Ana Gomez", 1000, "Tienda Ana S.A.", 5000);
        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo: L. " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado: L. " + corriente.getSobregiroUtilizado());
 
        // ===== Prueba 6: Amortizacion de deuda =====
        System.out.println();
        System.out.println("=== Prueba 6: Pagar sobregiro ===");
        corriente.pagarSobregiro(1000);
        System.out.println("Estado final -> Saldo: L. " + corriente.getSaldo());
        System.out.println("Estado final -> Sobregiro utilizado: L. " + corriente.getSobregiroUtilizado());
    }
}
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
 
       
        System.out.println("=== Prueba 1 Encapsulamionto ===");
        CuentaBancaria miCuenta = new CuentaBancaria("001", "Romel Quito", 1000);
 
       
        System.out.println("Saldo L " + miCuenta.getSaldo());
 
        
        System.out.println();
        System.out.println("=== Prueba 2 Atributos publicos ===");
        System.out.println("Titular " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);
 
       
        System.out.println();
        System.out.println("=== Prueba 3 CuentaAhorro ===");
        CuentaAhorro ahorro = new CuentaAhorro("002", "Paty Burgoz", 3000, 5);
        ahorro.retirarConComision(100);   
        ahorro.retirarConComision(100);   
        ahorro.retirarConComision(100);   
        ahorro.retirarConComision(100);   
        System.out.println("Saldo despues de 4 retiros: L " + ahorro.getSaldo());
 
        
        System.out.println();
        System.out.println("=== Prueba 4 Interes mensual ===");
        System.out.println("Saldo antes del interes L " + ahorro.getSaldo());
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo despues del interes L " + ahorro.getSaldo());
 
        
        System.out.println();
        System.out.println("=== Prueba 5 CuentaCorriente ===");
        CuentaCorriente corriente = new CuentaCorriente("003", "Milagro FLores", 1000, "Tienda Milagros S.A.", 5000);
        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo L " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado L " + corriente.getSobregiroUtilizado());
 
       
        System.out.println();
        System.out.println("=== Prueba 6 Pagar sobregiro ===");
        corriente.pagarSobregiro(1000);
        System.out.println("final Saldo L " + corriente.getSaldo());
        System.out.println(" final  Sobregiro utilizado L " + corriente.getSobregiroUtilizado());
        System.out.println("Gracias por ver :D");
    }
}
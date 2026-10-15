/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobanco;

/**
 *
 * @author CHEVEZ
 */
public class CuentaBancaria {
 
    // atributos publicos
    public String numeroCuenta;
    public String titular;
 
    // atributos privados (encapsulados)
    private double saldo;
    private int totalTransacciones;
 
    // constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
 
        // si el saldo inicial es negativo lo dejamos en 0
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
 
        this.totalTransacciones = 0;
    }
 
    // getters (para poder ver los datos privados)
    public double getSaldo() {
        return saldo;
    }
 
    public int getTotalTransacciones() {
        return totalTransacciones;
    }
 
    // depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            totalTransacciones = totalTransacciones + 1;
            System.out.println("Deposito exitoso. Monto depositado: L. " + monto);
        } else {
            System.out.println("Error: el monto a depositar debe ser mayor a 0.");
        }
    }
 
    // retirar dinero, devuelve true si se pudo y false si no
    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo = saldo - monto;
            totalTransacciones = totalTransacciones + 1;
            return true;
        } else {
            System.out.println("Error: saldo insuficiente o monto invalido.");
            return false;
        }
    }
 
    // mostrar la informacion de la cuenta
    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: L. " + saldo);
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
}
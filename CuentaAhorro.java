/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobanco;

/**
 *
 * @author CHEVEZ
 */
public class CuentaAhorro extends CuentaBancaria {
 
    // atributo publico
    public double tasaInteresAnual;
 
    // atributos privados
    private int retirosRealizadosMes = 0;
    private double comisionPorExceso = 20.0;
 
    // constructor: usa super para llamar al constructor del padre
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
    }
 
    // retiro con comision si ya se hicieron mas de 3 retiros en el mes
    public void retirarConComision(double monto) {
 
        if (retirosRealizadosMes >= 3) {
            // ya paso el limite, hay que cobrar comision
            double montoTotal = monto + comisionPorExceso;
 
            if (getSaldo() >= montoTotal) {
                retirar(montoTotal);
                retirosRealizadosMes = retirosRealizadosMes + 1;
                System.out.println("Retiro realizado con comision de L. " + comisionPorExceso);
            } else {
                System.out.println("Error: saldo insuficiente para el retiro mas la comision.");
            }
 
        } else {
            // todavia no pasa el limite, retiro normal sin comision
            boolean salioBien = retirar(monto);
 
            if (salioBien) {
                retirosRealizadosMes = retirosRealizadosMes + 1;
                System.out.println("Retiro realizado sin comision.");
            }
        }
    }
 
    // calcula el interes del mes y lo deposita
    public void aplicarInteresMensual() {
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
    }
}

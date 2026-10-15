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
 
    
    public double tasaInteresAnual;
 
    
    private int retirosRealizadosMes = 0;
    private double comisionPorExceso = 20.0;
 
   
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
    }
 

    public void retirarConComision(double monto) {
 
        if (retirosRealizadosMes >= 3) {
           
            double montoTotal = monto + comisionPorExceso;
 
            if (getSaldo() >= montoTotal) {
                retirar(montoTotal);
                retirosRealizadosMes = retirosRealizadosMes + 1;
                System.out.println("Retiro realizado con comision de l " + comisionPorExceso);
            } else {
                System.out.println("Errror saldo insuficiente para el returo mas la comesio");
            }
 
        } else {
      
            boolean salioBien = retirar(monto);
 
            if (salioBien) {
                retirosRealizadosMes = retirosRealizadosMes + 1;
                System.out.println("Retiro realizado son comisio");
            }
        }
    }
 
    
    public void aplicarInteresMensual() {
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
    }
}

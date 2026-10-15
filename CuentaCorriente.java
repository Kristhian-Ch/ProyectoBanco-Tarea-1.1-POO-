/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobanco;

/**
 *
 * @author CHEVEZ
 */
public class CuentaCorriente extends CuentaBancaria {
 
    
    public String nombreEmpresa;
 
    
    private double limiteSobregiro;
    private double sobregiroUtilizado = 0.0;
 
    
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
    }
 
    
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
 
    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }
 
   
    public void retirarConSobregiro(double monto) {
 
        if (monto <= 0) {
            System.out.println("error monto invaliido");
            return;
        }
 
        if (getSaldo() >= monto) {
           
            retirar(monto);
            System.out.println("retiro nurmal realizado");
 
        } else if (monto <= getSaldo() + (limiteSobregiro - sobregiroUtilizado)) {
            
            double diferencia = monto - getSaldo();
 
           
            if (getSaldo() > 0) {
                retirar(getSaldo());
            }
 
           
            double cargo = diferencia * 0.03;
            sobregiroUtilizado = sobregiroUtilizado + diferencia + cargo;
 
            System.out.println("retiro con sobregiro Diferencia cubierta L " + diferencia);
            System.out.println("cargo por servicio  L " + cargo);
 
        } else {
            System.out.println("error el monto excede el limite de sobregiro Operacion rechazada.");
        }
    }
 
    
    public void pagarSobregiro(double monto) {
 
        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
            return;
        }
 
        if (monto <= sobregiroUtilizado) {
          
            sobregiroUtilizado = sobregiroUtilizado - monto;
            System.out.println("Abono a la deuda de L. " + monto);
        } else {
            
            double sobrante = monto - sobregiroUtilizado;
            sobregiroUtilizado = 0;
            System.out.println("Deuda pagada por completo. Sobrante: L. " + sobrante);
            depositar(sobrante);
        }
    }
}

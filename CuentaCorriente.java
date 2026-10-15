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
 
    // atributo publico
    public String nombreEmpresa;
 
    // atributos privados
    private double limiteSobregiro;
    private double sobregiroUtilizado = 0.0;
 
    // constructor: usa super para llamar al constructor del padre
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
    }
 
    // getters
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
 
    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }
 
    // retiro que puede usar el sobregiro si no alcanza el saldo
    public void retirarConSobregiro(double monto) {
 
        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
            return;
        }
 
        if (getSaldo() >= monto) {
            // el saldo alcanza, retiro normal
            retirar(monto);
            System.out.println("Retiro normal realizado.");
 
        } else if (monto <= getSaldo() + (limiteSobregiro - sobregiroUtilizado)) {
            // no alcanza el saldo pero si el sobregiro disponible
            double diferencia = monto - getSaldo();
 
            // primero sacamos todo el saldo que hay
            if (getSaldo() > 0) {
                retirar(getSaldo());
            }
 
            // la diferencia se cubre con sobregiro mas el 3% de cargo
            double cargo = diferencia * 0.03;
            sobregiroUtilizado = sobregiroUtilizado + diferencia + cargo;
 
            System.out.println("Retiro con sobregiro. Diferencia cubierta: L. " + diferencia);
            System.out.println("Cargo por servicio (3%): L. " + cargo);
 
        } else {
            System.out.println("Error: el monto excede el limite de sobregiro. Operacion rechazada.");
        }
    }
 
    // pagar la deuda del sobregiro
    public void pagarSobregiro(double monto) {
 
        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
            return;
        }
 
        if (monto <= sobregiroUtilizado) {
            // todo el pago va a la deuda
            sobregiroUtilizado = sobregiroUtilizado - monto;
            System.out.println("Abono a la deuda de L. " + monto);
        } else {
            // sobra dinero: se paga toda la deuda y lo que sobra va al saldo
            double sobrante = monto - sobregiroUtilizado;
            sobregiroUtilizado = 0;
            System.out.println("Deuda pagada por completo. Sobrante: L. " + sobrante);
            depositar(sobrante);
        }
    }
}

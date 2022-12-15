package com.segundo.pruebados.model;

public class Pagar {

    private Pago pago;
    private Deuda deuda;
    public Pagar(){
        this.pago = null;
        this.deuda = null;
    }
    public Pagar(Pago pago, Deuda deuda) {
        this.pago = pago;
        this.deuda = deuda;
    }
    public Pago getPago() {
        return pago;
    }
    public void setPago(Pago pago) {
        this.pago = pago;
    }
    public Deuda getDeuda() {
        return deuda;
    }
    public void setDeuda(Deuda deuda) {
        this.deuda = deuda;
    }
    
}

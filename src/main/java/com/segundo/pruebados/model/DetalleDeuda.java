package com.segundo.pruebados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_deudas")
public class DetalleDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int deuda_id;
    private int concepto_id;
    private float monto;

    public DetalleDeuda() {

    }

    public DetalleDeuda(int id, int deuda_id, float monto,int concepto_id) {
        this.id = id;
        this.deuda_id = deuda_id;
        this.concepto_id = concepto_id;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeuda_id() {
        return deuda_id;
    }

    public void setDeuda_id(int deuda_id) {
        this.deuda_id = deuda_id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getConcepto_id() {
        return concepto_id;
    }

    public void setConcepto_id(int concepto_id) {
        this.concepto_id = concepto_id;
    }

}

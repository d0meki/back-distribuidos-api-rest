package com.segundo.pruebados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_pago_deudas")
public class DetallePagoDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int deuda_id;
    private int pago_id;

    public DetallePagoDeuda() {
        this.deuda_id = -1;
        this.pago_id = -1;
    }

    public DetallePagoDeuda(int id, int deuda_id, int pago_id) {
        this.id = id;
        this.deuda_id = deuda_id;
        this.pago_id = pago_id;
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

    public int getPago_id() {
        return pago_id;
    }

    public void setPago_id(int pago_id) {
        this.pago_id = pago_id;
    }

}

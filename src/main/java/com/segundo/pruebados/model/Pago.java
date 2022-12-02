package com.segundo.pruebados.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Date fecha_pago;
    private int deuda_id;
    private int persona_id;
    private float monto;

    public Pago() {

    }

    public Pago(int id, float monto,Date fecha_pago,int deuda_id, int persona_id) {
        this.id = id;
        this.fecha_pago = fecha_pago;
        this.deuda_id = deuda_id;
        this.persona_id = persona_id;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public int getDeuda_id() {
        return deuda_id;
    }

    public void setDeuda_id(int deuda_id) {
        this.deuda_id = deuda_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
}

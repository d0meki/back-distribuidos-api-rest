package com.segundo.pruebados.model;

import java.sql.Date;

public class DeudaCi {
    private int id;
    private int persona_id;
   

    private Date fecha_creacion;
    private Date fecha_vencimiento;
    private boolean pagado;
    private String name;
   

    private String titulo;
    private float total;


    public DeudaCi() {

    }

    public DeudaCi(int id,int persona_id,Date fecha_creacion,Date fecha_vencimiento,boolean pagado, String name, String titulo, float total) {
        this.id = id;
        this.persona_id=persona_id;
        this.name = name;
        this.titulo = titulo;
        this.total = total;
        this.fecha_creacion = fecha_creacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.pagado = pagado;
    }
    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

}

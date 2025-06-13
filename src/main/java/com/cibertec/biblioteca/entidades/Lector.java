package com.cibertec.biblioteca.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="lector")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tipo_lector", length = 20, columnDefinition = "VARCHAR(20)")
    private String tipo_lector;
    @Column(name = "club_lectura", length = 50, columnDefinition = "VARCHAR(50)")
    private String club_lectura;
    @Column(name = "nivel_lectura", length = 20, columnDefinition = "VARCHAR(20)")
    private String nivel_lectura;
    @Column(name = "frecuencia", length = 20, columnDefinition = "VARCHAR(20)")
    private String frecuencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo_lector() {
        return tipo_lector;
    }

    public void setTipo_lector(String tipo_lector) {
        this.tipo_lector = tipo_lector;
    }

    public String getClub_lectura() {
        return club_lectura;
    }

    public void setClub_lectura(String club_lectura) {
        this.club_lectura = club_lectura;
    }

    public String getNivel_lectura() {
        return nivel_lectura;
    }

    public void setNivel_lectura(String nivel_lectura) {
        this.nivel_lectura = nivel_lectura;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;
}

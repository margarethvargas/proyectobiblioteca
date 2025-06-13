package com.cibertec.biblioteca.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fch_salida_libro", columnDefinition = "DATE")
    private String fch_salida_libro;
    @Column(name = "estado_prestamo", length = 20, columnDefinition = "VARCHAR(20)")
    private String estado_prestamo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bibliotecario", referencedColumnName = "id")
    private Bibliotecario bibliotecario;
    @OneToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    private Reserva reserva;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFch_salida_libro() {
        return fch_salida_libro;
    }

    public void setFch_salida_libro(String fch_salida_libro) {
        this.fch_salida_libro = fch_salida_libro;
    }

    public String getEstado_prestamo() {
        return estado_prestamo;
    }

    public void setEstado_prestamo(String estado_prestamo) {
        this.estado_prestamo = estado_prestamo;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}

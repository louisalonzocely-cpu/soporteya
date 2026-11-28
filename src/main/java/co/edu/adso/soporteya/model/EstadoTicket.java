package co.edu.adso.soporteya.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public enum EstadoTicket {
    ABIERTO("Abierto"),
    EN_CURSO("En curso"),
    RESUELTO("Resuelto"),
    CERRADO("Cerrado"),
    CANCELADO("Cancelado");

    private final String etiqueta;

    public boolean puedePasarA(EstadoTicket nuevo) {
        return switch (this) {
            case ABIERTO -> nuevo == EN_CURSO || nuevo == CANCELADO;
            case EN_CURSO -> nuevo == RESUELTO;
            case RESUELTO -> nuevo == CERRADO || nuevo == EN_CURSO;
            case CERRADO, CANCELADO -> false;
        };
    }

    public static Set<EstadoTicket> pendientes() {
        return Set.of(ABIERTO, EN_CURSO);
    }

    public boolean esFinal() {
        return this == CERRADO || this == CANCELADO;
    }

}

package co.edu.adso.soporteya.model;

import lombok.Getter;

@Getter 
public enum Prioridad {
    BAJA("Baja", 72),
    MEDIA("Media", 24),
    ALTA("Alta", 8),
    CRITICA("Critica", 4);

    private final String etiqueta;
    private final int horasLimite;

    Prioridad(String etiqueta, int horasLimite) {
        this.etiqueta = etiqueta;
        this.horasLimite = horasLimite;
    }

}

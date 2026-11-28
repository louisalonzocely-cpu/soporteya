package co.edu.adso.soporteya.model;

import lombok.Getter;

@Getter
public enum Rol {
    SOLICITANTE("Solicitante"),
    TECNICO("Tecnico"),
    COORDINADOR("Cordinador");

    private final String etiqueta;

    Rol(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}

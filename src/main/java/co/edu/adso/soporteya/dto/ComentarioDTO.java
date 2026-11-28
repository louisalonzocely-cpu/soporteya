package co.edu.adso.soporteya.dto;

import java.time.LocalDateTime;

import co.edu.adso.soporteya.model.Comentario;

public record ComentarioDTO(String autor, String rol, String texto, LocalDateTime fecha, boolean interno, boolean sistema) {

    public static ComentarioDTO from(Comentario c) {
        return new ComentarioDTO(c.getAutor().getNombreCompleto(), c.getAutor().getRol().getEtiqueta(), c.getTexto(),
                c.getFecha(), c.isInterno(), c.getTexto().startsWith("Estado: "));
    }
}
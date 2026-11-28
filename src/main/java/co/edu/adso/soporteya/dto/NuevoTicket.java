package co.edu.adso.soporteya.dto;

import co.edu.adso.soporteya.model.Prioridad;

public record NuevoTicket(String asunto, String descripcion, Prioridad prioridad, Long categoriaId) {

}

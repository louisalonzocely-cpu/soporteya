package co.edu.adso.soporteya.dto;

public record IndicadorTecnicoDTO(String tecnico, Long resueltos, Long fueraDeTiempo) {
    public long aTiempo() {
        return resueltos - fueraDeTiempo;
    }

    public int cumplimiento() {
        return resueltos == 0 ? 100 : (int) (aTiempo() * 100 / resueltos);
    }
}

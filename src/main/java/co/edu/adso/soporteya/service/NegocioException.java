package co.edu.adso.soporteya.service;


public class NegocioException extends RuntimeException{
    private final String campo;

    public NegocioException(String mensaje) {
        this(null, mensaje);
    }

    public NegocioException(String campo, String mensaje) {
        super(mensaje);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

}

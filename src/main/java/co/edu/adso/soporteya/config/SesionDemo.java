package co.edu.adso.soporteya.config;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;

@Component 
public class SesionDemo {

     private static final String CLAVE = "emailDemo";
    private static final String POR_DEFECTO = "ana.perez@soporteya.co";

    public String email(HttpSession sesion) {
        Object email = sesion.getAttribute(CLAVE);
        return email == null ? POR_DEFECTO : email.toString();
    }

    public void cambiar(HttpSession sesion, String email) {
        sesion.setAttribute(CLAVE, email);
    }

}

package co.edu.adso.soporteya.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.edu.adso.soporteya.config.SesionDemo;
import co.edu.adso.soporteya.dto.UsuarioDTO;
import co.edu.adso.soporteya.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice(annotations = Controller.class)
public class VistaComun {
    private final UsuarioService usuarios;
    private final SesionDemo demo;

    public VistaComun(UsuarioService usuarios, SesionDemo demo) {
        this.usuarios = usuarios;
        this.demo = demo;
    }

    @ModelAttribute("yo")
    public UsuarioDTO yo(HttpSession sesion) {
        return usuarios.porEmail(demo.email(sesion));
    }

    // Solo Unidad 2: la lista del selector «Actuar como»
    @ModelAttribute("usuariosDemo")
    public List<UsuarioDTO> usuariosDemo() {
        return usuarios.todos();
    }
}

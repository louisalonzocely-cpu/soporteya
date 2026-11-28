package co.edu.adso.soporteya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.adso.soporteya.config.SesionDemo;
import jakarta.servlet.http.HttpSession;

@Controller 
public class DemoController {

    private final SesionDemo demo;

    public DemoController(SesionDemo demo) {
        this.demo = demo;
    }

    @PostMapping("/demo/actuar-como")
    public String actuarComo(@RequestParam("email") String email, HttpSession sesion) {
        demo.cambiar(sesion, email);
        return "redirect:/";
    }
}

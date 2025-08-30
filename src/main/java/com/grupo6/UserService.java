package com.grupo6;

public class UserService {
    private final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registrarUsuario(String email) {
        // Lógica para registrar el usuario
        // ...
        emailService.enviarCorreo(email, "Bienvenido", "Gracias por registrarte!");
    }
}


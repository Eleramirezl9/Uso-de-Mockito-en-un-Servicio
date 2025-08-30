package com.grupo6;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

@DisplayName("UserService Tests con Mockito")
public class UserServiceTest {

    private EmailService emailServiceMock;
    private UserService userService;

    @BeforeEach
    void setUp() {
        emailServiceMock = mock(EmailService.class);
        userService = new UserService(emailServiceMock);
    }

    @Test
    @DisplayName("Registrar usuario debe enviar correo de bienvenida")
    void testRegistrarUsuarioEnviaCorreo() {
        String emailUsuario = "usuario@ejemplo.com";
        
        userService.registrarUsuario(emailUsuario);
        
        verify(emailServiceMock).enviarCorreo(
            eq(emailUsuario),
            eq("Bienvenido"),
            eq("Gracias por registrarte!")
        );
    }

    @Test
    @DisplayName("Registrar múltiples usuarios debe enviar correo a cada uno")
    void testRegistrarMultiplesUsuarios() {
        String[] usuarios = {
            "usuario1@ejemplo.com",
            "usuario2@ejemplo.com",
            "usuario3@ejemplo.com"
        };
        
        for (String email : usuarios) {
            userService.registrarUsuario(email);
        }
        
        verify(emailServiceMock, times(3)).enviarCorreo(
            anyString(),
            eq("Bienvenido"),
            eq("Gracias por registrarte!")
        );
        
        for (String email : usuarios) {
            verify(emailServiceMock).enviarCorreo(email, "Bienvenido", "Gracias por registrarte!");
        }
    }

    @Test
    @DisplayName("Verificar que no se envían correos adicionales")
    void testNoEnviarCorreosAdicionales() {
        userService.registrarUsuario("usuario@test.com");
        
        verify(emailServiceMock, times(1)).enviarCorreo(anyString(), anyString(), anyString());
        verify(emailServiceMock, never()).enviarCorreo(eq("admin@test.com"), anyString(), anyString());
    }
}
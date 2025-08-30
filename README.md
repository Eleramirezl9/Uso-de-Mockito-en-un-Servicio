# Proyecto JUnit y Mockito - Ejercicio Práctico

## 📋 Descripción

Proyecto educativo que demuestra los conceptos fundamentales de **JUnit 5** y **Mockito** para testing unitario en Java. Incluye ejemplos prácticos con clases simples (Calculadora) y testing con dependencias usando mocks (UserService).

## 🏗️ Estructura del Proyecto

```
junit-mockito-ejercicio/
├── src/
│   ├── main/java/com/grupo6/
│   │   ├── Calculadora.java         # Operaciones matemáticas básicas
│   │   ├── EmailService.java        # Interface para servicio de correo
│   │   └── UserService.java         # Servicio con dependencia de EmailService
│   └── test/java/com/grupo6/
│       ├── CalculadoraTest.java     # Tests JUnit para Calculadora
│       └── UserServiceTest.java     # Tests con Mockito para UserService
├── pom.xml                          # Configuración Maven con JUnit 5 y Mockito
└── README.md                        # Este archivo
```

## 📚 Clases Principales

### Calculadora.java
Operaciones matemáticas básicas para demostrar JUnit:
- `sumar(int a, int b)` - Suma dos números
- `restar(int a, int b)` - Resta dos números  
- `multiplicar(int a, int b)` - Multiplica dos números
- `dividir(int a, int b)` - Divide dos números (maneja división por cero)

### EmailService.java
Interface simple para demostrar Mockito:
- `enviarCorreo(String destinatario, String asunto, String cuerpo)`

### UserService.java  
Servicio que registra usuarios y envía correos de bienvenida:
- `registrarUsuario(String email)` - Registra usuario y envía correo

## 🧪 Tests Implementados

### CalculadoraTest.java (5 tests)
Demuestra conceptos fundamentales de JUnit 5:
- `@BeforeEach` para inicialización
- `assertEquals()` para verificar resultados
- `assertThrows()` para manejar excepciones
- `@DisplayName` para nombres descriptivos
- Testing de casos normales y casos edge

### UserServiceTest.java (3 tests) 
Demuestra conceptos fundamentales de Mockito:
- `mock()` para crear objetos simulados
- `verify()` para verificar interacciones
- `eq()`, `anyString()` para argument matchers
- `times()`, `never()` para controlar frecuencia

## 🚀 Cómo Ejecutar

### Prerrequisitos
- Java 8 o superior
- Maven 3.x

### Comandos principales

```bash
# Ejecutar todos los tests
mvn test

# Ejecutar tests específicos
mvn test -Dtest=CalculadoraTest
mvn test -Dtest=UserServiceTest

# Compilar y ejecutar desde cero
mvn clean install
```

## 📖 Conceptos Clave Demostrados

### JUnit 5
```java
@BeforeEach    // Ejecuta antes de cada test
@Test          // Marca método como test
@DisplayName   // Nombre legible para el test

assertEquals(expected, actual)           // Verificar igualdad
assertThrows(Exception.class, () -> {}) // Verificar excepciones
```

### Mockito
```java
EmailService mock = mock(EmailService.class);  // Crear mock

verify(mock).enviarCorreo(email, asunto, cuerpo);  // Verificar llamada
verify(mock, times(2)).enviarCorreo(anyString(), anyString(), anyString());
```

## 🎯 Evidencias de Ejecución

Para generar las evidencias requeridas, ejecute:

1. **Tests de CalculadoraTest**:
   ```bash
   mvn test -Dtest=CalculadoraTest
   ```

2. **Tests de UserServiceTest**:  
   ```bash
   mvn test -Dtest=UserServiceTest
   ```

3. **Build completo**:
   ```bash
   mvn clean install
   ```

## 🏆 Resultados Esperados

- **CalculadoraTest**: 5 tests ✅ (suma, resta, multiplicación, división, excepción)
- **UserServiceTest**: 3 tests ✅ (mock verification)
- **Total**: 8 tests, 0 failures, BUILD SUCCESS

---

**Proyecto educativo para aprender JUnit 5 y Mockito**
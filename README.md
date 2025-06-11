# 📦 ReservApp - Gestión de Usuarios con Roles

**ReservApp** es una plataforma de gestión de reservas que incluye un sistema robusto de control de usuarios con autenticación y autorización basada en roles. Este módulo representa la base del backend de la aplicación, construido con **Spring Boot** y enfocado en la seguridad y escalabilidad.

---

## 🔐 Seguridad y Manejo de Roles

Se implementó control de acceso a los endpoints utilizando **Spring Security** con `@PreAuthorize`. Las contraseñas están encriptadas con `BCryptPasswordEncoder` para mayor seguridad.

### Roles definidos

- `ADMIN` – Acceso completo a todos los endpoints.
- `CUSTOMER` – Usuario cliente, acceso limitado a funcionalidades de reserva.
- `PROVIDER` – Usuario proveedor, acceso a sus propios recursos.

---

## 📲 Endpoints y Permisos

| Endpoint                  | Método | Rol permitido   | Descripción                                 |
|--------------------------|--------|------------------|---------------------------------------------|
| `/users`                 | `POST` | `ADMIN`          | Crear un nuevo usuario                      |
| `/users/{userId}`        | `PATCH`| `ADMIN`          | Actualizar la información de un usuario     |
| `/users`                 | `GET`  | Público           | Endpoint de prueba (Hello World)            |

Los accesos están protegidos con anotaciones como:

```java
@PreAuthorize("hasRole('ADMIN')")

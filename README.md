# Back - Libros on line

API REST de gestión de libros construida con Java Servlets, JDBC y MySQL.

## Tecnologías

- Java 17 + Jakarta EE (Servlets)
- Maven (gestión de dependencias)
- MySQL (base de datos)
- Jackson (serialización JSON)
- Tomcat 10+ (servidor)

### Estructura del proyecto

src/main/java/ar/com/codo24101/
├── controller/ # Endpoints HTTP (Servlets)
├── dao/        # Acceso a datos (JDBC + MySQL)
├── domain/     # Entidades (Libro, Articulo)
├── dto/        # Objetos de transferencia (LibroDto)
├── filter/     # Filtros (CORS)
└── service/    # Lógica de negocio

#### Endpoints

| Método |               URL             |           Descripción          |
|--------|-------------------------------|--------------------------------|
| GET    |`/ListarLibroController`       | Listar todos los libros        |
| GET    |`/ObtenerLibroController?id=1` | Obtener un libro por ID        |
| POST   |`/CrearLibroController`        | Crear un libro (JSON body)     |
| POST   |`/ModificarLibroController`    | Actualizar un libro (JSON body)|
| DELETE |`/EliminarLibroController?id=1`| Eliminar un libro por ID       |

> Ejemplo de JSON (crear/modificar)

{
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry",
  "precio": 2500,
  "img": "img/el_principito.jpg",
  "isbn": "9781234567890"
}

> Setup

- 1 Crear la base de datos en MySQL:

```sql
CREATE DATABASE IF NOT EXISTS libro;
USE libro;

CREATE TABLE libro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    precio BIGINT NOT NULL,
    img VARCHAR(200),
    isbn VARCHAR(20)
);
```

- 2 Compilar con Maven:

```bash

mvn clean package
```

- 3 Desplegar el WAR generado en target/ en Tomcat 10+.
- 4 El servidor corre en [http://localhost:8080/]

> Front-end

El front-end correspondiente está en el repositorio "PaginaWeb"

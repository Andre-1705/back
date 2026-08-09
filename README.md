# Backend (Java Servlets + MySQL)

## Descripción

API RESTful para gestión de libros. Desplegada como WAR en Apache Tomcat 10.

### Tech Stack

- Java 21 + Servlets (Jakarta EE)
- MySQL 8.0
- Maven (WAR packaging)
- Apache Tomcat 10.1.57
- Jackson (serialización JSON)

#### Estructura del Proyecto

src/main/java/ar/com/codo24101/
├── controller/        # Servlets (endpoints)
│   ├── ListarLibroController.java
│   ├── CrearLibroController.java
│   ├── ModificarLibroController.java
│   ├── EliminarLibroController.java
│   └── ObtenerLibroController.java
├── domain/            # Entidades
│   ├── Libro.java
│   └── Articulo.java
├── dao/               # Acceso a datos (JDBC)
│   ├── LibroDao.java
│   ├── LibroJdbcMysqlImpl.java
│   └── AdministradorConnexiones.java
├── service/           # Lógica de negocio
│   ├── LibroService.java
│   └── LibroServiceImpl.java
└── filter/            # Filtros
└── CorsFilter.java

##### Instalación y Ejecución

- 1 Base de datos
mysql -u root -p

```bash
CREATE DATABASE libro;
USE libro;
CREATE TABLE libro (id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    titulo VARCHAR(100),
                    autor VARCHAR(100),    
                    precio BIGINT,    
                    img VARCHAR(200),    
                    isbn VARCHAR(50));

```

- 2 Compilar
mvn clean package

- 3 Configurar Tomcat

Descargar Apache Tomcat 10+

- 4 Desplegar

``
cp target/webapp.war /ruta/tomcat/webapps//ruta/tomcat/bin/startup.sh
``

###### Endpoints

|Método|                 URL                 |       Descripción       |
|------|-------------------------------------|-------------------------|
|GET   | /webapp/ListarLibroController       | Listar todos los libros |
|GET   | /webapp/ObtenerLibroController?id=1 | Obtener libro por ID    |
|POST  | /webapp/CrearLibroController        | Crear un libro          |
|PUT   | /webapp/ModificarLibroController    | Modificar un libro      |
|DELETE| /webapp/EliminarLibroController?id=1| Eliminar un libro       |

###### Integración con Frontend

El frontend (PaginaWeb) consume esta API mediante fetch:

const API_BASE = ['http://localhost:8081/webapp'];
                  fetch(API_BASE + '/ListarLibroController')
                  .then(res => res.json())
                  .then(libros => renderizarLibros(libros));

El CORS filter permite los orígenes del frontend (Live Server).

> Notas

El puerto de Tomcat debe coincidir con el API_BASE del frontend
Ajustar usuario y contraseña en `AdministradorConnexiones.java

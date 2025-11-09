# 🏋️‍♂️ Sistema de Gestión de Atletas

## 📘 Descripción general
El **Sistema de Gestión de Atletas** es una aplicación desarrollada en **Java con Spring Boot** que permite **registrar atletas, calcular su pago mensual y gestionar bonificaciones** por entrenamientos en el extranjero o por mejora de marca personal.

El sistema utiliza una arquitectura **MVC (Modelo-Vista-Controlador)** y se conecta a una **base de datos MySQL**.  
Su interfaz web, desarrollada en **HTML**, permite registrar, consultar y calcular los pagos de manera rápida y sencilla.

---

## ⚙️ Tecnologías utilizadas
- **Lenguaje:** Java 17  
- **Framework:** Spring Boot 3.x  
- **Base de datos:** MySQL 8.0+  
- **ORM:** Spring Data JPA  
- **Frontend:** HTML5 / CSS3 / JavaScript  
- **IDE recomendado:** IntelliJ IDEA  

---

## 🧠 Arquitectura del sistema

com.cog.sistemas_atleta
│
├── model
│ ├── Atleta.java
│ ├── Pago.java
│
├── repository
│ ├── AtletaRepository.java
│ └── PagoRepository.java
│
├── service
│ ├── AtletaService.java
│ └── PagoService.java
│
├── controller
│ ├── AtletaController.java
│ └── PagoController.java
│
└── resources
├── static/
│ └── index.html
└── application.properties


---

## 🧩 Instalación y configuración

### 1️⃣ Requisitos previos
- Java 17 instalado  
- MySQL Server 8.0+  
- IntelliJ IDEA o VS Code  
- Maven configurado  

---

### 2️⃣ Configuración de base de datos
Inicia sesión en MySQL:

```bash
sudo mysql -u root -p

Crea la base de datos y usuario:

CREATE DATABASE atletasdb;
CREATE USER 'atleta_user'@'localhost' IDENTIFIED BY 'Atleta123!';
GRANT ALL PRIVILEGES ON atletasdb.* TO 'atleta_user'@'localhost';
FLUSH PRIVILEGES;

3️⃣ Configuración del archivo application.properties

Ubicado en:
src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/atletasdb
spring.datasource.username=atleta_user
spring.datasource.password=Atleta123!
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080

4️⃣ Dependencias principales (pom.xml)

<dependencies>
    <!-- Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- JPA / MySQL -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>

    <!-- Lombok (para simplificar entidades) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>

    <!-- Pruebas -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

🚀 Ejecución del proyecto

Abrir IntelliJ IDEA

Ejecutar la clase principal AtletasApplication

Esperar el mensaje en consola:
Started AtletasApplication in 3.214 seconds (JVM running for 3.8)

Abrir el navegador y entrar en:
👉 http://localhost:8080

🖥️ Uso del sistema
▶️ Funcionalidades principales

Registrar atletas: Permite crear un nuevo atleta con sus datos básicos.

Registrar pagos: Asigna un pago mensual con las bonificaciones correspondientes.

Consultar información: Muestra los atletas registrados y sus pagos realizados.

Cálculo automático: El sistema calcula el total con base en las bonificaciones aplicadas.

💡 Ejemplo de flujo

En la página principal (index.html), ingresa los datos del atleta.

Guarda el registro → el sistema almacena la información en la base de datos.

Luego, puedes registrar el número de entrenamientos, bonificaciones y calcular el pago mensual.

Finalmente, consulta los pagos en la tabla del sistema.

🧾 Estructura de la base de datos
Tabla: atleta
| Campo        | Tipo    | Descripción                  |
| ------------ | ------- | ---------------------------- |
| id           | BIGINT  | Identificador único          |
| nombre       | VARCHAR | Nombre del atleta            |
| disciplina   | VARCHAR | Tipo de disciplina deportiva |
| nacionalidad | VARCHAR | País de origen               |

Tabla: pago
| Campo                   | Tipo    | Descripción                                      |
| ----------------------- | ------- | ------------------------------------------------ |
| id                      | BIGINT  | Identificador único                              |
| mes                     | VARCHAR | Mes del pago                                     |
| bonificacion_extranjero | DOUBLE  | Bonificación por entrenamientos en el extranjero |
| bonificacion_mejora     | DOUBLE  | Bonificación por mejora de marca                 |
| total                   | DOUBLE  | Pago total calculado                             |
| atleta_id               | BIGINT  | Relación con el atleta                           |

🔐 Seguridad y buenas prácticas

Las credenciales del usuario se guardan en el archivo application.properties y pueden modificarse según necesidad.

Se recomienda mantener contraseñas seguras y no compartir el usuario de base de datos en entornos productivos.

Hacer copias de seguridad periódicas de la base de datos atletasdb.

📈 Posibles mejoras futuras

Integrar autenticación (Spring Security).

Implementar frontend con React o Angular.

Generar reportes en PDF y Excel.

Incorporar roles de administrador y usuario.

👨‍💻 Autor

Emanuel Feliciano Orozco Cifuentes
Universidad Mariano Gálvez de Guatemala
📧 eorozcoc6@miumg.edu.gt

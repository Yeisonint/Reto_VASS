### Pre-requisitos 📋

Asegurate de tener una version de Java (11 en adelante) en el equipo, luego descarga este repositorio.

```
git clone https://github.com/Yeisonint/Reto_VASS.git
```

### Iniciar el servidor 🔧

Ejecuta una terminal en la carpeta backend_spring dentro del repositorio y ejecuta:

Linux
```
./mvnw spring-boot:run 
```
Windows
```
./mvnw.cmd spring-boot:run 
```
Cuando termine de iniciar, abre el navegador en http://localhost:8080/, puedes acceder a la consola de H2 para visualizar la base de datos en http://localhost:8080/h2-console

Al ingresar la página le pedira un usuario y contraseña, puede usar los siguietes usuarios:

- Administrador: Yeison, Laura
- Jefes: Andrea, Alison
- Empleados: Camilo, Juan

Las contraseñas de todos son 1234.

El diagrama básico de la base de datos es el siguiente:

![](https://github.com/Yeisonint/Reto_VASS/blob/main/Diagrama.png)

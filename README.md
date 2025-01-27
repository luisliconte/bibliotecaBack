# Proyecto Backend Biblioteca

Proyecto Biblioteca desarrollado con Spring Boot para la creación de API REST, las cuales serán consumidas por el front-end.

# Requerimientos

* java version "11.0.18"
* Maven 3.8.4
* Spring Tools Suite 
* Git
* BD Oracle version 21.0.0.0.0

# Configuraciones
- Para clonar el repositorio del proyecto, simplemente utilice el siguiente comando:
    ```
    git clone https://github.com/luisliconte/bibliotecaBack.git
    ```
- La rama que debe descargar es la siguiente: feature/bibliotecaV1.

- Archivo applicación.properties conexión a la BD:
 
    ```
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
    spring.datasource.username=TUCONTRACEÑA
    spring.datasource.password=TUCLAVE
    spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
    ```
- En la carpeta BD_BIBLIOTECA del proyecto se encuentra el archivo bdBiblioteca.sql, el cual contiene el script de la base de datos. 
  Simplemente necesitas importarlo para su uso y ejecutar el script.



# Urls de acceso: 

- Swagger -> http://localhost:8080/api-docs/swagger-ui/index.html#/
- Endpoint -> http://localhost:8080/api/libro
- Endpoint -> http://localhost:8080/api/libro/paginados?pagina=0&tamanio=3
- Endpoint -> http://localhost:8080/api/autor
- Endpoint -> http://localhost:8080/api/autor/paginados?pagina=0&tamanio=3
- Endpoint -> http://localhost:8080/api/prestamo
- Endpoint -> http://localhost:8080/api/prestamo/paginados?pagina=0&tamanio=3
- Endpoint -> http://localhost:8080/api/prestamo/libro/21?pagina=1&tamanio=2

# Cosas que faltan por mejorar:

- Crear un centralizador de errores para poder manejar todos los errores y excepciones.
- Configurar Lombok, ya que se instaló pero no funciona.


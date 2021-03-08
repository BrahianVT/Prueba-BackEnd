# Prueba Back-End Resuelve Ingeniería
Este archivo define los pasos a seguir para poder ejecutar el proyecto correctamente que se describe [aqui](https://github.com/resuelve/prueba-ing-backend?fbclid=IwAR0ZCxaQXdXP7d0m8q7hl0dSUjDut_rH1696LlrGxq92mPAy4Ul8dgEsrjw).



Antes de correr el proyecto asegúrese de instalar las siguientes tecnologías, si quiere compilar el proyecto,
ya que el proyecto se desarrolló en el S.O. Windows 10.

## Tecnologias 
* [Instalar Java](https://www.ecodeup.com/descargar-instalar-java-8/) - Tutorial como intalar y configurar correctamente Java
* [Instalar Maven](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) - Tutorial como instalar y configurar correctamente Maven
* [* Descargar IDE IntelliJ Idea](https://www.jetbrains.com/es-es/idea/) - (Opcional)Descargar el IDE solo si quiere modificar código fuente
* Docker and Docker Compose
* Junit para pruebas unitarias
* Log4j2 
## Segundo projecto branch restApi  
Para correr este segundo ejemplo primero cambiar de brach.  
```
git checkout restApi
```

### Solucion  
![Alt text](img/sol2.png?raw=true " Solution")  
Esta solucion recibe un json en un servicio RestFul y regresa el response con la respuesta   

### Ejecutar el projecto  
Asegúrese de haber instalado antes docker-compose. Ejecute el archivo .bat llamado **assemble.bat** y espere a que levante.  
Si el servicio levanta correctamente ejecute **docker ps**  y vera el servicio arriba.  
![Alt text](img/docker.png?raw=true " Solution")  

### Ajustes Usuarios que no utilizan Windows  
Desde consola ir a la ruta base del projecto [Link](https://github.com/BrahianVT/Prueba-BackEnd/tree/restApi/resuelveExercise).
Asegúrese de haber instalado antes docker-compose y desde consola ejecute:  

```
docker build --tag=rest-nomina:1.0 --rm=true .
docker-compose up
```

### Sin usar docker
Esto projecto se desarrollo con Java utilizando Maven, por lo que si no desea utilizar contenedores Docker, puede ejecutar el proyecto . Vaya a la carpeta Target y ejecute el comando:  
```
java -jar resuelveExercise.jar
```

### Servicio Rest
Una ves levantado el proyecto ir a la url y en el body pege el contenido del archivo **input.json**  en el payload, el metodo http debe ser POST:  
 Sin Docker  
localhost:8080/v1/nomina/calculaNomina  
Docker  
192.168.99.100:8080/v1/nomina/calculaNomina  

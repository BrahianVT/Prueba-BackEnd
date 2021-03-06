# Prueba Back-End Resuelve Ingeniería
Este archivo define los pasos a seguir para poder ejecutar el proyecto correctamente que se describe [aqui](https://github.com/resuelve/prueba-ing-backend?fbclid=IwAR0ZCxaQXdXP7d0m8q7hl0dSUjDut_rH1696LlrGxq92mPAy4Ul8dgEsrjw).

## Requisitos
El proyecto se realizó usando las siguientes tecnologías:

```
 Java JDK 1.8.0_201 
 Maven
 IDE (Opcional)IntelliJ Idea
```

Antes de correr el proyecto asegúrese de instalar las siguientes tecnologías, si quiere compilar el proyecto,
ya que el proyecto se desarrolló en el S.O. Windows 10.

## Instalar 
* [Instalar Java](https://www.ecodeup.com/descargar-instalar-java-8/) - Tutorial como intalar y configurar correctamente Java
* [Instalar Maven](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) - Tutorial como instalar y configurar correctamente Maven
* [* Descargar IDE IntelliJ Idea](https://www.jetbrains.com/es-es/idea/) - (Opcional)Descargar el IDE solo si quiere modificar código fuente
* Docker and Docker Compose
* Junit para pruebas unitarias
* Log4j2 
### Como compilar el proyecto 

Después de Instalar  y configurar las tecnologías correctamente, ir al repositorio del [Proyecto](https://github.com/BrahianVT/Prueba-BackEnd.git)
Y Descargar el proyecto. O si lo desea clonarlo si tiene instalado Git es su computadora, clonarlo con la instrucción:

```
git clone https://github.com/BrahianVT/Prueba-BackEnd.git
```

## Primer projecto branch main  
# Solucion  
![Alt text](img/sol1.png?raw=true " Solution")  
Esta solucion lee el archivo directamente y escribe un archivo llamado output.json  
Posteriormente ir a la carpeta base del proyecto y por línea de comandos **CMD**, donde se encuentra el archivo **pom.xml**  escribir el siguiente comando:

```
mvn compile assembly:single
```

### Como Ejecutar el proyecto 
En la carpeta target (ya incluida en el repositorio)  encontrará adentro un archivo llamado: **resuelveExercise.jar** 
Mediante CMD navegar hasta la misma carpeta donde se encuentre el jar y ejecutar el comando:

```
java -jar resuelveExercise.jar
```

Esto ejecutará el programa para calcular los salarios  y creara el archivo **output.json** 

**Antes de ejecutar el programa asegúrese que el archivo input.json este en la misma carpeta que el jar**

#### Correr el proyecto
Para correr el proyecto sin compilarlo solo descargar el archivo .jar [Link](https://github.com/BrahianVT/Prueba-BackEnd/blob/main/resuelveExercise/target/resuelveExercise.jar).
Y desde CMD use el comando que se dijo anteriormente, sin olvidar el archivo input.json.


## Segundo proYecto branch restApi  
Para correr este segundo ejemplo primero cambiar de brach.  
```
git checkout restApi
```

### Solucion  
![Alt text](img/sol2.png?raw=true " Solution")  
Esta solucion recibe un json en un servicio RestFul y regresa el response con la respuesta   

### Ejecutar el proyecto  
Asegúrese de haber instalado antes docker-compose. Ir a la base del proyecto [BASE](https://github.com/BrahianVT/Prueba-BackEnd/tree/restApi/resuelveExercise)  
Ejecute el archivo .bat llamado **assemble.bat** y espere a que levante.  
Si el servicio levanta correctamente ejecute **docker ps**  y vera el servicio arriba.  
![Alt text](img/docker.PNG?raw=true " Solution")  

### Ajustes Usuarios que no utilizan Windows  
Desde consola ir a la ruta base del proyecto [BASE](https://github.com/BrahianVT/Prueba-BackEnd/tree/restApi/resuelveExercise).
Asegúrese de haber instalado antes docker-compose y desde consola ejecute:  

```
docker build --tag=rest-nomina:1.0 --rm=true .
docker-compose up
```

### Sin usar docker
Este proyecto se desarrollo con Java utilizando Maven, por lo que si no desea utilizar contenedores Docker, puede ejecutar el proyecto . Vaya a la carpeta Target y ejecute el comando:  
```
java -jar resuelveExercise.jar
```

### Servicio Rest
Una ves levantado el proyecto ir a la url y en el body pege el contenido del archivo **input.json** :  
 Sin Docker  
localhost:8080/v1/nomina/calculaNomina  
Docker  
192.168.99.100:8080/v1/nomina/calculaNomina  


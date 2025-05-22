# Instrucciones para Configurar y Usar la Máquina Virtual Ubuntu

## 1. Descarga de la ISO de Ubuntu

Se descargó la imagen ISO oficial de Ubuntu 22.04 LTS desde la página oficial:  
[https://ubuntu.com/download/desktop](https://ubuntu.com/download/desktop)  
Se eligió la versión de 64 bits compatible con VirtualBox.

---

## 2. Creación de la Máquina Virtual en VirtualBox

- Se creó una nueva máquina virtual con las siguientes características:  
  - Nombre: `Ubuntu-Java`  
  - Tipo: Linux  
  - Versión: Ubuntu (64-bit)  
  - Memoria RAM asignada: 2048 MB  
  - Disco duro virtual: 20 GB, reservado dinámicamente  

- Se configuró la VM para usar el archivo ISO descargado como medio de arranque, montándolo en el controlador IDE.

- Se asignó 1 núcleo de CPU y se habilitó PAE/NX para un mejor rendimiento.

---

## 3. Instalación de Ubuntu

- Se arrancó la VM y se inició la instalación de Ubuntu desde la ISO.  
- Durante la instalación se eligieron las opciones:  
  - Instalación normal  
  - Descargar actualizaciones al instalar  
  - Instalar software de terceros  

- Se configuró el usuario con nombre `Daniel` (o el que corresponda) y se habilitó el inicio de sesión automático para facilitar el acceso.

- Tras finalizar la instalación, se reinició la máquina virtual y se desmontó la ISO para evitar que vuelva a iniciar desde ella.

---

## 4. Instalación de Java y Git

Se abrió la terminal y se actualizó el sistema con el comando:

sudo apt update && sudo apt upgrade -y

Se instaló Java 17 (OpenJDK) usando snap para asegurar la última versión estable:

sudo snap install openjdk

Se verificó la instalación con:

java -version

Se instaló Git para clonar el repositorio:

sudo apt install git -y

---

## 5. Clonación y ejecución del proyecto Java

Se clonó el repositorio desde GitHub con el siguiente comando:

git clone https://github.com/Daniel-Cotarelo/ProyectoTIC.git

Luego se accedió a la carpeta docker donde se encuentra el archivo Tetris.java:

cd ProyectoTIC/docker

Y se compiló y ejecutó el programa con los siguientes comandos:

javac Tetris.java  
java Tetris

---

## 6. Observaciones finales

Durante la ejecución en la Máquina Virtual, se pudo comprobar el consumo de recursos mediante la herramienta htop, monitorizando uso de CPU y memoria.

Este documento detalla los pasos para reproducir el entorno de la Máquina Virtual y ejecutar el proyecto para facilitar la comparación con el entorno Docker.
# Proyecto Benchmark: Máquina Virtual vs Docker

Este proyecto evalúa y compara el rendimiento de una aplicación Java (`Tetris.java`) ejecutada en dos entornos distintos: una máquina virtual (VM) Ubuntu y un contenedor Docker. La aplicación simula un partido de fútbol desde consola.

---

## 🖥️ ¿Qué son las máquinas virtuales y los contenedores? 🚢

Para entender las diferencias entre los entornos donde se ejecuta la **aplicación `Tetris.java`**, es fundamental conocer qué son las máquinas virtuales (VM) y los contenedores. Estas son dos tecnologías ampliamente utilizadas para aislar aplicaciones y facilitar su despliegue, especialmente cuando se quiere analizar el rendimiento en diferentes entornos de ejecución.


### 🖥️ Máquinas Virtuales (VM)

Una máquina virtual es una emulación completa de un sistema operativo que corre sobre hardware físico, gestionada por un software llamado *hipervisor* (por ejemplo, VirtualBox o VMware). Cada VM incluye su propio núcleo (kernel), sistema operativo, librerías y aplicaciones, funcionando de manera independiente del sistema operativo anfitrión.

- **Ventajas:**  
  - 🔒 Alto nivel de aislamiento y seguridad, pues cada VM es un sistema completo.  
  - 💻 Puede ejecutar sistemas operativos distintos al del host (por ejemplo, Windows host con Linux guest).  
  - ⚙️ Ideal para aplicaciones que requieren un entorno específico o un kernel modificado.

- **Desventajas:**  
  - 🐘 Consumo considerable de recursos (CPU, memoria, almacenamiento).  
  - 🕒 Inicio y parada más lentos comparados con contenedores.

### 🚢 Contenedores

Los contenedores, como los gestionados por Docker, son una forma más ligera de virtualización a nivel de sistema operativo. En lugar de virtualizar todo un sistema operativo, comparten el núcleo del host y aíslan únicamente los procesos y recursos necesarios para ejecutar la aplicación.

- **Ventajas:**  
  - ⚡ Uso eficiente de recursos, arrancan y se detienen rápidamente.  
  - 📦 Facilitan la portabilidad de aplicaciones al empaquetar dependencias y configuraciones.  
  - ☁️ Ideales para despliegues escalables y microservicios.

- **Desventajas:**  
  - 🔓 Menor aislamiento comparado con VM, ya que comparten el kernel del host.  
  - ⚠️ Limitaciones en personalización del sistema operativo o seguridad estricta.

### 🎯 Relación con el proyecto

En este proyecto se compara el rendimiento y uso de recursos de una aplicación Java que simula un partido de fútbol (Tetris.java), ejecutada en dos entornos distintos: una máquina virtual tradicional (Ubuntu sobre VirtualBox) y un contenedor Docker. El objetivo es evaluar cuál de las dos opciones resulta más eficiente para ejecutar aplicaciones Java sencillas, analizando el impacto de cada entorno sobre el rendimiento, el consumo de recursos y la experiencia de uso.

---

## ⚙️ Entorno de Pruebas

- **Host**: ASUS Zenbook, AMD Ryzen 7 7735U, 32 GB RAM, Windows 11 Home  
- **Virtual Machine (Guest)**: Ubuntu 22.04 LTS, 2 GB RAM, 2 vCPU, VirtualBox 7.0  
- **Docker**: Imagen base `openjdk:21-slim`, contenedor ejecutado desde `install.ipynb` con 2 CPUs por defecto  
- **Aplicación probada**: `Tetris.java` – Juego de Tetris ejecutado por consola desarrollado en Java  
- **Monitorización de recursos**:  
  - En VM: herramienta `htop`  
  - En Docker: comando `docker stats`  
- **Red y conexión**: Ambos entornos usan red NAT con acceso a Internet, sin puertos expuestos  
- **Capturas de resultados**: tomadas desde la terminal de Ubuntu (VM) y PowerShell (Docker) para comparar el rendimiento

---

## 📁 Estructura actual del proyecto



---

## 📚 Bibliografía y Recursos

A continuación, se presentan las principales herramientas, librerías y recursos que se han utilizado y consultado para el desarrollo y ejecución de este proyecto:

### 🛠️ Herramientas y Plataformas

- **Python 3.8+**  
  Lenguaje de programación principal para el servidor y scripts.  
  Instalación oficial: [python.org](https://www.python.org/downloads/)

- **Docker**  
  Plataforma para contenedores que permite empaquetar aplicaciones con sus dependencias.  
  Documentación e instalación: [docs.docker.com](https://docs.docker.com/get-docker/)

- **VirtualBox**  
  Software para crear y manejar máquinas virtuales.  
  Documentación e instalación: [virtualbox.org](https://www.virtualbox.org/wiki/Downloads)

- **Jupyter Notebook**  
  Entorno interactivo para análisis y visualización de datos con Python.  
  Instalación: `pip install notebook`  
  Documentación: [jupyter.org](https://jupyter.org/)

---

## ⚙️ Requisitos

```bash
Python 3.8+

Docker

VirtualBox (con Linux guest si aplica)

pip
```

---

## 📦 Librerías de Python utilizadas en el entorno

Aunque el proyecto principal se desarrolló en Java, el entorno automatizado preparado para análisis y benchmarking incluía algunas librerías de Python útiles para tareas de monitorización y visualización de resultados. Estas son:

- `jupyter` – Permite ejecutar y visualizar notebooks interactivos desde el navegador.
- `matplotlib` – Librería de gráficos utilizada para visualizar métricas de rendimiento.
- `psutil` – Permite acceder a estadísticas de uso de CPU, memoria, procesos y recursos del sistema.
- `pip` – Gestor de paquetes utilizado para instalar otras librerías.
- `sysbench` – Herramienta de benchmarking del sistema, usada desde la línea de comandos o integrada con Python (aunque no es una librería Python, forma parte del entorno).

Estas herramientas estaban disponibles en el contenedor Docker y/o en la máquina virtual como parte del entorno de pruebas, aunque no se usaron directamente en el desarrollo de la aplicación.

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

- Se asignaron 2 núcleos de CPU y se habilitó PAE/NX para un mejor rendimiento.

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

git clone https://github.com/Daniel-Cotarelo/Proyecto_TIC.git

Luego se accedió a la carpeta docker donde se encuentra el archivo Tetris.java:

cd Proyecto_TIC/docker

Y se compiló y ejecutó el programa con los siguientes comandos:

javac Tetris.java  
java Tetris

---

## 6. Observaciones finales

Durante la ejecución en la Máquina Virtual, se pudo comprobar el consumo de recursos mediante la herramienta htop, monitorizando uso de CPU y memoria.

Este documento detalla los pasos para reproducir el entorno de la Máquina Virtual y ejecutar el proyecto para facilitar la comparación con el entorno Docker.

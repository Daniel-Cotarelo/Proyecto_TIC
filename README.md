# 🎮 Proyecto Rendimiento del Tetris en Entornos Virtualizados: Docker vs Máquina Virtual con Ubuntu 

Este proyecto evalúa y compara el rendimiento de una aplicación Java (`Tetris.java`) ejecutada en dos entornos distintos: una máquina virtual (VM) con Ubuntu y un contenedor Docker. La aplicación consiste en una versión textual del juego Tetris ejecutada por consola.

---

## 🖥️ ¿Qué son las máquinas virtuales y los contenedores?

Para comprender correctamente el impacto de los entornos sobre el rendimiento del programa, es fundamental entender las diferencias entre una máquina virtual (VM) y un contenedor Docker.

### 🧱 Máquinas Virtuales (VM)

Una VM es una emulación de un sistema operativo completo, gestionado por un hipervisor como VirtualBox. Tiene su propio kernel, sistema operativo y librerías.

**Ventajas:**
- 🔐 Alto aislamiento
- 🧩 Permite sistemas diferentes al del host
- ⚙️ Entornos controlados y personalizables

**Desventajas:**
- 🐢 Alto consumo de recursos
- 🕗 Arranque y apagado más lentos

---

### 📦 Contenedores (Docker)

Los contenedores son más ligeros. Se ejecutan sobre el mismo kernel que el sistema anfitrión, aislando solo lo necesario para la aplicación.

**Ventajas:**
- ⚡ Rápido arranque y bajo uso de recursos
- 📦 Fácil portabilidad
- 🌍 Escalable y modular

**Desventajas:**
- 🔓 Menor aislamiento
- ⚠️ Limitaciones de personalización del SO

---

### 🎯 Relación con el proyecto

En este proyecto se comparan el consumo de recursos y eficiencia del mismo programa (`Tetris.java`) ejecutado sobre una VM de Ubuntu y un contenedor Docker. Se mide el rendimiento con herramientas automatizadas y se visualizan las métricas.

---

## ⚙️ Entorno de Pruebas

- **Host**: ASUS Zenbook (AMD Ryzen 7 7735U, 8 núcleos, 16 hilos, 32 GB RAM, SSD NVMe, Windows 11)  
- **VM**: Ubuntu 22.04 LTS, 2 vCPU, 2 GB RAM, 20 GB de disco dinámico (VirtualBox)  
- **Docker**: Imagen base `openjdk:21-slim`, ejecutado sin restricciones de recursos  
- **Aplicación evaluada**: `Tetris.java`  
- **Monitoreo**:
  - VM: `htop`
  - Docker: `docker stats`
- **Capturas**: realizadas desde consola (VM) y Docker Desktop en host

---

# 🧪 VM vs Docker Benchmark con Tetris.java 🎮

Este proyecto compara el rendimiento de un entorno Docker frente a una máquina virtual (VM, usando Ubuntu en VirtualBox) ejecutando una aplicación Java: un juego interactivo de consola llamado `Tetris.java`.

Se evalúan varias métricas del sistema mientras se ejecuta el programa en ambos entornos.

---

## 🧠 ¿Qué se compara?

| Métrica                | Descripción                                                                 |
|------------------------|-----------------------------------------------------------------------------|
| ⏱ Tiempo de arranque   | Tiempo desde el inicio del entorno hasta la ejecución del programa.         |
| 🧠 Uso de CPU (%)       | Promedio de uso de CPU mientras corre el programa.                          |
| 💾 Uso de Memoria (MB)  | Memoria RAM media utilizada durante la ejecución.                           |
| 📦 Tamaño del entorno   | Espacio que ocupa el entorno en disco (Docker image vs máquina virtual).   |

---

## 🎯 Objetivos del Proyecto

- Comparar el rendimiento de la ejecución del mismo programa (`Tetris.java`) en dos entornos:
  - 🐳 Docker (contenedor ligero)
  - 💻 Máquina Virtual (Ubuntu en VirtualBox)

- Evaluar y visualizar las siguientes métricas:
  - ⏱ Tiempo de arranque
  - 🧠 Uso medio de CPU
  - 💾 Uso medio de memoria RAM
  - 📦 Tamaño del entorno

- Automatizar la medición de rendimiento y generar gráficos de forma visual y clara.
- Analizar cuál entorno es más eficiente en términos de recursos.

---

## 📊 Resultados

La ejecución del benchmark ha permitido generar una imagen comparativa visual 📈 [`benchmark_comparativa_vm_docker.png`](./results/benchmark_comparativa_vm_docker.png) que muestra de manera clara el rendimiento relativo entre la máquina virtual y el contenedor Docker.

📄 Todos los resultados detallados, incluyendo métricas individuales, capturas de pantalla y análisis completo, se encuentran disponibles en el archivo [`Resultados.md`](./results/Resultados.md).

---

## 📁 Estructura actual del proyecto

```text
PROYECTO_TIC/

├── vm_vs_docker_benchmark/
│   ├── notebooks/
│   │   └── vm_vs_docker_comparison.ipynb
│   │
│   ├── results/
│   │   ├── benchmark_comparativa_vm_docker.png
│   │   ├── captura1.png
│   │   ├── captura2.png
│   │   ├── captura3.png
│   │   ├── captura4.png
│   │   └── Resultados.md
│   │
│   ├── scripts/
│   │   ├── benchmark_data.json
│   │   ├── benchmark_runner.py
│   │   ├── docker_setup.sh
│   │   ├── Dockerfile
│   │   ├── Dockerfile.Tetris
│   │   ├── monitor_metrics.py
│   │   ├── run_benchmark.sh
│   │   ├── Tetris.java
│   │   └── vm_setup.sh
│
├── .gitignore
├── README.md
└── install.ipynb
```
---


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

pip (Gestor de paquetes de Python)
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

---

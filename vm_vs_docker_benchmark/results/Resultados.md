# Resultados y Análisis Comparativo: Máquina Virtual vs Docker

## 1. Introducción

Este documento presenta las mediciones y observaciones realizadas durante la ejecución del juego Java en dos entornos diferentes: una Máquina Virtual Ubuntu y un contenedor Docker.

---

## 2. Medición en Máquina Virtual (Ubuntu)

### Uso de recursos

- **CPU máximo observado:** 4.8% (proceso gnome-shell)  
- **Memoria usada:** 231 MiB (proceso java)

### Captura de pantalla

![Uso de recursos en VM](./results/captura1.png)  
> Captura del monitor htop mostrando el consumo de CPU y memoria RAM mientras se ejecuta el juego Java en Ubuntu.  
> Se observa el proceso java activo con uso moderado de recursos.

---

### Resultado del juego

![Resultado del juego en VM](./results/captura2.png)  
> Ejecución del juego Tetris desde terminal en la máquina virtual Ubuntu.  
> El juego se ejecuta correctamente solicitando entrada del usuario.

---

## 3. Medición en Docker

### Uso de recursos

- **CPU máximo observado:** 0.10%  
- **Memoria usada:** 15.88 MiB (0.10%)

### Captura de pantalla

![Uso de recursos en Docker](./results/captura3.png)  
> Monitorización del contenedor Docker mediante el comando docker stats.  
> Se aprecia un consumo muy bajo de CPU y memoria durante la ejecución del contenedor interactivo.

---

### Resultado del juego (Docker)

![Resultado del juego en Docker](./results/captura4.png)  
> Ejecución del juego Tetris dentro del contenedor Docker.  
> El tablero del juego se despliega correctamente y acepta entrada por teclado.

---

## 4. Tiempos de arranque

| Entorno           | Tiempo de arranque (segundos) |
|-------------------|-------------------------------|
| Máquina Virtual    | 30                            |
| Contenedor Docker | 4                             |

---

## 5. Conclusión

Docker resultó ser un entorno más ligero y eficiente para ejecutar el juego Java, consumiendo significativamente menos CPU y memoria que la máquina virtual. Aunque la VM proporciona un entorno completo y flexible para pruebas del sistema operativo, Docker ofrece ventajas claras en rendimiento, simplicidad y velocidad para aplicaciones concretas.

---

## 6. Referencias

- Repositorio del proyecto: [https://github.com/Daniel-Cotarelo/ProyectoTIC](https://github.com/Daniel-Cotarelo/ProyectoTIC)  
- Documentación de Docker: [https://docs.docker.com/](https://docs.docker.com/)  
- Sitio oficial de Ubuntu: [https://ubuntu.com/](https://ubuntu.com/)

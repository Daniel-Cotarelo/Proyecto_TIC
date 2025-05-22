package vm_vs_docker_benchmark.scripts;

import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) {
        Juego juego;
        juego = new Juego();
        juego.iniciar();
    }
}

class Juego {
    private Scanner entrada;
    private Tablero tablero;
    private Pieza piezaActual;
    private boolean juegoTerminado;

    public Juego() {
        entrada = new Scanner(System.in);
        tablero = new Tablero();
        juegoTerminado = false;
    }

    public void iniciar() {
        while (!juegoTerminado) {
            piezaActual = new Pieza(0, tablero.obtenerAncho() / 2);

            if (!tablero.posicionDisponible(piezaActual.obtenerFila(), piezaActual.obtenerColumna())) {
                tablero.mostrar();
                System.out.println("El tablero está lleno. Fin del juego.");
                juegoTerminado = true;
            } else {
                boolean piezaActiva = true;

                while (piezaActiva) {
                    tablero.mostrarConPieza(piezaActual);
                    System.out.println("Mover (a: izquierda, d: derecha, s: abajo):");
                    String movimiento = entrada.nextLine();

                    if (movimiento.equals("a") && tablero.posicionDisponible(piezaActual.obtenerFila(),
                            piezaActual.obtenerColumna() - 1)) {
                        piezaActual.moverIzquierda();
                    } else if (movimiento.equals("d") && tablero.posicionDisponible(piezaActual.obtenerFila(),
                            piezaActual.obtenerColumna() + 1)) {
                        piezaActual.moverDerecha();
                    }

                    if (tablero.posicionDisponible(piezaActual.obtenerFila() + 1, piezaActual.obtenerColumna())) {
                        piezaActual.moverAbajo();
                    } else {
                        tablero.fijarPieza(piezaActual);
                        tablero.eliminarFilasCompletas();
                        piezaActiva = false;
                    }
                }
            }
        }

        entrada.close();
    }
}

class Pieza {
    private int fila;
    private int columna;

    public Pieza(int filaInicial, int columnaInicial) {
        fila = filaInicial;
        columna = columnaInicial;
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() {
        return columna;
    }

    public void moverAbajo() {
        fila = fila + 1;
    }

    public void moverIzquierda() {
        columna = columna - 1;
    }

    public void moverDerecha() {
        columna = columna + 1;
    }
}

class Tablero {
    private char[][] celdas;
    private final int FILAS;
    private final int COLUMNAS;

    public Tablero() {
        FILAS = 10;
        COLUMNAS = 10;
        celdas = new char[FILAS][COLUMNAS];
        inicializar();
    }

    private void inicializar() {
        int fila = 0;
        while (fila < FILAS) {
            int columna = 0;
            while (columna < COLUMNAS) {
                celdas[fila][columna] = '.';
                columna = columna + 1;
            }
            fila = fila + 1;
        }
    }

    public void mostrar() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print(celdas[fila][columna]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mostrarConPieza(Pieza pieza) {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (fila == pieza.obtenerFila() && columna == pieza.obtenerColumna()) {
                    System.out.print('O');
                } else {
                    System.out.print(celdas[fila][columna]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean posicionDisponible(int fila, int columna) {
        return fila >= 0 && fila < FILAS &&
                columna >= 0 && columna < COLUMNAS &&
                celdas[fila][columna] == '.';
    }

    public void fijarPieza(Pieza pieza) {
        celdas[pieza.obtenerFila()][pieza.obtenerColumna()] = 'O';
    }

    public void eliminarFilasCompletas() {
        int fila = 0;
        while (fila < FILAS) {
            boolean completa = true;
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (celdas[fila][columna] == '.') {
                    completa = false;
                }
            }

            if (completa) {
                for (int destino = fila; destino > 0; destino--) {
                    for (int columna = 0; columna < COLUMNAS; columna++) {
                        celdas[destino][columna] = celdas[destino - 1][columna];
                    }
                }
                for (int columna = 0; columna < COLUMNAS; columna++) {
                    celdas[0][columna] = '.';
                }
            }

            fila = fila + 1;
        }
    }

    public int obtenerAncho() {
        return COLUMNAS;
    }
}

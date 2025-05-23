import json
import matplotlib.pyplot as plt

def generar_grafico():
    with open("benchmark_data.json", "r") as f:
        data = json.load(f)

    categorias = data["categorias"]
    vm = data["vm"]
    docker = data["docker"]
    x = range(len(categorias))
    width = 0.35

    plt.figure(figsize=(10, 6))
    plt.bar([i - width/2 for i in x], vm, width=width, label="Máquina Virtual (Ubuntu)")
    plt.bar([i + width/2 for i in x], docker, width=width, label="Docker")

    plt.xticks(ticks=x, labels=categorias)
    plt.ylabel("Valor")
    plt.title("Comparativa de Rendimiento: VM vs Docker (Juego Tetris)")
    plt.legend()
    plt.tight_layout()

    output_path = "benchmark_comparativa_vm_docker.png"
    plt.savefig(output_path)
    print(f"📊 Gráfico generado y guardado en {output_path}")

if __name__ == "__main__":
    generar_grafico()

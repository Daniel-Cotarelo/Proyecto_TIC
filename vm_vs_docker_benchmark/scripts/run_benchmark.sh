#!/bin/bash

echo "▶️ Ejecutando benchmark_runner.py..."
python3 benchmark_runner.py

echo "📈 Generando gráfico con monitor_metrics.py..."
python3 monitor_metrics.py

echo "✅ Benchmark completado. Revisa benchmark_comparativa_vm_docker.png"

#!/bin/bash

# Script para compilar e executar os exercícios

echo "========== Compilando projeto =========="
mkdir -p target/classes
javac -d target/classes src/main/java/exercicio1/*.java src/main/java/exercicio2/*.java

if [ $? -ne 0 ]; then
    echo "Erro na compilação!"
    exit 1
fi

echo ""
echo "========== Executando Exercício 1 - Campeonato de Futebol =========="
echo ""
java -cp target/classes exercicio1.Main1

echo ""
echo ""
echo "========== Executando Exercício 2 - Loja Virtual =========="
echo ""
java -cp target/classes exercicio2.Main2

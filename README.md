# Jogo da Forca

Implementação clássica do jogo da forca em Java, em modo consola.

Projecto académico (2018).

## Como funciona

O programa escolhe aleatoriamente uma palavra de uma lista interna de 21 palavras (nomes próprios em português, países, animais e palavras longas para variar a dificuldade).

O jogador tem **6 vidas** e tenta adivinhar a palavra letra a letra.

A cada jogada o programa mostra:
- Quantas letras ainda faltam descobrir
- As letras já tentadas
- Quantas vidas restantes
- Estado actual da palavra (com `_` para letras ainda por descobrir)

## Como compilar e correr

Requer JDK 8+ instalado.

```bash
# compilar
javac -d build src/jogodaforca/JogoDaForca.java

# correr
java -cp build jogodaforca.JogoDaForca
```

A interacção decorre directamente na consola.

## Estrutura

```
src/jogodaforca/
└── JogoDaForca.java     classe única, package jogodaforca
```

## Tecnologias

`Java` · entrada via `Scanner` · selecção aleatória via `Random`

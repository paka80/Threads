# 🏭 Java Real-Time Conveyor System

Projeto desenvolvido no âmbito da UC **Sistemas de Tempo Real (2024/2025)**, com o objetivo de aplicar conceitos de **concorrência em Java** no controlo de uma linha de montagem de distribuição de caixas.

---

## 📌 Objetivo

Simular e controlar, em tempo real, uma linha de montagem que distribui caixas de diferentes fornecedores (Iquêá, ConforRama, LasKaças, Homae, etc.) por três docas de saída, com deteção de caixas, controlo de cilindros, gestão de eventos humanos e estatísticas operacionais.

---

## ⚙️ Tecnologias Usadas

- **Java (Threads, Runnable, sincronização)**
- **Java Native Interface (JNI)**
- **C/C++** para a integração com DLLs de controlo de hardware
- **NI USB 6509 DAQ** (usado no laboratório)
- **Simulador da linha de montagem** (para testes fora do laboratório)

---

## 🧩 Funcionalidades Implementadas

- Controlo de cilindros e tapete transportador
- Identificação do tipo de caixa com sensores
- Encaminhamento automático das caixas para a doca correta
- Gestão de docas fechadas (manual ou temporária)
- Botão de emergência (STOP/RESUME)
- Contadores e estatísticas de operação
- Flashing LED conforme o destino ou erro
- Interface por teclado (UI opcional via Java Swing ou JavaFX)

---

## 🖥️ Como correr

1. Clonar o repositório:
   ```bash
   git clone https://github.com/paka80/Threads.git
   ```
2. Abrir o projeto no **IntelliJ IDEA**.
3. Certifica-te de que o projeto C/C++ (DLL) está compilado com Visual Studio (projeto incluído no ZIP final).
4. Executar a classe `Main.java` (ou equivalente) para iniciar a simulação.

> ⚠️ Nota: O funcionamento completo depende da ligação ao simulador http://localhost:8081/SplitterConveyorSim.html.

---

## 🔄 Modo de Operação

- Pressionar **S** → iniciar sistema
- Pressionar **F** → terminar sistema
- Pressionar **P** → simula entrada de nova caixa
- Pressionar **P1.4/P1.3** → fecha/reabre docas 1 e 2
- Pressionar **P1.2** → fecha ambas por 10s
- Pressionar botão de emergência → pausa o sistema
- Estatísticas e estado atual podem ser solicitados via consola

---

## 📈 Requisitos Funcionais

Conforme o enunciado:
- FR_L1 a FR_L6: controlo de baixo nível (DLLs)
- FR_H1 a FR_H12: lógica de alto nível e interação
- NF1 a NF4: requisitos não funcionais como concorrência e robustez

---

## 👨‍💻 Autores

- **Pedro Pereira**  
  Estudante de Engenharia Eletrotécnica e de Computadores  
  FCT - Universidade Nova de Lisboa

---

## 📄 Licença

Este projeto é académico e não possui licença pública.

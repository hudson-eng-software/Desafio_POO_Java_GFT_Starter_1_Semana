# Sistema Imobiliário - Desafio de POO em Java

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)](https://github.com/)

## 🚀 Sobre o Projeto

Este projeto consiste em um **Sistema Imobiliário em Java**, desenvolvido como parte de um **desafio de Programação Orientada a Objetos (POO)** na empresa **GFT Technologies**, sob orientação do **Techlead Henrique Paoletti**.

O sistema permite gerenciar **proprietários e imóveis** (casas e apartamentos), oferecendo funcionalidades para:

- Cadastrar e remover **proprietários**
- Cadastrar e remover **imóveis** (casas ou apartamentos)
- **Alugar** ou **desalugar** imóveis
- Consultar imóveis **disponíveis**
- Buscar proprietário por **CPF**
- Calcular o **valor total de aluguel** para um período determinado
- Exibir valores formatados em **Reais (R$)**

O sistema é totalmente **console-based**, utilizando **Scanner** para entrada de dados do usuário.

---

## 🏗 Estrutura do Projeto

```bash
src/
│
├── application/
│ └── Programa.java // Classe principal com menu de interação
│
├── controller/
│ └── SistemaImobiliario.java // Lógica do sistema e métodos de controle
│
└── entities/
├── Imovel.java // Classe abstrata de imóvel
├── Casa.java // Classe de casa
├── Apartamento.java // Classe de apartamento
└── Proprietario.java // Classe de proprietário
```

---

## ⚙️ Funcionalidades

1. **Adicionar Proprietário**
2. **Remover Proprietário** pelo CPF
3. **Adicionar Imóvel** (Casa ou Apartamento) associado a um proprietário existente
4. **Remover Imóvel** pelo número
5. **Alugar Imóvel**
6. **Desalugar Imóvel**
7. **Listar Imóveis Disponíveis** com valores em Reais formatados
8. **Buscar Proprietário** por CPF
9. **Calcular Aluguel Total** de um imóvel por período de meses

---

## 💻 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sistema-imobiliario.git
````
2. Acesse a pasta do projeto:
```bash
cd sistema-imobiliario
```
3. Compile o projeto:
```bash
javac -d bin src/application/Programa.java
```
4. Execute o programa:
```bash
java -cp bin application.Programa
```
---

5. Interaja com o menu no console e siga as instruções.

## 📈 Exemplo de Saída

```bash
--- Sistema Imobiliário ---
1. Adicionar Proprietário
2. Remover Proprietário
3. Adicionar Imóvel
4. Remover Imóvel
5. Alugar Imóvel
6. Desalugar Imóvel
7. Listar Imóveis Disponíveis
8. Buscar Proprietário por CPF
9. Calcular Aluguel Total
0. Sair
Escolha uma opção: 7

Imóveis disponíveis:
O Apartamento 1 está disponível
Número: 1 | Valor: R$ 5.000,00 | Proprietário: Maria
````
 ---
 
## 🛠 Tecnologias Utilizadas

- [x] Java 17

- [x] Conceitos de Programação Orientada a Objetos

- [x] Classes abstratas

- [x] Encapsulamento

- [x] Herança

- [x] Polimorfismo

- [x] Console-based interaction

---
<h3>Desafio de POO - Java GFT</h3>

✍️ Autor `Hudson Amorim`

👩🏻‍💻 Techlead: `Henrique Paoletti`

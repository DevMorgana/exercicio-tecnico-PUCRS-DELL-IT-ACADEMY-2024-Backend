Ballit Championship - README

Descrição
O Ballit Championship é um sistema de gerenciamento de campeonatos desenvolvido em Java Spring Boot com MongoDB para persistência de dados. Ele permite o cadastro de times, a criação e configuração de campeonatos, e a simulação de partidas com base em regras de pontuação predefinidas. A interação com o sistema é feita via console, oferecendo uma experiência direta e simples.

Tecnologias Utilizadas
Java 11
Spring Boot 2.7.x
MongoDB 4.x ou superior
Gradle 7.x

Pré-requisitos
Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

Java 21 
Gradle
MongoDB (Instalado e em execução na porta padrão 27017)

Passo a Passo para Execução
1. Clone o Repositório
Clone o repositório do projeto para sua máquina local:
git clone https://github.com/seu-usuario/ballit-championship.git](https://github.com/DevMorgana/exercicio-tecnico-PUCRS-DELL-IT-ACADEMY-2024-Backend.git

2. Configure o MongoDB
Certifique-se de que o MongoDB esteja em execução em sua máquina. Por padrão, o projeto está configurado para se conectar ao MongoDB na localhost usando a porta 27017. Caso o MongoDB esteja em outra porta ou endereço, você pode alterar a configuração no arquivo application.properties ou application.yml localizado em src/main/resources:
spring.data.mongodb.uri=mongodb://localhost:27017/ballit

3. Compile e Execute o Projeto
Compile o projeto e execute-o usando o Gradle

4. Interação com o Sistema
Após a inicialização, o sistema estará pronto para receber comandos via console. O console permitirá que você:

Crie campeonatos
Simule partidas e visualize os resultados

MAS ANTES LEMBRE DE:
5. Cadastrar Times
Você precisa cadastrar times enviando requisições POST para o endpoint http://localhost:8080/api/teams/register no mínimo 8 times
e no máximo 16 times e o número total de times deve ser par. 

no corpo da requisição deve ter um json:
{
  "name": "teste9",
  "warCry": "VAMOS TESTAR 9",
  "foundationYear": 1950
}

com nome, grito de guerra e ano de função.

6. Simular Campeonatos
O sistema automaticamente cria rodadas e partidas entre os times cadastrados, gerando pontuações e resultados finais basta rodar o projeto que a partida inicia, caso esteja tudo configurado e com o numero certo de times.

7. Encerramento
Após a conclusão de todas as rodadas, o sistema apresentará o time campeão e a tabela final de classificação.

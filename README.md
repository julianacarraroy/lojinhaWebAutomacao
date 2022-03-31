# Lojinha Web Automação

Esse é um repositório que contém a automação de alguns testes Web de um software denominado Lojinha. Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

* Java
  (https://www.oracle.com/java/technologies/downloads/)
*  JUnit
   (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.8.0-M1)
* Selenium Webdriver
  (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.2)
* Maven
  (https://maven.apache.org/)

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto na lojinha. Eles estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$0,01 e R$7.000,00.

## Notas gerais

* Sempre utilizamos a anotação *@BeforeEach* para realizar as ações de abrir o browser e navegar até o site da lojinha


* Criamos classes para representar cada página
    * Armazenamos os métodos utilizados para a realização de login na classe LoginPage;
    * Armazenamos os métodos utilizados para acesso a lista de produtos na classe ListaDeProdutosPage;
    * Armazenamos os métodos utilizados para acesso a adição de produtos na classe FormularioDeAdicaoDeProdutosPage;
    * Armazenamos os métodos utilizados para acesso a edição de produtos na classe FormularioDeEdicaoDeProdutosPage.
  

* Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação *@DisplayName* para dar descrições em português para nossos testes.
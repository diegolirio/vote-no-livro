vote-no-livro
=============

Votacao de Livros

# Tecnologias Utilizadas
  - Java 7
  - Spring MVC
  - Spring I/O e ID
  - Spring security
  - JPA e Hibernate
  - Mysql
  - Maven
  - Tomcat 7
  - AngularJS
  - Eclipse IDE 


* Um pouco da arquitetura do projeto
1. Programação Back-End:
  Inicialmente foram criadas as models, e camada dao utilizando o ORM Hibernate com a especificação JPA integrado totalmente com Spring Transaction que é responsável pelo controle de transação com o BD. Seguinte no desenvolvimento a camada service (onde normalmente fica a regra de negócio) que contem a dependencia de dao que foi aplicado a injeção de dependência invertendo o controle para o container que cria o(s) objeto(s) dao. Assim também feito para a camada controller, que injeta o(s) objeto(s) service(s), responsavel por receber os objetos modelos da view(html/jsp). 
2. Programação Front-End:
  O desenvolvimento para gerenciar os dados nas view foi utilizados o framework cliend-side AngularJS, contendo um arquivo jsp como base, que é sempre chamado, utilizando gerenciamento de rotas (ngRoute) para completar o conteudo principal de cada requisição, possibilitando assim uma modularização bem organizada, onde cada rota tem uma view, controlador(controla os dados da view), Service(responsavel pela regra de negócio e por buscar/enviar os dados em uma API Back-End restFull).

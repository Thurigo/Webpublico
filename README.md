# Webpublico
Teste prático de programação


Bom minha trajetória começou na quinta-feira à noite. Bom, não tenho Java como minha principal stack de desenvolvimento, mas entendo o conceito do SOLID e design patterns. Como se tratava de uma API, minha primeira intenção foi subir um Docker para o banco de dados. Logo após, configurei o Spring e baixei as dependências. Acabei perdendo muito tempo tentando configurar migrações para um melhor controle do banco, mas não obtive sucesso.

Continuei com o desenvolvimento, focado em criar a API no modelo REST, criando as rotas e tudo mais. Entendo o funcionamento das controllers e services que contemplam o código limpo. Acabei utilizando os repositórios e as controllers, porém não utilizei muito os services para realizar as regras das rotas.

Continuando, criei as rotas de GET, DELETE, PUT e POST para as tabelas das entidades de pessoa física e jurídica, que criei separadamente. As rotas foram criadas e testadas utilizando o Insomnia, cujo JSON (Webpublico.json) segue abaixo. Uma parte do desafio era a comunicação 1 para N dos endereços com as tabelas das pessoas físicas e jurídicas. A relação eu consegui criar, porém não consegui fazer um POST com esses dados.

Outro ponto do desafio era a importação do arquivo CSV no banco de dados. Essa importação inicial foi feita e verificada. Caso o banco não tenha nenhum dado, ele faz a importação das pessoas físicas disponibilizadas pelo CSV.

Por fim, tentei dockerizar a aplicação Java Spring Boot, porém, como utilizei o Gradle, não consegui finalizar as imagens para rodar a aplicação em Docker.

Agradeço a oportunidade por poder participar do desafio e por me desenvolver. Gostei muito do desafio, mesmo tendo algumas dificuldades, principalmente em relação à linguagem.

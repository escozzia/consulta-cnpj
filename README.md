# Consulta CNPJ - Teste técnico SmartBR

Aplicação para consulta de CNPJs utilizando a API pública  CNPJ.ws, utilizando um back-end Java SpringBoot, um front-end Java JSF e banco de dados PostgreSQL.

### Build e Deploy
* Para realizar o build dos projetos deve-se navegar até a pasta raiz de cada projeto e executar o comando:
    ```bash 
        mvn clean package
    ```
* Para realizar o deploy da aplicação em Docker deve-se navegar até a pasta raiz e executar o comando:
    ```bash
        docker-compose up
    ```
* Alternativamente, pode-se somente executar o arquivo `build-deploy.bat` localizado na raiz, que irá executar os passos mencionado acima.

### Execução
* Uma vez que o a aplciação esteja em execução, pode-se acessar a página incial da aplicação em:
    ```
        http://localhost:8080/web/index.xhtml
    ```
* Juntamente aos projetos encontra-se uma coleção PostMan `postman_collection.json` contendo os endpoins de consulta e persistência que poderá ser importada e utilizada.

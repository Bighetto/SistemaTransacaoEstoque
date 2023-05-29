# SistemaTransacaoEstoque
A ideia desse projeto seria simular uma transação vindo de um ecommerce, fazer uma verificação se o produto esta disponível no estoque, abater o produto no estoque e retornar sucesso ou erro para o cliente em forma de email.

Para conseguir rodar o projeto em sua maquina sem erros primeiramente ira precisar ter o Docker instalado. 
Se caso nao ha o Docker instalado, podera seguir os passos de instalacao no link a seguir:

For Windows: https://docs.docker.com/desktop/install/windows-install/

For Mac: https://docs.docker.com/desktop/install/mac-install/

For Linux: https://docs.docker.com/engine/install/ubuntu/

Depois de instalado, devera ter uma conta no google mail para fazer a operacao de envio de email rodar corretamente sem erros.
Pode criar a conta se nao tiver uma no google mail, e seguir o seguinte passo para a ativacao de envio por apps terceiros:

https://support.google.com/accounts/answer/185833?visit_id=638209678680891206-2860297039&p=InvalidSecondFactor&rd=1&authuser=0

depois de configurado corretamente.
Altere a linha 61 e 62 do arquivo docker-compose para o usuario e senha que foi configurado com a sua conta google mail.

Apos isso, abra o terminal no diretorio que o docker-compose se encontra e execute o seguinte comando:

docker-compose up -d

Apos executado e todos os containers estiverem rodando, abra o postman e importe a seguinte requisicao:

curl --location 'http://localhost:8080/solicitarTransacao' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email":"seuemailPrincipal@teste.com",
    "nome":"Example",
    "produto":{
        "id":"1",
        "nome":"Headset Gamer",
        "quantidade":"1"
    }
}'

Podera testar o funcionamento do recebimento do email, e verificar no banco de dados se abateu a quantidade certa de Headset Gamer no estoque. 
Se caso a quantidade for maior que o numero que existe no estoque, um email de erro chegara para o usuario.

Arquitetura do projeto:

    https://github.com/Bighetto/SistemaTransacaoEstoque/assets/83975818/acea1a6a-1a75-40b4-9988-25dd38f5f7dc

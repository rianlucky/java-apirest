# API_Rest_Farmacia
Criação de uma API Crud para farmácia
A API é protegida por spring security (JWT token). É necessário o cadastro de um usuário no banco de dados(Cadastre um usuário via postman ou Insomnia), para então com o usuário cadastrado poder fazer o login,e após isso pegar o token na devolução do login e autorizar a requisição no postman com o token. Nessa fase todos os métodos estarão livres para acesso.

Api rest para controle de usuarios e medicamentos para farmacia

Ela tem suporte para:
Cadastrar remédios;
Cadastrar usuários do sistema;
Adicionar ou remover quantidade de medicamentos;
Exclusão direta ou exclusão lógica dependendo da regra de negócio exigida pelo cliente;
Controle de segurança com liberação de requisição só após o login ser realizado e então a requisição passar a possuir o token para enviar como autenticação;
Toda essa implementação possui uma criptografia de senha via Bcrypt visando a segurança da instituição e suas funções!


<p>
Java |SpringBoot |TokenJWT |Flyway |MySql |SpringSecurity |Bcrypto
</p>
<img align="left" alt="Leo-JAVA" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
   <img align="left" alt="Leo-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
      <img align="left" alt="Leo-Tomcat" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/tomcat/tomcat-original.svg">
   <img align="left" alt="Leo-MySQL" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg">

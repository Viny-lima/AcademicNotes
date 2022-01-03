# AcademicNotes

Bem vindo a instalação do JAAcademic. Primeiramente verifique se sua máquina possui todos os requisitos necessários para o funcionamento:

  a) Código-Fonte do Projeto: https://github.com/thiagomvilela/object-oriented-programming

  b) O MySQL Worckbench para execução dos scripts de criação do banco localmente: https://dev.mysql.com/downloads/workbench/

  c) Em seguida execute o SCRIP de criação do banco de dados no seu MySQL Worckbench:
    
    CREATE DATABASE dbAcademicNotes;

    use dbAcademicNotes;![147980865-fe417216-00b3-455a-8d7c-f8e00bb19a45](https://user-images.githubusercontent.com/82112071/147980901-32587263-ef30-4d55-bf64-7c8f365c0446.png)


    --- Criando banco tabelas

    create TABLE STUDENTS 
    (
      ID_STUDENT INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
      NAME_STUDENT varchar(50),
        STATUS_STUDENT BIT    
    );

    CREATE TABLE STUDENTS_NOTES (
        ID_NOTE INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        VALUE_NOTE DOUBLE,
        ID_STUDENT INT,
        CONSTRAINT FK_STUDENT FOREIGN KEY (ID_STUDENT)
            REFERENCES STUDENTS (ID_STUDENT)
    );
    
   d) Encontre o arquivo no packege connection/ConnectionFactory e adicine sua senha usuário e o caminho do banco de dados, se seu banco estiver configurado da maneira  padrão basta informar a senha se esse tiver.

   ![image](https://user-images.githubusercontent.com/82112071/147980997-ed094855-2fe6-46ac-be86-db6d2cdc90cb.png)

  e) Agora é só inicializar o sistema no seu ambiente de desenvolvimento.


CREATE TABLE `usuario` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `nome` varchar(255) NOT NULL,
 `senha` varchar(255) NOT NULL,
 `email` varchar(255) NOT NULL UNIQUE,
 `role` varchar(10) DEFAULT "ADMIN"
);

USE estoque;

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into produto (id, nome, quantidade) values (1, "Headset Gamer", 20);
DROP SCHEMA IF EXISTS `coledio_idat` ;


CREATE SCHEMA IF NOT EXISTS `coledio_idat` DEFAULT CHARACTER SET utf8 ;
USE `coledio_idat` ;



DROP TABLE IF EXISTS aula CASCADE;
CREATE TABLE aula(
	id_aula INT auto_increment PRIMARY KEY ,
	nombre VARCHAR(180) NOT NULL,	
);

DROP TABLE IF EXISTS alumno CASCADE;
CREATE TABLE alumno(
	id_alumno INT auto_increment PRIMARY KEY,
	apellido VARCHAR(255) NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	
);

DROP TABLE IF EXISTS detalle_aula CASCADE;
CREATE TABLE detalle_aula(
	id_aula INT NOT NULL,
	id_alumno INT NOT NULL,	
	FOREIGN KEY(id_aula) REFERENCES aula(id_aula) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(id_alumno) REFERENCES alumno(id_alumno) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(id_aula, id_alumno)
);
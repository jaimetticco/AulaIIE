DROP TABLE IF EXISTS aula CASCADE;
CREATE TABLE aula(
	id_aula Integer PRIMARY KEY,
	nombre VARCHAR(180) NOT NULL,	
);

DROP TABLE IF EXISTS alumno CASCADE;
CREATE TABLE alumno(
	id_alumno Integer PRIMARY KEY,
	apellido VARCHAR(255) NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	
);

DROP TABLE IF EXISTS detalle_aula CASCADE;
CREATE TABLE detalle_aula(
	id_aula Integer NOT NULL,
	id_alumno Integer NOT NULL,	
	FOREIGN KEY(id_aula) REFERENCES aula(id_aula) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(id_alumno) REFERENCES alumno(id_alumno) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(id_aula, id_alumno)
);
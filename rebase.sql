DROP TABLE colaboracion;
DROP TABLE oferta;
DROP TABLE solicitud;
DROP TABLE incidencia;
DROP TABLE estudiante;
DROP TABLE promotor;
DROP TABLE habilidad;
DROP TABLE usuario;


CREATE TABLE Usuario(
  id_usuario        VARCHAR(9) NOT NULL,
  nombre_completo   VARCHAR(50) NOT NULL,
  email             VARCHAR(50) NOT NULL,
  password          VARCHAR(50) NOT NULL,
  activado          BOOLEAN DEFAULT TRUE,
  admin             BOOLEAN DEFAULT FALSE,              
  saldo_horas       FLOAT NOT NULL,
  
  CONSTRAINT pk_usuario PRIMARY KEY(id_usuario),
  CONSTRAINT ri_saldo_disponible CHECK (saldo_horas>0)
  );
  
  CREATE TABLE Habilidad(
    nombre        VARCHAR(50),
    nivel         VARCHAR(50),
    descripcion   VARCHAR(200),
    CONSTRAINT
  );

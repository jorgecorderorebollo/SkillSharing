DROP TABLE colaboracion;
DROP TABLE oferta;
DROP TABLE solicitud;
DROP TABLE incidencia;
DROP TABLE estudiante;
DROP TABLE promotor;
DROP TABLE habilidad;
DROP TABLE usuario;


CREATE TABLE usuario(
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
  
  CREATE TABLE habilidad(
    nombre        VARCHAR(20),
    nivel         VARCHAR(20),
    descripcion   VARCHAR(200),
    CONSTRAINT pk_codigo_habilidad PRIMARY KEY(nombre, nivel)
  );

CREATE TABLE oferta(
    codigo_oferta   VARCHAR(6) NOT NULL,
    fecha_inicio    DATA,
    fecha_fin       DATE,
    descripcion     VARCHAR(500),
    id_usuario      VARCHAR(9),
    nombre_habilidad  VARCHAR(20),
    nivel_habilidad   VARCHAR(20),
    CONSTRAINT pk_codigo_oferta PRIMARY KEY(codigo_oferta),
    CONSTRAINT ca_id_usuario FOREIGN KEY(id_usuario)
    REFERENCES usuariO ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ca_habilidad FOREIGN KEY(nombre, nivel)
    REFERENCES (habilidad) (nombre, nivel) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONTRAINT ri_fini_ffin CHECK (fecha_fin>fecha_inicio)
  );
  
  CREATE TABLE solicitud(
  

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
  CONSTRAINT ri_saldo_disponible CHECK (saldo_horas>=0)
  );
  
  
CREATE TABLE habilidad(
  nombre        VARCHAR(20) NOT NULL,
  nivel         VARCHAR(20) NOT NULL,
  descripcion   VARCHAR(200),
  
  CONSTRAINT pk_codigo_habilidad PRIMARY KEY(nombre, nivel)
);


CREATE TABLE oferta(
  codigo_oferta   VARCHAR(6) NOT NULL,
  fecha_inicio    DATA NOT NULL,
  fecha_fin       DATE,
  id_usuario      VARCHAR(9) NOT NULL,
  nombre_habilidad  VARCHAR(20) NOT NULL,
  nivel_habilidad   VARCHAR(20) NOT NULL,
  descripcion     VARCHAR(500),
  
  
  CONSTRAINT pk_codigo_oferta PRIMARY KEY(codigo_oferta),
  CONSTRAINT ca_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_habilidad FOREIGN KEY(nombre_habilidad, nivel_habilidad) REFERENCES habilidad(nombre, nivel) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONTRAINT ri_fini_ffin CHECK (fecha_fin>fecha_inicio)
  );


CREATE TABLE solicitud(
  codigo_solicitud    VARCHAR(6) NOT NULL,
  fecha_emision       DATE NOT NULL,
  fecha_aceptacion    DATE,
  id_usuario_solicitante  VARCHAR(9) NOT NULL,
  nombre_habilidad    VARCHAR(20),
  nivel_habilidad     VARCHAR(20),

  CONSTRAINT pk_codigo_oferta PRIMARY KEY(codigo_solicitud),
  CONSTRAINT ca_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_habilidad FOREIGN KEY(nombre_habilidad, nivel_habilidad) REFERENCES habilidad(nombre, nivel) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONTRAINT ri_fini_ffin CHECK (fecha_emision>fecha_aceptacion)
);
    

CREATE TABLE colaboracion(
  codigo_colaboracion   VARCHAR(6) NOT NULL,
  fecha_inicio          DATE NOT NULL,
  fecha_fin             DATE,
  horas                 FLOAT NOT NULL,
  evalucion             INT,
  codigo_oferta         VARCHAR(6) NOT NULL,
  codigo_solicitud      VARCHAR(6) NOT NULL,
  
  CONSTRAINT  pk_codigo_colaboracion PRIMARY KEY(codigo_colaboracion),
  CONSTRAINT ca_fini FOREIGN KEY(fecha_inicio) REFERENCES solicitud(fecha_aceptacion) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_id_habilidad FOREIGN KEY(codigo_oferta) REFERENCES oferta(codigo_oferta) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_id_solicitud FOREIGN KEY(codigo_solicitud) REFERENCES solicitud(codigo_solicitud) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRINT ri_evaluacion CHECK (evaluacion BETWEEN 0 AND 10)
  );


INSERT INTO Usuario VALUES ('A1234509', 'GEMMA MENGUAL', 'al000001@gmail.com', '1234', , , 20);
INSERT INTO Usuario VALUES ('A2345091', 'ALBUSAC TAMARGO DANIEL', 'al000002@gmail.com', '1234', , ,15.5);
INSERT INTO Usuario VALUES ('A1345092', 'CASTELLS GALLEGO MARAI DEL TISCAR', 'al000003@gmail.com', '1234', , TRUE, 20);
INSERT INTO Usuario VALUES ('G1245093', 'CUETO AVELLANEDA RAFAEL', 'al000004@gmail.com', '1234', FALSE, , 1.5);
INSERT INTO Usuario VALUES ('R1235094', 'ESCOT HIGUERAS SANDRA', 'al000005@gmail.com', '1234', , TRUE, 19);

INSERT INTO habilidad VALUES ('h00001', 'bajo', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('h00001', 'medio', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('h00001', 'alto', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('h00004', 'alto', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO habilidad VALUES ('h00005', 'medio', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour');

INSERT INTO oferta VALUES ('o00001', TO_DATE('21/05/2019', 'DD/MM/YYYY'), TO_DATE('21/05/2019', 'DD/MM/YYYY'), 'A1234509', 'h00004', 'alto', '1The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00002', TO_DATE('21/07/2019', 'DD/MM/YYYY'), TO_DATE('22/07/2019', 'DD/MM/YYYY'), 'A1234509', 'h00001', 'bajo', '2The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00003', TO_DATE('27/04/2022', 'DD/MM/YYYY'), TO_DATE('21/05/2022', 'DD/MM/YYYY'), 'A1234509', 'h00005', 'medio', '3The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00004', TO_DATE('21/05/2020', 'DD/MM/YYYY'), , 'A2345091', 'h00001', 'alto', '4The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00005', TO_DATE('14/09/2021', 'DD/MM/YYYY'), TO_DATE('21/10/2021', 'DD/MM/YYYY'), 'A2345091', 'h00001', 'bajo', '5The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');



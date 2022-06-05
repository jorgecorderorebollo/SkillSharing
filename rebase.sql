DROP TABLE colaboracion;
DROP TABLE solicitud;
DROP TABLE oferta;
DROP TABLE incidencia;
DROP TABLE usuario;
DROP TABLE habilidad;

CREATE TABLE usuario(
  id_usuario        VARCHAR(9) NOT NULL,
  nombre_completo   VARCHAR(50) NOT NULL,
  email             VARCHAR(50) NOT NULL,
  password          VARCHAR(50) NOT NULL,
  activado          BOOLEAN DEFAULT TRUE,
  admin             BOOLEAN DEFAULT FALSE,              
  saldo_horas       FLOAT NOT NULL,
  
  CONSTRAINT pk_usuario PRIMARY KEY(id_usuario),
  CONSTRAINT ri_saldo_disponible CHECK (saldo_horas>=0 AND saldo_horas<=20)
  );
  
  
CREATE TABLE incidencia(
  id_alumno   VARCHAR(9) NOT NULL,
  fecha       DATE NOT NULL,
  id_promotor VARCHAR(9) NOT NULL,
  descripcion VARCHAR(500),
  
  CONSTRAINT pk_incidencia PRIMARY KEY(id_alumno, fecha),
  CONSTRAINT ca_incidencia_id_alumno FOREIGN KEY (id_alumno) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_incidencia_id_promotor FOREIGN KEY (id_promotor) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ri_coincidencia_usuario CHECK (id_alumno <> id_promotor)
); 
  
  
CREATE TABLE habilidad(
  nombre        VARCHAR(20) NOT NULL,
  nivel         VARCHAR(20) NOT NULL,
  descripcion   VARCHAR(200),
  
  CONSTRAINT pk_codigo_habilidad PRIMARY KEY(nombre, nivel)
);


CREATE TABLE oferta(
  codigo_oferta   VARCHAR(6) NOT NULL,
  fecha_inicio    DATE NOT NULL,
  fecha_fin       DATE,
  id_usuario      VARCHAR(9) NOT NULL,
  tipo            BOOLEAN NOT NULL,
  nombre_habilidad  VARCHAR(20) NOT NULL,
  nivel_habilidad   VARCHAR(20) NOT NULL,
  descripcion     VARCHAR(500),
  
  
  CONSTRAINT pk_codigo_oferta PRIMARY KEY(codigo_oferta),
  CONSTRAINT ca_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_habilidad FOREIGN KEY(nombre_habilidad, nivel_habilidad) REFERENCES habilidad(nombre, nivel) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ri_fini_ffin CHECK (fecha_fin>=fecha_inicio)
  );


CREATE TABLE solicitud(
  codigo_oferta    VARCHAR(6) NOT NULL,
  id_usuario_solicitante  VARCHAR(9) NOT NULL,
  fecha_emision       DATE NOT NULL,
  fecha_aceptacion    DATE,
  CONSTRAINT pk_codigo_solicitud PRIMARY KEY(codigo_oferta, id_usuario_solicitante),
  CONSTRAINT ca_id_usuario FOREIGN KEY(id_usuario_solicitante) REFERENCES usuario(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ca_oferta FOREIGN KEY(codigo_oferta) REFERENCES oferta(codigo_oferta) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ri_fini_ffin CHECK (fecha_emision<=fecha_aceptacion)
);
    

CREATE TABLE colaboracion(
  codigo_colaboracion   VARCHAR(6) NOT NULL,
  codigo_oferta         VARCHAR(6) NOT NULL,
  id_usuario_solicitante  VARCHAR(9) NOT NULL,
  fecha_inicio          DATE NOT NULL,
  fecha_fin             DATE,
  horas                 FLOAT NOT NULL,
  evaluacion            INT,

  CONSTRAINT  pk_codigo_colaboracion PRIMARY KEY(codigo_colaboracion),
  CONSTRAINT ca_codigo_oferta FOREIGN KEY(codigo_oferta, id_usuario_solicitante) REFERENCES 
  solicitud(codigo_oferta, id_usuario_solicitante) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT ri_evaluacion CHECK (evaluacion BETWEEN 0 AND 10)
  );


INSERT INTO Usuario VALUES ('A1234509', 'GEMMA MENGUAL', 'al000001@gmail.com', '1234', TRUE, FALSE, 16);
INSERT INTO Usuario VALUES ('A2345091', 'ALBUSAC TAMARGO DANIEL', 'al000002@gmail.com', '1234', TRUE, FALSE,15.5);
INSERT INTO Usuario (id_usuario, nombre_completo, email, password, saldo_horas) VALUES ('A2345098', 'ALBUSAC TAMARGO DANIEL', 'al000002@gmail.com', '1234', 15.5);
INSERT INTO Usuario VALUES ('A1345092', 'CASTELLS GALLEGO MARAI DEL TISCAR', 'al000003@gmail.com', '1234', TRUE, TRUE, 20);
INSERT INTO Usuario VALUES ('G1245093', 'CUETO AVELLANEDA RAFAEL', 'al000004@gmail.com', '1234', FALSE, FALSE, 1.5);
INSERT INTO Usuario VALUES ('R1235094', 'ESCOT HIGUERAS SANDRA', 'al000005@gmail.com', '1234', TRUE, TRUE, 19);

INSERT INTO incidencia VALUES ('G1245093', TO_DATE('21/02/2022', 'DD/MM/YYYY'), 'R1235094', 'El nivel ofertado es mayor que el que da');

INSERT INTO habilidad VALUES ('inglés', 'bajo', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('inglés', 'medio', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('inglés', 'alto', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
INSERT INTO habilidad VALUES ('mates', 'alto', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO habilidad VALUES ('historia', 'medio', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour');

INSERT INTO oferta VALUES ('o00001', TO_DATE('21/05/2019', 'DD/MM/YYYY'), TO_DATE('21/06/2019', 'DD/MM/YYYY'), 'A1234509', true, 'mates', 'alto', '1The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00002', TO_DATE('21/07/2019', 'DD/MM/YYYY'), TO_DATE('29/07/2019', 'DD/MM/YYYY'), 'A1234509', true,'inlgés', 'bajo', '2The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00003', TO_DATE('27/04/2022', 'DD/MM/YYYY'), TO_DATE('21/08/2022', 'DD/MM/YYYY'), 'A1234509', false,'historia', 'medio', '3The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta (codigo_oferta, fecha_inicio, id_usuario, tipo, nombre_habilidad, nivel_habilidad, descripcion)  VALUES ('o00004', TO_DATE('21/05/2020', 'DD/MM/YYYY'), 'A2345091', true, 'inglés', 'alto', '4The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');
INSERT INTO oferta VALUES ('o00005', TO_DATE('14/09/2021', 'DD/MM/YYYY'), TO_DATE('21/10/2021', 'DD/MM/YYYY'), 'A2345091', false, 'inglés', 'bajo', '5The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.');


INSERT INTO solicitud VALUES ('o00001', 'A2345091', TO_DATE('22/05/2019', 'DD/MM/YYYY'), TO_DATE('24/05/2019', 'DD/MM/YYYY'));
INSERT INTO solicitud VALUES ('o00001', 'A2345098', TO_DATE('23/07/2019', 'DD/MM/YYYY'), TO_DATE('26/07/2019', 'DD/MM/YYYY'));
INSERT INTO solicitud VALUES ('o00002', 'A2345091', TO_DATE('28/04/2022', 'DD/MM/YYYY'), TO_DATE('21/07/2022', 'DD/MM/YYYY'));
INSERT INTO solicitud (codigo_oferta, id_usuario_solicitante, fecha_emision) VALUES ('o00001', 'A1234509', TO_DATE('22/05/2020', 'DD/MM/YYYY'));
INSERT INTO solicitud VALUES ('o00003', 'A2345098', TO_DATE('16/09/2021', 'DD/MM/YYYY'), TO_DATE('20/10/2021', 'DD/MM/YYYY'));
                           
INSERT INTO colaboracion VALUES ('c00001', 'o00001','A2345091', TO_DATE('24/05/2019', 'DD/MM/YYYY'), TO_DATE('24/05/2019', 'DD/MM/YYYY'), 2.5);                           
INSERT INTO colaboracion VALUES ('c00002', 'o00003','A2345098', TO_DATE('26/07/2019', 'DD/MM/YYYY'), TO_DATE('28/07/2019', 'DD/MM/YYYY'), 1, 5);
INSERT INTO colaboracion VALUES ('c00003', 'o00001','A2345098', TO_DATE('21/07/2022', 'DD/MM/YYYY'), TO_DATE('22/07/2022', 'DD/MM/YYYY'), 1.5, 4);                           
                           

--------------------------------------------------------
-- Archivo creado  - miércoles-enero-29-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table GB_AUTOR
--------------------------------------------------------

  CREATE TABLE "GB_AUTOR" 
   (	"ID_AUTOR" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"NACIONALIDAD" VARCHAR2(50 BYTE), 
	"FECHA_NACIMIENTO" DATE, 
	"FECHA_CREACION" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP, 
	"FECHA_ACTUALIZACION" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Table GB_ESTADO
--------------------------------------------------------

  CREATE TABLE "GB_ESTADO" 
   (	"ID_ESTADO" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"NOMBRE_ESTADO" VARCHAR2(50 BYTE), 
	"DESCRIPCION" VARCHAR2(200 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP, 
	"FECHA_ACTUALIZACION" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Table GB_LIBRO
--------------------------------------------------------

  CREATE TABLE "GB_LIBRO" 
   (	"ID_LIBRO" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"TITULO" VARCHAR2(100 BYTE), 
	"ID_AUTOR" NUMBER(*,0), 
	"ISBN" VARCHAR2(15 BYTE), 
	"FECHA_PUBLICACION" DATE, 
	"ID_ESTADO" NUMBER(*,0) DEFAULT NULL, 
	"FECHA_REGISTRO" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP, 
	"FECHA_ACTUALIZACION" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Table GB_PRESTAMO
--------------------------------------------------------

  CREATE TABLE "GB_PRESTAMO" 
   (	"ID_PRESTAMO" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"ID_LIBRO" NUMBER, 
	"ID_ESTADO" NUMBER DEFAULT NULL, 
	"FECHA_PRESTAMO" DATE, 
	"FECHA_DEVOLUCION" DATE, 
	"FECHA_CREACION" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP, 
	"FECHA_ACTUALIZACION" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
REM INSERTING into GB_AUTOR
SET DEFINE OFF;
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('21','Luis García Márquez','Colombiana',to_date('19/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('28/01/25 08:49:08,745000000 PM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('22','Carlos javier Perez','España',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('23','Franci Carolina Perales','Francia',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('24','Javier Rivera','Venezuela',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('25','Cesar Agusto Faria','Chile',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('26','Miguel Lopez','Venezuela',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('28','Angel Zamora Chavez','Brasil',to_date('05/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('1','Gabriel García Márquez','Colombiana',to_date('06/03/27','DD/MM/RR'),to_timestamp('24/01/25 05:58:59,199000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_AUTOR (ID_AUTOR,NOMBRE,NACIONALIDAD,FECHA_NACIMIENTO,FECHA_CREACION,FECHA_ACTUALIZACION) values ('4','CHEO RAMIREZ LOPEZ','COLOMBIA',to_date('18/01/25','DD/MM/RR'),null,to_timestamp('29/01/25 10:10:15,061000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
REM INSERTING into GB_ESTADO
SET DEFINE OFF;
Insert into GB_ESTADO (ID_ESTADO,NOMBRE_ESTADO,DESCRIPCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('1','Activo','Activo',to_timestamp('24/01/25 05:50:54,227000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_ESTADO (ID_ESTADO,NOMBRE_ESTADO,DESCRIPCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('2','Inactivo','Finalizado',to_timestamp('24/01/25 05:50:54,234000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_ESTADO (ID_ESTADO,NOMBRE_ESTADO,DESCRIPCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('3','Eliminado','Registro eliminado',to_timestamp('24/01/25 05:50:54,238000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
REM INSERTING into GB_LIBRO
SET DEFINE OFF;
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('20','Javascript','28','1235468541452',to_date('12/01/25','DD/MM/RR'),'2',to_timestamp('28/01/25 07:40:42,474000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 12:44:14,387000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('19','Programacion Activa','1','1234567895544',to_date('09/01/25','DD/MM/RR'),'1',to_timestamp('28/01/25 07:40:00,048000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('28/01/25 07:41:08,213000000 PM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('21','LIBRO DE PRUEBA','1','5567554554454',to_date('28/12/24','DD/MM/RR'),'1',to_timestamp('28/01/25 08:57:08,086000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 10:08:29,044000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('29','El poder de la hora','23','4567823456586',to_date('11/01/25','DD/MM/RR'),'1',to_timestamp('29/01/25 10:07:28,871000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 10:07:28,871000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('24','La vidad de bolivar','28','4454544545455',to_date('01/01/25','DD/MM/RR'),'1',to_timestamp('28/01/25 09:46:53,554000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 02:00:27,142000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_LIBRO (ID_LIBRO,TITULO,ID_AUTOR,ISBN,FECHA_PUBLICACION,ID_ESTADO,FECHA_REGISTRO,FECHA_ACTUALIZACION) values ('28','PINOCHO EL NIÑO MENTIROSO','25','5565656666666',to_date('02/01/25','DD/MM/RR'),'2',to_timestamp('29/01/25 02:05:26,133000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 02:05:26,133000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
REM INSERTING into GB_PRESTAMO
SET DEFINE OFF;
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('24','20','2',to_date('09/01/25','DD/MM/RR'),to_date('10/02/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 02:51:48,576000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('17','29','2',to_date('02/01/25','DD/MM/RR'),to_date('18/01/25','DD/MM/RR'),to_timestamp('29/01/25 10:10:57,436000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('23','21','1',to_date('13/12/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('26/01/25 04:29:36,447000000 PM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('18','29','2',to_date('01/02/25','DD/MM/RR'),to_date('31/01/25','DD/MM/RR'),to_timestamp('29/01/25 10:12:26,607000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('26','21','1',to_date('25/01/25','DD/MM/RR'),to_date('26/02/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('27','21','1',to_date('26/01/25','DD/MM/RR'),to_date('27/02/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('28','21','2',to_date('27/01/25','DD/MM/RR'),to_date('28/02/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),to_timestamp('29/01/25 02:51:39,207000000 AM','DD/MM/RR HH12:MI:SSXFF AM'));
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('30','21','1',to_date('28/01/25','DD/MM/RR'),to_date('01/03/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('31','21','1',to_date('28/01/25','DD/MM/RR'),to_date('01/03/25','DD/MM/RR'),to_timestamp('25/01/25 09:49:52,824000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('32','21','1',to_date('20/02/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('25/01/25 09:50:51,218000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('43','21','1',to_date('20/02/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('26/01/25 04:12:09,519000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('44','21','1',to_date('20/02/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('26/01/25 04:12:14,748000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('45','21','1',to_date('20/02/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('26/01/25 04:26:53,094000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('46','21','1',to_date('20/02/25','DD/MM/RR'),to_date('04/03/25','DD/MM/RR'),to_timestamp('26/01/25 04:26:54,493000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('3','21','1',to_date('20/01/25','DD/MM/RR'),to_date('03/02/25','DD/MM/RR'),to_timestamp('24/01/25 06:39:01,411000000 PM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('1','20','2',to_date('07/01/25','DD/MM/RR'),to_date('17/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:24:33,855000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('2','21','2',to_date('07/01/25','DD/MM/RR'),to_date('17/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:25:07,070000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('4','20','1',to_date('02/01/25','DD/MM/RR'),to_date('17/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:26:33,854000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('5','20','1',to_date('02/01/25','DD/MM/RR'),to_date('17/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:26:41,113000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('6','20','1',to_date('06/01/25','DD/MM/RR'),to_date('24/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:29:24,054000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('7','20','1',to_date('06/01/25','DD/MM/RR'),to_date('24/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:29:30,990000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('8','20','1',to_date('02/01/25','DD/MM/RR'),to_date('07/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:32:14,087000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('9','20','1',to_date('02/01/25','DD/MM/RR'),to_date('07/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:32:27,258000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('10','20','1',to_date('02/01/25','DD/MM/RR'),to_date('07/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:39:07,816000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('11','24','1',to_date('08/01/25','DD/MM/RR'),to_date('17/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:39:29,443000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('12','24','2',to_date('03/01/25','DD/MM/RR'),to_date('03/01/25','DD/MM/RR'),to_timestamp('29/01/25 01:40:25,260000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('13','24','2',to_date('02/01/25','DD/MM/RR'),to_date('04/01/25','DD/MM/RR'),to_timestamp('29/01/25 02:00:49,385000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('14','19','2',to_date('08/01/25','DD/MM/RR'),to_date('18/01/25','DD/MM/RR'),to_timestamp('29/01/25 02:03:07,519000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
Insert into GB_PRESTAMO (ID_PRESTAMO,ID_LIBRO,ID_ESTADO,FECHA_PRESTAMO,FECHA_DEVOLUCION,FECHA_CREACION,FECHA_ACTUALIZACION) values ('16','28','2',to_date('02/01/25','DD/MM/RR'),to_date('11/01/25','DD/MM/RR'),to_timestamp('29/01/25 02:05:59,710000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),null);
--------------------------------------------------------
--  DDL for Index PK_GB_AUTOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_AUTOR" ON "GB_AUTOR" ("ID_AUTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_ESTADO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_ESTADO" ON "GB_ESTADO" ("ID_ESTADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_LIBRO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_LIBRO" ON "GB_LIBRO" ("ID_LIBRO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_PRESTAMO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_PRESTAMO" ON "GB_PRESTAMO" ("ID_PRESTAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_AUTOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_AUTOR" ON "GB_AUTOR" ("ID_AUTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_ESTADO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_ESTADO" ON "GB_ESTADO" ("ID_ESTADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_LIBRO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_LIBRO" ON "GB_LIBRO" ("ID_LIBRO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  DDL for Index PK_GB_PRESTAMO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GB_PRESTAMO" ON "GB_PRESTAMO" ("ID_PRESTAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT);
--------------------------------------------------------
--  Ref Constraints for Table GB_LIBRO
--------------------------------------------------------

  ALTER TABLE "GB_LIBRO" ADD CONSTRAINT "LIBRO_AUTOR_FK" FOREIGN KEY ("ID_AUTOR")
	  REFERENCES "GB_AUTOR" ("ID_AUTOR") ENABLE;
  ALTER TABLE "GB_LIBRO" ADD CONSTRAINT "LIBRO_ESTADO_FK" FOREIGN KEY ("ID_ESTADO")
	  REFERENCES "GB_ESTADO" ("ID_ESTADO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GB_PRESTAMO
--------------------------------------------------------

  ALTER TABLE "GB_PRESTAMO" ADD CONSTRAINT "LIBRO_PRESTAMO_FK" FOREIGN KEY ("ID_PRESTAMO")
	  REFERENCES "GB_PRESTAMO" ("ID_PRESTAMO") ENABLE;
  ALTER TABLE "GB_PRESTAMO" ADD CONSTRAINT "PRESTAMO_LIBRO_FK" FOREIGN KEY ("ID_LIBRO")
	  REFERENCES "GB_LIBRO" ("ID_LIBRO") ENABLE;

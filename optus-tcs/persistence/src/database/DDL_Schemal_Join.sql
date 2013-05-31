-- Generated by Oracle SQL Developer Data Modeler 3.3.0.747
--   at:        2013-05-29 16:58:17 EST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g




CREATE TABLE Application
  (
    id                   INTEGER NOT NULL ,
    name                 VARCHAR2 (255 CHAR) ,
    display_name         VARCHAR2 (255) ,
    description          VARCHAR2 (255 CHAR) ,
    url                  VARCHAR2 (255 CHAR) ,
    image_url            VARCHAR2 (255 CHAR) ,
    is_visible_on_portal CHAR (1)
  ) ;
CREATE INDEX Application__IDX ON Application
  ( name ASC
  ) ;
ALTER TABLE Application ADD CONSTRAINT Application_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Application ADD CONSTRAINT Application__UN UNIQUE
(
  name
)
;

CREATE TABLE Application_Capability
  (
    id             INTEGER NOT NULL ,
    cap_name       VARCHAR2 (255 CHAR) NOT NULL ,
    cap_value      VARCHAR2 (255 CHAR) NOT NULL ,
    Application_id INTEGER NOT NULL
  ) ;
CREATE INDEX Application_Capability__IDX ON Application_Capability
  (
    cap_name ASC ,
    Application_id ASC
  ) ;
ALTER TABLE Application_Capability ADD CONSTRAINT Application_Capability_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Application_Capability ADD CONSTRAINT Application_Capability__UN UNIQUE
(
  Application_id , cap_name
)
;

CREATE TABLE Wurfl_Capability
  (
    id                INTEGER NOT NULL ,
    name              VARCHAR2 (255 CHAR) NOT NULL ,
    value             VARCHAR2 (512 CHAR) NOT NULL ,
    last_updated_time TIMESTAMP ,
    Group_id          INTEGER NOT NULL ,
    extension_field1  VARCHAR2 (255 CHAR) ,
    extension_field2  VARCHAR2 (255 CHAR)
  ) ;
CREATE INDEX Capability__IDX ON Wurfl_Capability
  ( id ASC
  ) ;
CREATE INDEX Capability__IDXv1 ON Wurfl_Capability
  (
    Group_id ASC ,
    name ASC
  ) ;
ALTER TABLE Wurfl_Capability ADD CONSTRAINT Capability_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Wurfl_Capability ADD CONSTRAINT Capability__UNv1 UNIQUE
(
  Group_id , name
)
;

CREATE TABLE Wurfl_Capability_AUD
  (
    REV               INTEGER NOT NULL ,
    REVTYPE           SMALLINT NOT NULL ,
    id                INTEGER NOT NULL ,
    name              VARCHAR2 (255 CHAR) NOT NULL ,
    value             VARCHAR2 (512 CHAR) NOT NULL ,
    Group_id          INTEGER NOT NULL ,
    extension_field1  VARCHAR2 (255 CHAR) ,
    extension_field2  VARCHAR2 (255 CHAR) ,
    last_updated_time TIMESTAMP NOT NULL
  ) ;
CREATE INDEX Capabilityv1_id_IDX ON Wurfl_Capability_AUD
  ( id ASC
  ) ;
CREATE INDEX Capabilityv1_Group_id_name_IDX ON Wurfl_Capability_AUD
  (
    Group_id ASC ,
    name ASC
  ) ;
ALTER TABLE Wurfl_Capability_AUD ADD CONSTRAINT Capability_AUD_PK PRIMARY KEY
(
  id, REV
)
;

CREATE TABLE Wurfl_Device
  (
    id                 INTEGER NOT NULL ,
    device_id          VARCHAR2 (512 CHAR) NOT NULL ,
    user_agent         VARCHAR2 (512 CHAR) ,
    fall_back          VARCHAR2 (512 CHAR) NOT NULL ,
    actual_device_root VARCHAR2 (255 CHAR) ,
    digest             VARCHAR2 (255 CHAR) ,
    extension_field1   VARCHAR2 (255 CHAR) ,
    extension_field2   VARCHAR2 (255 CHAR) ,
    last_updater       VARCHAR2 (255 CHAR) ,
    is_actual_device   CHAR (1) NOT NULL ,
    last_updated_time  TIMESTAMP NOT NULL ,
    last_update_source VARCHAR2 (255 CHAR) ,
    is_patched         CHAR (1) NOT NULL ,
    wurfl_source_id    INTEGER NOT NULL
  ) ;
CREATE INDEX Device__IDX ON Wurfl_Device
  ( id ASC
  ) ;
CREATE INDEX Device__IDXv2 ON Wurfl_Device
  ( device_id ASC
  ) ;
CREATE INDEX Device__IDXv3 ON Wurfl_Device
  ( user_agent ASC
  ) ;
ALTER TABLE Wurfl_Device ADD CONSTRAINT Device_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Wurfl_Device ADD CONSTRAINT Device__UN UNIQUE
(
  device_id
)
;
ALTER TABLE Wurfl_Device ADD CONSTRAINT Device__UNv1 UNIQUE
(
  user_agent
)
;

CREATE TABLE Wurfl_Device_AUD
  (
    REV                INTEGER NOT NULL ,
    REVTYPE            SMALLINT NOT NULL ,
    id                 INTEGER NOT NULL ,
    device_id          VARCHAR2 (512 CHAR) NOT NULL ,
    user_agent         VARCHAR2 (512 CHAR) ,
    fall_back          VARCHAR2 (512 CHAR) NOT NULL ,
    actual_device_root VARCHAR2 (255 CHAR) ,
    digest             VARCHAR2 (255 CHAR) ,
    extension_field1   VARCHAR2 (255 CHAR) ,
    extension_field2   VARCHAR2 (255 CHAR) ,
    last_updated_time  TIMESTAMP ,
    last_updater       VARCHAR2 (255 CHAR) ,
    is_actual_device   CHAR (1) NOT NULL ,
    last_update_source VARCHAR2 (255 CHAR) ,
    is_patched         CHAR (1) NOT NULL ,
    wurfl_source_id    INTEGER
  ) ;
CREATE INDEX Devicev1_id_IDX ON Wurfl_Device_AUD
  ( id ASC
  ) ;
CREATE INDEX Devicev1_device_id_IDX ON Wurfl_Device_AUD
  ( device_id ASC
  ) ;
CREATE INDEX Devicev1_user_agent_IDX ON Wurfl_Device_AUD
  ( user_agent ASC
  ) ;
ALTER TABLE Wurfl_Device_AUD ADD CONSTRAINT Devicev_AUD_PK PRIMARY KEY
(
  id, REV
)
;

CREATE TABLE Wurfl_Device_Group
  (
    Wurfl_Group_id  INTEGER NOT NULL ,
    Wurfl_Device_id INTEGER NOT NULL
  ) ;
ALTER TABLE Wurfl_Device_Group ADD CONSTRAINT Wurfl_Device_Group_PK PRIMARY KEY
(
  Wurfl_Group_id, Wurfl_Device_id
)
;

CREATE TABLE Wurfl_Device_Group_AUD
  (
    REV             INTEGER NOT NULL ,
    REVTYPE         SMALLINT NOT NULL ,
    Wurfl_Group_id  INTEGER NOT NULL ,
    Wurfl_Device_id INTEGER NOT NULL
  ) ;
ALTER TABLE Wurfl_Device_Group_AUD ADD CONSTRAINT Wurfl_Device_Group_AUD_PK PRIMARY KEY
(
  REV, Wurfl_Group_id, Wurfl_Device_id
)
;

CREATE TABLE Wurfl_Group
  (
    id       INTEGER NOT NULL ,
    group_id VARCHAR2 (255 CHAR) NOT NULL ,
    digest   VARCHAR2 (255 CHAR) ,
    json_capabilities CLOB NOT NULL ,
    extension_field1  VARCHAR2 (255 CHAR) ,
    extension_field2  VARCHAR2 (255 CHAR) ,
    device_id         INTEGER NOT NULL ,
    last_updated_time TIMESTAMP NOT NULL
  ) ;
CREATE INDEX Group_id_IDX ON Wurfl_Group
  ( id ASC
  ) ;
CREATE INDEX Group_group_id_IDX ON Wurfl_Group
  ( group_id ASC
  ) ;
ALTER TABLE Wurfl_Group ADD CONSTRAINT Group_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Wurfl_Group ADD CONSTRAINT Wurfl_Group__UN UNIQUE
(
  group_id , device_id
)
;

CREATE TABLE Wurfl_Group_AUD
  (
    REV      INTEGER NOT NULL ,
    REVTYPE  SMALLINT NOT NULL ,
    id       INTEGER NOT NULL ,
    group_id VARCHAR2 (255 CHAR) NOT NULL ,
    digest   VARCHAR2 (255 CHAR) ,
    json_capabilities CLOB NOT NULL ,
    extension_field1  VARCHAR2 (255 CHAR) ,
    extension_field2  VARCHAR2 (255 CHAR) ,
    device_id         INTEGER NOT NULL ,
    last_updated_time TIMESTAMP NOT NULL
  ) ;
CREATE INDEX Group__IDX ON Wurfl_Group_AUD
  ( id ASC
  ) ;
CREATE INDEX Group__IDXv1 ON Wurfl_Group_AUD
  ( group_id ASC
  ) ;
ALTER TABLE Wurfl_Group_AUD ADD CONSTRAINT Group_AUD_PK PRIMARY KEY
(
  id, REV
)
;

CREATE TABLE Wurfl_Group_Capability
  (
    Wurfl_Capability_id INTEGER NOT NULL ,
    Wurfl_Group_id      INTEGER NOT NULL
  ) ;
ALTER TABLE Wurfl_Group_Capability ADD CONSTRAINT Wurfl_Group_Capability_PK PRIMARY KEY
(
  Wurfl_Capability_id, Wurfl_Group_id
)
;

CREATE TABLE Wurfl_Group_Capability_AUD
  (
    REV                 INTEGER NOT NULL ,
    REVTYPE             SMALLINT ,
    Wurfl_Capability_id INTEGER NOT NULL ,
    Wurfl_Group_id      INTEGER NOT NULL
  ) ;
ALTER TABLE Wurfl_Group_Capability_AUD ADD CONSTRAINT Wurfl_Group_Capability_AUD_PK PRIMARY KEY
(
  REV, Wurfl_Capability_id, Wurfl_Group_id
)
;

CREATE TABLE Wurfl_Source
  (
    id          INTEGER NOT NULL ,
    source_name VARCHAR2 (255 CHAR) NOT NULL ,
    Memo        VARCHAR2 (255 CHAR) ,
    source_data BLOB NOT NULL ,
    updated_time TIMESTAMP NOT NULL ,
    updater      VARCHAR2 (255 CHAR) NOT NULL ,
    source_type  VARCHAR2 (10 CHAR)
  ) ;
ALTER TABLE Wurfl_Source ADD CONSTRAINT WurflXML_PK PRIMARY KEY
(
  id
)
;

CREATE TABLE Wurfl_User
  (
    id       INTEGER NOT NULL ,
    name     VARCHAR2 (10 CHAR) NOT NULL ,
    password VARCHAR2 (10 CHAR) NOT NULL
  ) ;
ALTER TABLE Wurfl_User ADD CONSTRAINT User_PK PRIMARY KEY
(
  id
)
;
ALTER TABLE Wurfl_User ADD CONSTRAINT User__UN UNIQUE
(
  name
)
;

ALTER TABLE Application_Capability ADD CONSTRAINT App_Capa_App_FK FOREIGN KEY ( Application_id ) REFERENCES Application ( id ) ON
DELETE CASCADE ;

ALTER TABLE Wurfl_Device ADD CONSTRAINT Device_WurflXML_FK FOREIGN KEY ( wurfl_source_id ) REFERENCES Wurfl_Source ( id ) ;

ALTER TABLE Wurfl_Device_Group ADD CONSTRAINT Wurfl_Device_Group_Device_FK FOREIGN KEY ( Wurfl_Device_id ) REFERENCES Wurfl_Device ( id ) ;

ALTER TABLE Wurfl_Device_Group ADD CONSTRAINT Wurfl_Device_Group_Group_FK FOREIGN KEY ( Wurfl_Group_id ) REFERENCES Wurfl_Group ( id ) ;

ALTER TABLE Wurfl_Group_Capability ADD CONSTRAINT Wurfl_Group_Cpbty_Group_FK FOREIGN KEY ( Wurfl_Group_id ) REFERENCES Wurfl_Group ( id ) ;

ALTER TABLE Wurfl_Group_Capability ADD CONSTRAINT Wurfl_Grp_Cpbty_Capability_FK FOREIGN KEY ( Wurfl_Capability_id ) REFERENCES Wurfl_Capability ( id ) ;


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                            16
-- ALTER TABLE                             27
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
commit;
-- Puedo crear un archivo schema.sql o schema.sql para que jpa lo inicialice en conjunto con la aplicación

INSERT IGNORE INTO tramites (nombre) VALUES
       ("esterilizacion"),
       ("desparasitacion");

INSERT IGNORE INTO usuarios (nombre) VALUES
       ("hola");
INSERT IGNORE INTO servicios (id) VALUES
       (1);

INSERT IGNORE INTO solicitudes (id,estado) VALUES
       (1,"PAGADO"),
       (2,"FINALIZADO"),
       (3,"EVALUADO"),
       (26,"PENDIENTE"),
       (34,"PAGADO");

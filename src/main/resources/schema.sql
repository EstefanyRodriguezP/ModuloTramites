-- Puedo crear un archivo schema.sql o schema.sql para que jpa lo inicialice en conjunto con la aplicación

INSERT IGNORE INTO tramites (nombre, estado) VALUES
       ("esterilizacion", "PENDIENTE"),
       ("desparasitacion", "EVALUADO");

INSERT IGNORE INTO usuarios (nombre) VALUES
       ("hola");
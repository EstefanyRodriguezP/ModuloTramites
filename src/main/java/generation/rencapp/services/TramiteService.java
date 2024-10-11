package generation.rencapp.services;

import generation.rencapp.models.Tramite;

import java.util.List;

public interface TramiteService {

    // Metodo para buscar horario por id
    Tramite findByTramiteId(Long id);

    //Metodo para buscar todos los trámites
    List<Tramite> findAllTramites();

}

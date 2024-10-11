package generation.rencapp.services;


import generation.rencapp.models.Tramite;
import generation.rencapp.repositories.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteServiceImpl implements TramiteService {

    @Autowired
    private TramiteRepository tramiteRepository;

    //Metodo para buscar horarios por el estado
    public List<Tramite> findHorarioByEstado(String estado) {
        return tramiteRepository.findByEstadoTramite(estado);
    }

    //Metodo para borrar horario por id
    public void deleteHorarioById(Long id) {
        horarioRepository.deleteById(id);
    }

    public Usuario saveUsuario(Usuario usuarioNuevo) {
        return usuarioRepository.save(usuarioNuevo);
    }

    //Metodo para buscar todos los trámites
    @Override
    public List<Tramite> findAllTramites() {
        return tramiteRepository.findAll();
    }

    @Override
    public Tramite findByTramiteId(Long id){
        return tramiteRepository.findById(id).get();
    }

}

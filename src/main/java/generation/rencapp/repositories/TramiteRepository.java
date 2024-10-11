package generation.rencapp.repositories;

import generation.rencapp.models.Tramite;
import generation.rencapp.models.Vecino;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository//Spring va a tomar esta interfaz como un componente que puedo luego inyectar en otras capas
public interface TramiteRepository extends JpaRepository<Tramite, Long> {

    //Los repositorios son interfaces porque sólo definen métodos
    /**La clase JpaRepository, contiene metodos para hacer el CRUD**/

    List<Tramite> findByVecinoId(Vecino vecino);

    List<Tramite> findByNombreTramite(String nombre);

    List<Tramite> findByEstadoTramite(String estado);

    //List<Tramite> findByServicioId(Servicio servicio);

    //List<Tramite> findByFecha(LocalDate fecha);

}

package generation.rencapp.api;


import generation.rencapp.models.Tramite;
import generation.rencapp.services.TramiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tramites")
public class TramiteRestController {

    @Autowired
    private TramiteServiceImpl tramiteServiceImpl;

    /** OBTENER LISTA DE TODOS LOS TRAMITES CREADOS **/
    //Clase ResponseEntity<List<Tramite>> permite manipular el status de la respuesta
    @GetMapping("/listaTramites")
    public ResponseEntity<List<Tramite>> findAllTramites() {
        List<Tramite> listaTramites = tramiteServiceImpl.findAllTramites();
        //Retornamos una nueva instancia de ResponseEntity
        //return new ResponseEntity<>(tramiteService.findAll(), HttpStatus.OK)
        return new ResponseEntity<>(listaTramites, HttpStatus.OK);
    }

    /** OBTENER HORARIO POR ID **/
    //Al no conocer el tipo de dato que se va a retornar podemos indicar que se retorna un responseEntity<?>
    //@PathVariable = localhost/api/horarios/5
    @GetMapping("/{id}")
    public ResponseEntity<?> findHorarioById(@PathVariable Long id) {
        return new ResponseEntity<>(horarioService.findById(id), HttpStatus.OK);
    }

    /** OBTENER HORARIOS POR ESTADO **/
    @GetMapping
    public ResponseEntity<?> findHorarioByEstado(@RequestParam String estado) {
        return new ResponseEntity<>(horarioService.findHorarioByEstado(estado), HttpStatus.OK);
    }
    //RequestParam = localhost/api/horarios?estado=DISPONIBLE

    /** CREAR NUEVO HORARIO PARA DOCTOR CON EL ID DE DOCTOR **/
    @PostMapping("/nuevo/{doctorId}")
    public ResponseEntity<?> saveHorarioNuevo(@RequestBody Horario horarioNuevo,
                                              @PathVariable Long doctorId) {
        //BUscamos al doctor por su id y lo guardamos en una variable
        Doctor doctorSeleccionado = doctorService.findById(doctorId);

        //Al horario que se está enviando en la petición le seteamos el doctor con la variable creada
        horarioNuevo.setDoctor(doctorSeleccionado);

        //Finalmente, guardamos el horario llamando al metodo en el service
        horarioService.saveHorario(horarioNuevo);
        return new ResponseEntity<>("El horario se ha creado exitosamente", HttpStatus.CREATED);
    }

    /** EDITAR HORARIO POR ID **/
    //PUT es el metodo HTTP para trabajar con edición
    //ID del horario va a ser la variable o criterio de búsqueda del horario a editar
    //Va a recibir un objeto de tipo Horario con los campos editados
    @PutMapping("/editar/{id}")
    public ResponseEntity<Horario> updateHorarioById(@PathVariable Long id,
                                                     @RequestBody Horario horarioEditado) {
        //Buscamos primero, el horario por ID
        Horario horarioSeleccionado = horarioService.findById(id);

        //Al horarioEditado que viene en el cuerpo de la petición, le seteamos el ID de nuestro horarioSeleccionado
        horarioEditado.setId(horarioSeleccionado.getId());

        //Al horarioeEditado le seteamos el doctor del horarioSeleccionado
        horarioEditado.setDoctor(horarioSeleccionado.getDoctor());

        //Retornamos una nueva ResponseEntity pasando como argumento el metodo de guardar horario
        return new ResponseEntity<>(horarioService.saveHorario(horarioEditado), HttpStatus.OK);
    }

    /** ELIMINAR HORARIO POR ID **/
    //DELETE es el metodo HTTP que me permite eliminar registros
    //ID del horario va a ser el atributo por el que voy a filtrar
    //Vamos a recibir un dato de tipo Long que es el ID a través de la ruta
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteHorarioById(@PathVariable Long id) {
        //LLamamos al metodo del service para borrar por ID
        horarioService.deleteHorarioById(id);
        //Retornamos un nuevo ResponseEntity indicando un mensaje en el cuerpo de la respuesta
        return new ResponseEntity<>("El horario ha sido eliminado", HttpStatus.OK);
    }

}

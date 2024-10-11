package generation.rencapp.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tramites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreTramite;

    // REVISAR SI FECHA Y HORA CORRESPONDE O ES NECESARIO CREAR RELACIÓN CON TABLE DE AGENDAMIENTO
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;

    public enum EstadoTramite {
        PENDIENTE,
        EVALUADO,
        PAGADO,
        FINALIZADO
    }


    // RELACIONES FOREIGN KEY
    /*@JsonIgnore//Ignorar en la respuesta JSON este campo
    @ManyToOne//Many to one permite crear una relación de uno a muchos (1 a n)
    @JoinColumn(name = "vecino_id", nullable = false)
    private Vecino vecino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;
    */


}

package generation.rencapp.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Solicitud {

    /*solicitudes van dentro de los tramites
    -> Usuario conectado a Solicitud, solicitud conectado al Tramite
    -> Usar boolean para los requerimientos de cada Trámite:
       Agendamiento, pago asociado, cargo de archivos, términos y condiciones
    -> Debe estar asociado a la tabla de subida de Documentos*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitud estado;

    public enum EstadoSolicitud {
        PENDIENTE,
        EVALUADO,
        PAGADO,
        FINALIZADO
    }


    // RELACIONES FOREIGN KEY
    @JsonIgnore//Ignorar en la respuesta JSON este campo
    @ManyToOne//Many to one permite crear una relación de uno a muchos (1 a n)
    @JoinColumn(name = "vecino_id")
    private Vecino vecino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    // FALTA RELACION CON AGENDAMIENTO Y CARGA DE DOCUMENTOS


}

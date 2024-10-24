package generation.rencapp.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vecinos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vecino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}

package shopping.web.crud.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prices")
public class Prices {
    @Id
    @NotEmpty
    @Column(name="timestamp", nullable=false)
    private Timestamp timestamp;

    @NotEmpty
    @Column(name="date", nullable=false)
    private Date date;

    @NotEmpty
    @Column(name="status", nullable=false)
    private String status;

    @NotEmpty
    @Column(name="base", nullable=false)
    private String base;

    @NotEmpty
    @Column(name="rate", nullable=false)
    private String rate;

    @NotEmpty
    @Column(name="unit", nullable=false)
    private String unit;

}

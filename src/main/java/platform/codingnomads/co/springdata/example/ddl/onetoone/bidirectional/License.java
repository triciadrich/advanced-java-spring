package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "licenses")
@NoArgsConstructor
@Getter
@Setter
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date expDate;

    @OneToOne(
            mappedBy = "license"
    )
    private Driver driver;
}

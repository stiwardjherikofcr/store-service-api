package co.edu.ufps.ingsistemas.sjcr.storeservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_stores")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phone")
    private String phone;

    @Column(name = "picture")
    private String picture;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitud")
    private String longitud;

}

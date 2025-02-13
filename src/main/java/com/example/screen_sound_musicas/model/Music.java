package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "musics")
public class Music {
    @Id
    Long id;

    String name;

    @ManyToOne
    Artist artist;
}

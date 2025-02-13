package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    String name;

    @Enumerated(EnumType.STRING)
    ArtistType artistType;

    @OneToMany(mappedBy = "artist")
    List<Music> musics = new ArrayList<>();
}

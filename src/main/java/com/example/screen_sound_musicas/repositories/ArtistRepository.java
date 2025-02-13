package com.example.screen_sound_musicas.repositories;

import com.example.screen_sound_musicas.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository <Artist, Long> {

    Optional<Artist> findByName(String artistName);
}

package com.example.screen_sound_musicas.repositories;

import com.example.screen_sound_musicas.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music,Long> {

    List<Music> findByArtistName(String artistName);
}

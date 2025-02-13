package com.example.screen_sound_musicas;

import com.example.screen_sound_musicas.repositories.ArtistRepository;
import com.example.screen_sound_musicas.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundMusicasApplication implements CommandLineRunner {

	@Autowired
	ArtistRepository artistRepository;

	@Autowired
	MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(artistRepository, musicRepository);

		principal.menu();


	}
}

package com.example.screen_sound_musicas;

import com.example.screen_sound_musicas.model.Artist;
import com.example.screen_sound_musicas.model.ArtistType;
import com.example.screen_sound_musicas.model.Music;
import com.example.screen_sound_musicas.repositories.ArtistRepository;
import com.example.screen_sound_musicas.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    Scanner scan = new Scanner(System.in);

    ArtistRepository artistRepository;
    MusicRepository musicRepository;

    Principal(ArtistRepository artistRepository, MusicRepository musicRepository){
        this.artistRepository = artistRepository;
        this.musicRepository = musicRepository;
    }

    public void menu (){
        boolean exit = false;
        do{
            System.out.println("""
                1 - Register artists
                2 - Register musics
                3 - List musics
                4 - Find musics by artist
                5 - Find data about a artist
                0 - Exit
                """);

            int option = -1;
            try {
                System.out.print(">> ");
                option = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e){
                option = -1;
            }

            switch (option){
                case 0:
                    exit = true;
                    break;
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerMusics();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    findMusicsByArtist();
                    break;
                case 5:
                    findArtist();
                    break;
                default:
                    System.out.println("invalid option!");
                    break;
            }
        }while(!exit);
    }

    private void registerArtists() {
        System.out.print("Artist name: ");
        String name = scan.nextLine();
        System.out.print("\nArtist type (solo, duo, band): ");
        String type = scan.nextLine();
        ArtistType artistType = ArtistType.valueOf(type.toUpperCase());

        Artist artist = new Artist(name, artistType);

        artistRepository.save(artist);
    }

    private void registerMusics() {
        System.out.print("Artist name: ");
        String artistName = scan.nextLine();
        Optional<Artist> artist = artistRepository.findByName(artistName);

        if(artist.isPresent()){
            System.out.print("\nMusic name: ");
            String musicName = scan.nextLine();

            Music music = new Music(musicName, artist.get());
            musicRepository.save(music);

        } else {
            System.out.println("'" + artistName + "' not found!");
        }

    }

    private void listMusics() {
        List<Music> musics = musicRepository.findAll();
        musics.forEach(System.out::println);
    }

    private void findMusicsByArtist() {
        System.out.print("Artist name: ");
        String artistName = scan.nextLine();

        List<Music> musics = musicRepository.findByArtistName(artistName);

        if (!musics.isEmpty()){
            musics.forEach(System.out::println);
        }else {
            System.out.println("'" + artistName + "' not found!");
        }
    }

    private void findArtist() {
        Artist artist = new Artist();
        artist.setName("Fresno");
        Artist artistFind = artistRepository.findAll().get(0);
        System.out.println(artistFind);
    }

}

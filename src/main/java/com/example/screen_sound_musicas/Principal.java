package com.example.screen_sound_musicas;

import model.Artist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    Scanner scan = new Scanner(System.in);

    public boolean menu (){
        boolean exit = false;
            System.out.println("""
                1 - Register artists
                2 - Register musics
                3 - List musics
                4 - Find musics by artist
                5 - Find data about a artist
                0 - Exit
                """);

            int menu;
            try {
                System.out.print(">> ");
                menu = scan.nextInt();
            }catch (InputMismatchException e){
                menu = -1;
                scan.next();
            }

            switch (menu){
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
            return exit;
    }

    private void registerArtists() {
        System.out.println("registerArtist");
    }

    private void registerMusics() {
        System.out.println("registerMusics");
    }

    private void listMusics() {
        System.out.println("listMusics");
    }

    private void findMusicsByArtist() {
        System.out.println("findMusicsByArtist");
    }

    private void findArtist() {
        System.out.println("findArtist");
    }

}

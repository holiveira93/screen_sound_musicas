package com.example.screen_sound_musicas;

import java.util.Scanner;

public class Principal {
    Scanner scan = new Scanner(System.in);

    public void menu (){
        boolean repeat = true;
        do{
            System.out.println("""
                1 - Register artists
                2 - Register musics
                3 - List musics
                4 - Find musics by artist
                5 - Find data about a artist
                0 - Exit
                """);
            System.out.println(">> ");
            int menu = scan.nextInt();

            switch (menu){
                case 0:
                    repeat = false;
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
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(repeat);

    }
}

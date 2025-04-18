package MUSICS;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    public ArrayList<Music> playlist;
    User owner;
    String title;
    Playlist (User owner,String title) {
        this.owner = owner;
        this.title = title;
        playlist =new ArrayList<>();
    }
    public void editTitle (String newtitle,String password) {
        try {
            if (!(owner.getPassword()==password)) {
                throw new InvalidOperationException("Password is not correct");
            }
            System.out.println("edit music is successful");
            this.title =newtitle;
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

    }
    public void addMusic(Music music, String password) {
        try {
            if (!(owner.getPassword()== password)) {
                throw new InvalidOperationException("Password is not correct");
            }
            if (playlist.contains(music)) {
                throw new InvalidOperationException("This music is already in the playlist.");
            }
            playlist.add(music);
            System.out.println(music.getTitle()+" add music to playist !!!!!!");
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

    }
    public void removeMusic(Music music, String password) {
        try {
            if (!(owner.getPassword()==password)) {
                throw new InvalidOperationException("Password is not correct");
            }
            if (!(playlist.contains(music))) {
                throw new InvalidOperationException("This music is not in the playlist");
            }
            playlist.remove(music);
            System.out.println(music.getTitle() +" remove successful");
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<Music> searchInPlaylist(String title) {
            ArrayList<Music> result = new ArrayList<>();
            for (Music m :playlist) {
                if (m.getTitle() == title){
                    result.add(m);
                    System.out.println("found: "+ m.getTitle() + " by "+ m.getSinger().getUsername());
                }
            }
            return result;


    }
    public void playPlaylist() {
        Scanner scanner = new Scanner(System.in);
        for (Music music : playlist) {
            music.play();
            System.out.println("type 'next' to continue or anything else to stop:");
            String input = scanner.nextLine();
            if (!input.equals("next")) {
                break;
            }
        }
    }

}

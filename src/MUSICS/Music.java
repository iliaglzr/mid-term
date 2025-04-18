package MUSICS;

import java.util.ArrayList;

public class Music {
    String title;
    User singer;
    int numberOfStream;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        numberOfStream = 0;
        allMusics.add(this);
    }

    public void play() {
        numberOfStream++;
        System.out.println("playing:" + title + " singer name(by):" + singer.getUsername());
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title == title) {
                result.add(music);
            }
        }
        return result;
    }

    public static Music search(String title, String singerUsername) {
        try {
            for (Music music : allMusics) {
                if (music.title == title && music.singer.getUsername() == singerUsername) {
                    return music;
                }
            }
            throw new InvalidOperationException("i can't found it");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}


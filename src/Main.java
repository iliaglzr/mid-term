import MUSICS.InvalidOperationException;
import MUSICS.Music;
import MUSICS.Playlist;
import MUSICS.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("iliaglzr","2640iliA");
            User user2 = new User("behniaglzr","2640benii");
            user1.follow(user2);

            Music music1 = new Music("cigare soorati",user1);
            Music music2 = new Music("Baroon", user2);

            user1.playMusic(music1);
            user1.playMusic(music2);
            user1.playMusic(music1);
            user1.playMusic(music2);
            user1.playMusic(music1);
            //الان باید بخاطر اینکه کاربر عادی هستش لیمیت بخورع
            user1.playMusic(music2);

            user1.buyPremium(user1,6);

            user1.playMusic(music2);

            user1.createPlaylist("Favorites", user1);

            Playlist playlist1 =user1.getPlaylists().get(0);

            playlist1.addMusic(music1,"2640iliA");
            playlist1.addMusic(music2,"2640iliA");

            playlist1.removeMusic(music1,"2640iliA");


            playlist1.searchInPlaylist("Baroon");
        }catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
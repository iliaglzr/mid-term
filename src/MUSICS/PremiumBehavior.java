package MUSICS;

public class PremiumBehavior implements UserBehavior{
    int month;
    User owner;
    public PremiumBehavior(int month,User owner) {
        this.month = month;
        this.owner = owner;
    }
    public void createPlaylist (String Title, User Owner){
        Playlist playlist=new Playlist(Owner ,Title);
        Owner.getPlaylists().add(playlist);
        System.out.println("playlist:" +Title+"  created successful"+Owner.getUsername());
    }
    public void playMusic (Music music){
        music.play();
    }
   public void buyPremium (User owner, int month){
       this.month += month;
       System.out.println("Premium extended by " + month + " month(s). Total: " + this.month);
    }
}

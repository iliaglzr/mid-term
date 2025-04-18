package MUSICS;

public class RegularBehavior implements UserBehavior{
    private static final int MAX_PLAYS = 5;
    public static int playingLimit;
    public User user;
    public RegularBehavior(User user) {
        this.user = user;
        this.playingLimit = MAX_PLAYS;
    }

    @Override
    public void createPlaylist (String title , User Owner) throws InvalidOperationException{
        var Excepation = new InvalidOperationException("You cant use this ability");
        throw Excepation;
    }
    @Override
    public void playMusic (Music music) {
    try {
        if (playingLimit > 0) {
            music.play();
            playingLimit--;
        }
    }catch (InvalidOperationException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
    @Override
   public void buyPremium (User owner, int month) {

    }


}

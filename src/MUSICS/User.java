package MUSICS;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;

    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException {
        for (User user : allUsers) {
            if (user.username == username) {
                throw new InvalidOperationException("its user already exist");
            }

        }
        if (password.length() < 8) {
            throw new InvalidOperationException("Password must be at least 8 characters long.");
        }

        this.username = username;
        this.password = password;
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.behavior = new RegularBehavior(this);

        allUsers.add(this);
    }


    public void follow(User user) {
        if (!this.followingList.contains(user)) {
            this.followingList.add(user);
            user.followerList.add(this);
        }
    }

    public void createPlaylist(String title, User owner) throws InvalidOperationException {
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic(Music music) throws InvalidOperationException {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month,owner));


        System.out.println("update to premium account");
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

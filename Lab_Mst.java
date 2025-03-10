import java.util.*;

class Video {
    String title;
    boolean isRented;

    Video(String title) {
        this.title = title;
        this.isRented = false;
    }

    void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(title + " rented out.");
        } else {
            System.out.println(title + " is already rented.");
        }
    }

    void returnVideo() {
        if (isRented) {
            isRented = false;
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " was not rented.");
        }
    }

    @Override
    public String toString() {
        return title + (isRented ? " (Rented)" : " (Available)");
    }
}

class Inventory {
    List<Video> videos = new ArrayList<>();

    void addVideo(String title) {
        videos.add(new Video(title));
        System.out.println("Added: " + title);
    }

    void rentVideo(String title) {
        for (Video video : videos) {
            if (video.title.equalsIgnoreCase(title)) {
                video.rent();
                return;
            }
        }
        System.out.println("Video not found.");
    }

    void returnVideo(String title) {
        for (Video video : videos) {
            if (video.title.equalsIgnoreCase(title)) {
                video.returnVideo();
                return;
            }
        }
        System.out.println("Video not found.");
    }

    void showInventory() {
        System.out.println("Inventory:");
        for (Video video : videos) {
            System.out.println(video);
        }
    }
}

public class VideoRentalStore {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addVideo("Inception");
        inventory.addVideo("The Matrix");
        inventory.addVideo("The Godfather");

        inventory.showInventory();
        inventory.rentVideo("The Matrix");
        inventory.returnVideo("The Godfather");
        inventory.showInventory();
    }
}

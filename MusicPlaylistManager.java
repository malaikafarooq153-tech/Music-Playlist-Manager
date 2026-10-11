package src;
import java.util.Scanner;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Playlist playlist = new Playlist();
        SongStack recentPlayed = new SongStack();

        int choice = 0;

        while (choice != 9) {
            System.out.println("\n=== MUSIC PLAYLIST MANAGER ===");
            System.out.println("1. Display Playlist");
            System.out.println("2. Add Song");
            System.out.println("3. Remove Song");
            System.out.println("4. Search Song");
            System.out.println("5. Sort Playlist");
            System.out.println("6. Play Song");
            System.out.println("7. Recently Played");
            System.out.println("8. Undo Last Play Record");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            // Validate menu input
            if (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                playlist.displaySongs();

            } else if (choice == 2) {
                System.out.print("Enter song name: ");
                String name = input.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Song name cannot be empty.");
                } else {
                    playlist.addSong(name);
                    System.out.println("Song added.");
                }

            } else if (choice == 3) {
                System.out.print("Enter song to remove: ");
                String name = input.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Song name cannot be empty.");
                } else {
                    playlist.removeSong(name);
                }

            } else if (choice == 4) {
                System.out.print("Enter song to search: ");
                String name = input.nextLine();

                if (playlist.searchSong(name)) {
                    System.out.println("Song found.");
                } else {
                    System.out.println("Song not found.");
                }

            } else if (choice == 5) {
                playlist.sortSongs();

            } else if (choice == 6) {
                System.out.print("Enter song to play: ");
                String name = input.nextLine();

                if (playlist.searchSong(name)) {
                    recentPlayed.push(name);
                    System.out.println("Now playing: " + name);
                } else {
                    System.out.println("Song not found in playlist.");
                }

            } else if (choice == 7) {
                recentPlayed.display();

            } else if (choice == 8) {
                String song = recentPlayed.pop();

                if (song == null) {
                    System.out.println("Play history is empty.");
                } else {
                    System.out.println(
                        "Removed from play history: " + song);
                }

            } else if (choice == 9) {
                System.out.println("Program ended.");

            } else {
                System.out.println("Invalid choice. Enter 1 to 9.");
            }
        }

        input.close();
    }
}
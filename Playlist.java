package src;
public class Playlist {
    Node head;

    // Add six default songs
    public Playlist() {
        addSong("Perfect");
        addSong("Shape of You");
        addSong("Believer");
        addSong("Faded");
        addSong("Memories");
        addSong("Love Yourself");
    }

    // Add a song at the end
    public void addSong(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Display all songs
    public void displaySongs() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        int number = 1;

        while (temp != null) {
            System.out.println(number + ". " + temp.data);
            temp = temp.next;
            number++;
        }
    }

    // Search using Linear Search
    public boolean searchSong(String name) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.equalsIgnoreCase(name)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Remove a song from the doubly linked list
    public void removeSong(String name) {
        Node temp = head;

        // Find the song
        while (temp != null &&
               !temp.data.equalsIgnoreCase(name)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Song not found.");
            return;
        }

        // Update the previous node or head
        if (temp.prev == null) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        // Update the next node's previous link
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        System.out.println("Song removed.");
    }

    // Sort songs using Bubble Sort
    public void sortSongs() {
        if (head == null || head.next == null) {
            System.out.println("Not enough songs to sort.");
            return;
        }

        boolean swapped;

        do {
            swapped = false;
            Node temp = head;

            while (temp.next != null) {
                if (temp.data.compareToIgnoreCase(
                        temp.next.data) > 0) {

                    String oldName = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = oldName;

                    swapped = true;
                }

                temp = temp.next;
            }
        } while (swapped);

        System.out.println("Playlist sorted alphabetically.");
    }
}
package src;
public class SongStack {
    Node top;
    int count = 0;

    // Push a song onto the stack
    public void push(String song) {
        Node newNode = new Node(song);

        newNode.next = top;
        top = newNode;
        count++;
    }

    // Pop the top song
    public String pop() {
        if (isEmpty()) {
            return null;
        }

        String song = top.data;
        top = top.next;
        count--;

        return song;
    }

    // View the top song
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Return stack size
    public int size() {
        return count;
    }

    // Display recently played songs
    public void display() {
        if (isEmpty()) {
            System.out.println("No recently played songs.");
            return;
        }

        Node temp = top;

        System.out.println("Recently played songs:");

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        System.out.println("Stack size: " + size());
        System.out.println("Top song: " + peek());
    }
}
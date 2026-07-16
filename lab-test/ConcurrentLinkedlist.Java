import java.util.concurrent.Semaphore;

class Node {
    int key;
    Node next;
    
    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}

class List {
    Node head;
    Semaphore lock;

    public List() {
        this.head = null;
        this.lock = new Semaphore(1);
    }

    public int listInsert(int key) {
        Node newNode = new Node(key);
        
        try {
            lock.acquire();
            newNode.next = head;
            head = newNode;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            lock.release();
        }
        return 0;
    }

    public int listLookup(int key) {
        try {
            lock.acquire();
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    lock.release();
                    return 0;
                }
                curr = curr.next;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            lock.release();
        }
        return -1;
    }
}
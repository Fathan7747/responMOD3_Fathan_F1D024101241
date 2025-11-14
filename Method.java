public class Method {

    Node head;

    // Tambah node di akhir
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Cetak Linked List
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Copy list
    public Method copyList() {
        Method newList = new Method();
        Node temp = this.head;
        while (temp != null) {
            newList.addLast(temp.data);
            temp = temp.next;
        }
        return newList;
    }
    
    // SELECTION SORT
    public void selectionSort() {
        for (Node i = head; i != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.data < min.data) {
                    min = j;
                }
            }
            int temp = i.data;
            i.data = min.data;
            min.data = temp;
        }
    }

    // INSERTION SORT
    public void insertionSort() {
        if (head == null || head.next == null) return;

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || current.data < sorted.data) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data < current.data) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        head = sorted;
    }


    // LINEAR SEARCH
    public int linearSearch(int target) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == target) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // BINARY SEARCH 
    private Node getMid(Node start, Node end) {
        Node slow = start;
        Node fast = start;

        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public int binarySearch(int target) {
        Node start = head;
        Node end = null;

        while (start != end) {
            Node mid = getMid(start, end);

            // Hitung index mid
            int midIndex = 0;
            Node temp = head;
            while (temp != mid) {
                temp = temp.next;
                midIndex++;
            }

            if (mid.data == target)
                return midIndex;
            else if (mid.data < target)
                start = mid.next;
            else
                end = mid;
        }
        return -1;
    }
}

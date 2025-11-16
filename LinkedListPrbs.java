class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListSolutions {
    public Node convertArrayToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        Node temp;

        for (int idx = 1; idx < arr.length; idx++) {
            temp = new Node(arr[idx]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int findLength(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        return count;
    }

    public boolean findElement(Node head, int ele) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == ele) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public Node deleteHead(Node head) {
        if (head == null)
            return head;

        head = head.next;

        return head;
    }

    public Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public Node deleteAtK(Node head, int k) {
        if (head == null)
            return head;

        if (k == 1) {
            head = head.next;
            return head;
        }

        Node temp = head, prev = null;
        int count = 1;

        while (temp != null) {
            if (count == k) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    public Node deleteValue(Node head, int val) {
        if (head == null)
            return head;

        if (head.data == val) {
            head = head.next;
            return head;
        }

        Node temp = head, prev = null;

        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public Node insertAtTail(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);

        return head;
    }

    public Node insertAtK(Node head, int val, int k) {
        if (head == null) {
            if (k == 1)
                return new Node(val);
            else
                return null;
        }

        if (k == 1) {
            return new Node(val, head);
        }

        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count + 1 == k) {
                temp.next = new Node(val, temp.next);
                break;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }

    public Node insertBeforeVal(Node head, int val, int k) {
        if (head == null)
            return null;

        if (head.data == k) {
            return new Node(val, head);
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == k) {
                temp.next = new Node(val, temp.next);
                break;
            }
            temp = temp.next;
        }

        return head;
    }
}

public class LinkedListPrbs {

    public static void main(String[] args) {
        LinkedListSolutions solution = new LinkedListSolutions();
        int[] arr = new int[] { 3, 4, 9, 8, 5 };
        Node head = solution.convertArrayToLL(arr);
        // Node newHead = new Node(23, head);
        head = solution.insertBeforeVal(head, 100, 9);
        solution.printLL(head);
    }
}

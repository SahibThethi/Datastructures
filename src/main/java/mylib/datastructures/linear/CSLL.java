package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.*;


public class CSLL extends SLL {

        public CSLL() {
            super();
            this.size = 0;
        }
    
        public CSLL(SNode head) {
            super(head);
            head.setNext(head);
            this.size = 1;
        }
    
        @Override
        public void insertHead(SNode node) {
            super.insertHead(node);
            this.tail.setNext(this.head);
            size++;
        }
    
        @Override
        public void insertTail(SNode node) {
            super.insertTail(node);
            this.tail.setNext(this.head);
            size++;
        }
    
        @Override
        public void insert(SNode node, int position) {
            super.insert(node, position);
            this.tail.setNext(this.head);
            size++;
        }
    
        public void deleteHead() {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
            size--;
        }
    
        
        public SNode search(int data) {
            if (head == null) {
                throw new NullPointerException("List is empty");
            }
            SNode curr = head;
            do {
                if (curr.data == data) {
                    return curr;
                }
                curr = curr.getNext();
            } while (curr != head);
            return null;
        }
    
        public void deleteTail() {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            SNode curr = this.head;
            while (curr.getNext() != this.tail) {
                curr = curr.getNext();
            }
            curr.setNext(this.head);
            this.tail = curr;
            size--;
        }
    
        public void delete(SNode node) {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            SNode curr = this.head;
            while (curr.getNext() != node) {
                curr = curr.getNext();
            }
            curr.setNext(node.getNext());
            size--;
        }
    
        public void sort() {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            SNode curr = this.head;
            SNode min = curr;
            SNode temp = null;
            while (curr.getNext() != this.head) {
                min = curr;
                temp = curr.getNext();
                while (temp != this.head) {
                    if (temp.data < min.data) {
                        min = temp;
                    }
                    temp = temp.getNext();
                }
                int tempData = curr.data;
                curr.data = min.data;
                min.data = tempData;
                curr = curr.getNext();
            }
        }
    
        public void clear() {
            this.head = null;
            this.tail = null;
            size = 0;
        }

        public void print() {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            // Print the length of the list
            System.out.println("List length: " + size);
        
            // Check if the list is sorted
            boolean sorted = true;
            SNode curr = this.head;
            while (curr.getNext() != this.head) {
                if (curr.data > curr.getNext().data) {
                    sorted = false;
                    break;
                }
                curr = curr.getNext();
            }
            // Print the sorted status of the list
            System.out.println("Sorted status: " + (sorted ? "sorted" : "unsorted"));
        
            // Print the list content
            curr = this.head;
            System.out.print("List content: ");
            while (curr.getNext() != this.head) {
                System.out.print(curr.data + " ");
                curr = curr.getNext();
            }
            System.out.println(curr.data);
        }
        
    
        public void sortedInsert(SNode node) {
            if (this.head == null) {
                throw new NullPointerException("List is empty");
            }
            SNode curr = this.head;
            while (curr.getNext() != this.head) {
                if (curr.data < node.data && curr.getNext().data > node.data) {
                    node.setNext(curr.getNext());
                    curr.setNext(node);
                    size++;
                    return;
                }
                curr = curr.getNext();
            }
            if (curr.data < node.data) {
                node.setNext(curr.getNext());
                curr.setNext(node);
                size++;
            }
        }
}


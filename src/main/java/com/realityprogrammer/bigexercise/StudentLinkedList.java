package com.realityprogrammer.bigexercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class StudentLinkedList implements Cloneable {
    // Store both the first and last nodes to optimize add/remove first/last operations.
    private LinkedListNode<Student> head;
    private LinkedListNode<Student> last;

    private int length;

    public StudentLinkedList() { }

    public Boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Student student) {
        if (head == null) {
            head = last = new LinkedListNode<>(student);
        } else {
            head = new LinkedListNode<>(student, head);
        }

        length++;
    }

    public void addLast(Student student) {
        if (head == null) {
            head = last = new LinkedListNode<>(student);
        } else {
            var newNode = new LinkedListNode<>(student);
            last.setNext(newNode);
            last = newNode;
        }

        length++;
    }

    public void addAt(Student student, int index) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException("Insert index must be between the bounds of the list.");

        if (index == 0) {   //
            addFirst(student);
        } else if (index == length) {
            addLast(student);
        } else {
            LinkedListNode<Student> node = new LinkedListNode<>(student);

            int position = 1;
            for (var current = head; current != null; current = current.getNext()) {
                if (position == index) {
                    var next = current.getNext();
                    current.setNext(node);
                    node.setNext(next);

                    break;
                }

                position++;
            }

            length++;
        }
    }

    public void removeFirst() {
        if (head == null) return;

        if (head == last) {
            head = last = null;
        } else {
            head = head.getNext();
        }

        length--;
    }

    public void removeLast() {
        if (head == null) return;
        if (head == last) {
            head = last = null;

            length--;
        }

        LinkedListNode<Student> current = head;
        LinkedListNode<Student> next = current.getNext();

        while (next.getNext() != null) {
            current = next;
            next = next.getNext();
        }

        current.setNext(null);

        last = current;

        length--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= length) return;

        if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            int position = 1;

            var current = head;
            for (var next = current.getNext(); next != null; next = next.getNext()) {
                if (position == index) {
                    current.setNext(next.getNext());
                    length--;

                    break;
                }

                position++;
                current = next;
            }
        }
    }

    public void clear() {
        head = last = null;
        length = 0;
    }

    public int size() {
        return length;
    }

    public Object clone() {
        StudentLinkedList list = new StudentLinkedList();

        for (var current = head; current != null; current = current.getNext()) {
            list.addLast((Student)current.getValue().clone());
        }

        return list;
    }

    public void sort(Comparator<Student> comparator) {
        if (head == null) return;

        for (var current = head; current != null; current = current.getNext()) {
            for (var next = current.getNext(); next != null; next = next.getNext()) {
                if (comparator.compare(current.getValue(), next.getValue()) > 0) {
                    var temp = current.getValue();
                    current.setValue(next.getValue());
                    next.setValue(temp);
                }
            }
        }
    }

    public Student getHead() {
        return head == null ? null : head.getValue();
    }

    public Student getLast() {
        return last == null ? null : last.getValue();
    }

    public LinkedListNode<Student> getHeadNode() {
        return head;
    }

    public LinkedListNode<Student> getLastNode() {
        return last;
    }
}

package org.example;

import java.util.LinkedList;

public class DoubleLinkedCharacterList implements CharacterList{

  private Node head;
  private Node tail;
  private int length = 0;

  @Override
  public int length() {
    return length;
  }

  @Override
  public void append(Character element) {
    Node newNode = new Node(element);
    Node prevTail = this.tail;
    newNode.prev = prevTail;
    this.tail = newNode;
    if (prevTail == null) this.head = newNode;
    else prevTail.next = newNode;
    length++;
  }

  @Override
  public void insert(Character element, int idx) {
    Node currNode = getNode(idx);
    Node node = new Node(element);
    length++;
    if (currNode == head) {
      head = node;
      node.next = currNode;
      return;
    }
    Node prevNode = currNode.prev;
    prevNode.next = node;
    currNode.prev = node;
    node.next = currNode;
    node.prev = prevNode;
  }

  private Node getNodeFromTail(int idx) {
    int currIdx = this.length() - 1;
    Node currNode = tail;
    while (currIdx != idx) {
      currNode = currNode.prev;
      currIdx--;
    }
    return currNode;
  }

  private Node getNodeFromHead(int idx) {
    int currIdx = 0;
    Node currNode = head;
    while (currIdx != idx) {
      currNode = currNode.next;
      currIdx++;
    }
    return currNode;
  }

  @Override
  public Character delete(int idx) {
    Node currNode = getNode(idx);
    Node prevNode = currNode.prev;
    Node nextNode = currNode.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    length--;
    return currNode.element;
  }

  @Override
  public void deleteAll(Character element) {
    Node currNode = head;
    while (currNode != null) {
      Node next = currNode.next;
      if (currNode.element.equals(element)) {
        if (currNode == head) head = currNode.next;
        if (currNode == tail) tail = currNode.prev;
        Node prev = currNode.prev;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        length--;
      }
      currNode = next;
    }
  }

  @Override
  public Character get(int idx) {
    Node node = getNode(idx);
    return node.element;
  }

  private Node getNode(int idx) {
    if (idx < 0 || idx >= length) throw new IllegalArgumentException();
    return idx >= length / 2 ? getNodeFromTail(idx) : getNodeFromHead(idx);
  }

  @Override
  public CharacterList clone() {
    CharacterList list = new DoubleLinkedCharacterList();
    Node currNode = head;
    while (currNode != null) {
      list.append(currNode.element);
      currNode = currNode.next;
    }
    return list;
  }

  @Override
  public void reverse() {
    Node currNode = this.tail;
    this.head = null;
    this.tail = null;
    length = 0;
    while (currNode != null) {
      this.append(currNode.element);
      currNode = currNode.prev;
    }
  }

  @Override
  public int findFirst(Character element) {
    int idx = 0;
    Node currNode = head;
    while (currNode != null) {
      if (currNode.element.equals(element)) return idx;
      idx++;
      currNode = currNode.next;
    }
    return 0;
  }

  @Override
  public int findLast(Character element) {
    int idx = this.length - 1;
    Node currNode = tail;
    while (currNode != null) {
      if (currNode.element.equals(element)) return idx;
      idx--;
      currNode = currNode.prev;
    }
    return 0;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    length = 0;
  }

  @Override
  public void extend(CharacterList elements) {
    int idx = 0;
    int length = elements.length();
    while (idx < length) this.append(elements.get(idx++));
  }


  private static class Node {
    Node prev;
    Node next;
    Character element;

    Node(Character element) {
      this.element = element;
    }

  }

}

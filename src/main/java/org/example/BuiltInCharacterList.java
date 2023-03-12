package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuiltInCharacterList implements CharacterList {

  private List<Character> list = new ArrayList<>();

  public BuiltInCharacterList() {}


  private BuiltInCharacterList(List<Character> list) {
    this.list = list;
  }

  @Override
  public int length() {
    return list.size();
  }

  @Override
  public void append(Character element) {
    list.add(element);
  }

  @Override
  public void insert(Character element, int idx) {
    if (idx < 0 || idx >= this.length()) throw new IllegalArgumentException();
    list.add(idx, element);
  }

  @Override
  public Character delete(int idx) {
    if (idx < 0 || idx >= this.length()) throw new IllegalArgumentException();
    return list.remove(idx);
  }

  @Override
  public void deleteAll(Character element) {
    while (list.contains(element)) list.remove(element);
  }

  @Override
  public Character get(int idx) {
    if (idx < 0 || idx >= this.length()) throw new IllegalArgumentException();
    return list.get(idx);
  }

  @Override
  public CharacterList clone() {
    List<Character> listCopy = new ArrayList<>(list);
    return new BuiltInCharacterList(listCopy);
  }

  @Override
  public void reverse() {
    Collections.reverse(list);
  }

  @Override
  public int findFirst(Character element) {
    return list.indexOf(element);
  }

  @Override
  public int findLast(Character element) {
    return list.lastIndexOf(element);
  }

  @Override
  public void clear() {
    list.clear();
  }

  @Override
  public void extend(CharacterList elements) {
    int idx = 0;
    while (idx < elements.length()) list.add(elements.get(idx++));
  }

}

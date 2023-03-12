package org.example;

public interface CharacterList {

  int length();

  void append(Character element);

  void insert(Character element, int idx);

  Character delete(int idx);

  void deleteAll(Character element);

  Character get(int idx);

  CharacterList clone();

  void reverse();

  int findFirst(Character element);

  int findLast(Character element);

  void clear();

  void extend(CharacterList elements);

}

package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public abstract class CharacterListTest {

  protected CharacterList characterList;

  @Test
  public void testLength() {
    int expLength = 3;
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    assertEquals(expLength, characterList.length());
  }

  @Test
  public void testAppend() {
    int length = characterList.length();
    characterList.append('D');
    assertEquals(length + 1, characterList.length());
    assertNotEquals(characterList.findFirst('D'), -1);
  }

  @Test
  public void testInsert() {
    int expIdx = 0;
    characterList.append('A');
    characterList.append('B');
    characterList.insert('C', expIdx);
    assertEquals(expIdx, characterList.findFirst('C'));
  }

  @Test
  public void testDelete() {
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    assertSame('B', characterList.delete(1));
  }

  @Test
  public void testDeleteAll() {
    characterList.append('A');
    characterList.append('B');
    characterList.append('A');
    characterList.append('C');
    characterList.deleteAll('A');
    assertEquals(-1, characterList.findFirst('A'));
    assertEquals(-1, characterList.findLast('A'));
  }

  @Test
  public void testGet() {
    characterList.append('A');
    assertSame('A', characterList.get(0));
  }

  @Test
  public void testClone() {
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    CharacterList copyList = characterList.clone();
    assertNotSame(copyList, characterList);
    assertSame(characterList.get(0), copyList.get(0));
    assertSame(characterList.get(1), copyList.get(1));
    assertSame(characterList.get(2), copyList.get(2));
  }

  @Test
  public void testReverse() {
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    characterList.append('D');
    characterList.reverse();
    assertSame('D', characterList.get(0));
    assertSame('C', characterList.get(1));
    assertSame('B', characterList.get(2));
    assertSame('A', characterList.get(3));
  }

  @Test
  public void testClear() {
    int expLength = 0;
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    characterList.clear();
    assertEquals(expLength, characterList.length());
  }

  @Test
  public void testExtend() {
    characterList.append('A');
    characterList.append('B');
    characterList.append('C');
    CharacterList extendList = new BuiltInCharacterList();
    extendList.append('D');
    extendList.append('E');
    characterList.extend(extendList);
    assertSame('D', characterList.get(3));
    assertSame('E', characterList.get(4));
    assertEquals(5, characterList.length());
  }

}

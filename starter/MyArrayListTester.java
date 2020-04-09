/* TODO: */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Arrays;


import org.junit.*;

public class MyArrayListTester {

  static final int DEFAULT_CAPACITY = 10;
  static final int MY_CAPACITY = 3;

  Object[] arr = new Object[10];
  Integer[] arrInts = {1,2,3};

  private MyArrayList list1, list2, list3, list4, list5;

  @Before
  public void setUp() throws Exception {
    list1 = new MyArrayList();
    list2 = new MyArrayList(DEFAULT_CAPACITY);
    list3 = new MyArrayList(MY_CAPACITY);
    list4 = new MyArrayList(arr);
    list5 = new MyArrayList<Integer>(arrInts);
  }

  @Test
  public void testInvalidConstructor() {
    try {
      MyArrayList<Integer> invalid = new MyArrayList<Integer>(-1);
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Pass
    }
  }

  @Test
  public void testDefaultSize() {
    assertEquals("Check size for default constructor", 0, list1.size());
    assertEquals("Check size for constructor with given capacity of 10", 0, list2.size());
    assertEquals("Check size for constructor with given capacity of 3", 0, list3.size());
    assertEquals("Check size for constructor with given array", 10, list4.size());
    assertEquals("Check size for constructor with given int array", 3, list5.size());
  }
  
  @Test
  public void testInitialCapacity() {
    assertEquals("Check default capacity", DEFAULT_CAPACITY, list1.getCapacity());
    assertEquals("Check given capacity", MY_CAPACITY, list3.getCapacity());
  }

  @Test
  public void testAppend() {
    int[] nums = {2,4};
    list1.append(nums[0]);
    assertEquals("Check that append increments size", 1, list1.size());
    list1.append(nums[1]);
    assertEquals("Check that capacity is unchanged", DEFAULT_CAPACITY, list1.getCapacity());
  }
}

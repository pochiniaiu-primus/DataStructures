package com.serhiihoncar.datastructures.list;

/**
 * // add value to the end of the list
 * void add(Object value);
 * <p>
 * // [A, B, C, null, null] size = 3
 * // add (D, [0,1,2,3]) => add(F, 4)
 * // we can add value by index between [0, size]
 * // otherwise throw new IndexOutOfBoundsException
 * void add(Object value, int index);
 * <p>
 * // we can remove value by index between [0, size - 1]
 * // otherwise throw new IndexOutOfBoundsException
 * <p>
 * // [A, B, C] remove = 0
 * // [B (index = 0) , C (index = 1)]
 * Object remove(int index);
 * <p>
 * // [A, B, C, null, null] size = 3
 * // we can get value by index between [0, size - 1]
 * // otherwise throw new IndexOutOfBoundsException
 * Object get(int index);
 * <p>
 * // we can set value by index between [0, size - 1]
 * // otherwise throw new IndexOutOfBoundsException
 * Object set(Object value, int index);
 * <p>
 * void clear();
 * <p>
 * int size();
 * <p>
 * boolean isEmpty();
 * <p>
 * boolean contains(Object value);
 * <p>
 * // [A, B, A, C] indexOf(A) -> 0
 * // -1 if not exist
 * int indexOf(Object value);
 * <p>
 * // [A, B, A, C] lastIndexOf(A) -> 2
 * int lastIndexOf(Object value);
 * <p>
 * // [A, B, C]
 * String toString();
 */
public class ArrayList implements List {
    private final int INIT_SIZE = 16;
    private Object[] array;
    private int size = 0;

    public ArrayList() {
        array = new Object[INIT_SIZE];
    }

    @Override
    public void add(Object value) {
        if (value == null) {
            throw new NullPointerException("You can't add null as element");
        }
        if (array.length - size <= 12) {
            ensureCapacity();
        }
        array[size] = value;
//        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void add(Object value, int index) {
        if (value == null) {
            throw new NullPointerException("You can't add null as element");
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("Wrong index for this element");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < size) {
            Object obj = array[index];
            array[index] = null;
            int temp = index;
            while (temp < size) {
                array[temp] = array[temp + 1];
                array[temp + 1] = null;
                temp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        if (index < size) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    // we can set value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    @Override
    public Object set(Object value, int index) {
        if (value == null) {
            throw new NullPointerException("You can't set null as element");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index] = value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInArrayList = array[i];
            if (value.equals(valueInArrayList)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i == size - 1) {
                break;
            } else {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }
}
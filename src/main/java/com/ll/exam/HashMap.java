package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    HashMap() {
        keys = new Object[2];
        values = new Object[2];
        size = 0;
    }

    public void put(K key, V value) {
        if (isExistKey(key)) {
            changeValue(key, value);
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public void changeValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
            }
        }
    }

    public boolean isExistKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public void remove(K key) {
        int idx = findIndex(key);
        for (int i = idx + 1; i < size; i++) {
            keys[i - 1] = keys[i];
            values[i - 1] = values[i];
        }
        size--;
    }

    public List<K> keySet() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add((K) keys[i]);
        }
        return keyList;
    }
}

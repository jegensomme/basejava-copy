package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
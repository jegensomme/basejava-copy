package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        int index = (Integer) searchKey;
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        storage.add(index, r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        int index = (Integer) searchKey;
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        }
        storage.add(r);
    }

    @Override
    protected Resume doGet(String uuid, Object searchKey) {
        int index = (Integer) searchKey;
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(index);
    }

    @Override
    protected void doDelete(String uuid, Object searchKey) {
        int index = (Integer) searchKey;
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        storage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.stream().toArray(Resume[]::new);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume resume =  storage.stream().
                filter(r -> r.getUuid() == uuid).
                findFirst().
                orElse(null);
        return storage.indexOf(resume);
    }
}

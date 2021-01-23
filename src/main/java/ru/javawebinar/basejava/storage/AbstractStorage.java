package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public abstract void clear();

    @Override
    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    protected abstract void doUpdate(Resume r, Object searchKey);

    @Override
    public void save(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    protected abstract void doSave(Resume r, Object searchKey);

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        return doGet(uuid, searchKey);
    }

    protected abstract Resume doGet(String uuid, Object searchKey);

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        doDelete(uuid, searchKey);
    }

    protected abstract void doDelete(String uuid, Object searchKey);

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract int size();

    protected abstract Object getSearchKey(String uuid);
}

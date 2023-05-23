package com.github.vertineko.android.dao;

import com.github.vertineko.android.model.Exfile;

public interface FileDao {
    public void addFile(Exfile file);
    public Exfile getfile(int id);
}

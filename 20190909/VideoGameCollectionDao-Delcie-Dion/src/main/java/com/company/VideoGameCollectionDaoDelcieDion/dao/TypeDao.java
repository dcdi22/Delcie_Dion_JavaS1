package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Type;

import java.util.List;

public interface TypeDao {

    Type addType(Type type);

    Type getType(int id);

    List<Type> getAllTypes();

    void updateType(Type type);

    void deleteType(int id);

}

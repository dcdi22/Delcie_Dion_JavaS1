package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int id);

}

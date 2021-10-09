package service;

import entity.User;

import java.util.List;

public interface NoteService {

        User getById(Long id);

        List<User> getAll();

        void deleteById(Long id);

        void saveOrUpdate(String username,String nameFile, String pathFile);

}

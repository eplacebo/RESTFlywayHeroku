package service.impl;

import entity.Event;
import entity.FileInfo;
import entity.User;
import repository.EventRepository;
import repository.FileRepository;
import repository.UserRepository;
import repository.impl.EventRepositoryImpl;
import repository.impl.FileRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.NoteService;

import java.util.Collections;
import java.util.List;


public class NoteServiceImpl implements NoteService {

    UserRepository userRepository = new UserRepositoryImpl();
    EventRepository eventRepository = new EventRepositoryImpl();
    FileRepository fileRepository = new FileRepositoryImpl();

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(String username, String nameFile, String pathFile) {
        if (userRepository.getByUsername(username) == null) {
            userRepository.save(new User(username, Collections.singletonList(eventRepository.save(new Event(fileRepository.save(new FileInfo(nameFile, pathFile)))))));
        } else {
            List<Event> list = userRepository.getByUsername(username).getEventList();
            list.add(new Event(new FileInfo(nameFile, pathFile)));
            User user = userRepository.getByUsername(username);
            user.setEventList(list);
            userRepository.save(user);
        }
    }
}




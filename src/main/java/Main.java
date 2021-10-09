
import entity.User;
import repository.impl.UserRepositoryImpl;
import service.impl.NoteServiceImpl;

public class Main {

    public static void main(String[] args) {

        NoteServiceImpl noteService = new NoteServiceImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();

    }
}

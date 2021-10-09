package repository;

import entity.User;

public interface UserRepository extends GenericRepository<User, Long > {
    User getByUsername(String string);
}

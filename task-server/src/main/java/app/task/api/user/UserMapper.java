package app.task.api.user;

import app.task.domain.User;

public interface UserMapper {

    User findById(String id);

}
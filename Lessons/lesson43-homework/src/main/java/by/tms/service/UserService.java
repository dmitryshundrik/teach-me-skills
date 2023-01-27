package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.entity.Address;
import by.tms.entity.Telephone;
import by.tms.entity.User;
import by.tms.model.RegistrationUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    @Qualifier("jpaUserDao")
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(long id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public User userModelToUserConverter(RegistrationUserModel registrationUserModel) {
        User user = new User();
        List<Telephone> telephones = new ArrayList<>(2);
        telephones.add(new Telephone(0, registrationUserModel.getFirstNumber()));
        telephones.add(new Telephone(0, registrationUserModel.getSecondNumber()));

        user.setName(registrationUserModel.getName());
        user.setUsername(registrationUserModel.getUsername());
        user.setPassword(registrationUserModel.getPassword());
        user.setAddress(new Address(0, registrationUserModel.getCity(), registrationUserModel.getStreet()));
        user.setTelephones(telephones);
        user.setRole(registrationUserModel.getRole());

        return user;
    }
}

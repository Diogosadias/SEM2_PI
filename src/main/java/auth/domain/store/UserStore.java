package auth.domain.store;

import app.domain.model.Store;
import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

import java.util.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class UserStore extends Store {

    private User user;

    private Set<User> store = new HashSet<User>();


    public User create(String name, String email, String password)
    {
        this.user = new User(new Email(email), new Password(password), name);
        return user;
    }

    public boolean add(User user)
    {
        if (user != null) {
            if (!exists(user))
                return this.store.add(user);
        }
        return false;
    }

    public boolean remove(User user)
    {
        if (user != null)
            return this.store.remove(user);
        return false;
    }

    public Optional<User> getById(String email)
    {
        return this.getById(new Email(email));
    }

    public Optional<User> getById(Email email)
    {
        for(User user: this.store)
        {
            if(user.hasId(email))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean exists(String email)
    {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(Email email)
    {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(User user)
    {
        return this.store.contains(user);
    }

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        List<Object> list = new ArrayList<>();
        for(User u: store) {
            list.add(u);
        }
        return list;
    }

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/user.txt";
    }

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.user = (User) o;
        this.add(user);
    }
}

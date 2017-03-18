package com.novauc;

/**
 * Created by souporman on 3/14/17.
 */
public interface UserInterface {

    //ILL USE THIS LATER
    User getUserByEmail(final String email);
    boolean login(final String email, final String password);
    User create(final User user);
    User update(User user);
    void remove(final User user);

}

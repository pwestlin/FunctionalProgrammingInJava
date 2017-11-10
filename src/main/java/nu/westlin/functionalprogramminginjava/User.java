package nu.westlin.functionalprogramminginjava;

import java.time.LocalDate;
import java.util.Objects;

public final class User {
    public final String username;
    public final String firstname;
    public final String lastname;
    public final Country country;
    public final LocalDate passwordExpires;

    public User(
        final String username,
        final String firstname,
        final String lastname,
        final Country country,
        final LocalDate passwordExpires) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.passwordExpires = passwordExpires;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
            Objects.equals(firstname, user.firstname) &&
            Objects.equals(lastname, user.lastname) &&
            Objects.equals(country, user.country);
    }

    @Override public int hashCode() {
        return Objects.hash(username, firstname, lastname, country);
    }

}

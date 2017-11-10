package nu.westlin.functionalprogramminginjava;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static nu.westlin.functionalprogramminginjava.UserRepository.*;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class FunctionCompositionTest {
    final UserRepository repository = new UserRepository();

    // Function Composition

    @Test
    public void sortUsersByPasswordExpires_stream() {
        List<User> sortedByPasswordExipres =
            repository.getAll().stream()
                //.sorted((x, y) -> x.passwordExpires.compareTo(y.passwordExpires))
                .sorted(Comparator.comparing(x -> x.passwordExpires)) // Detta är precis samma sak som raden ovan
                .collect(Collectors.toList());

        assertThat(sortedByPasswordExipres, contains(PSTORMARE, PVESTLIN, PPAN, PSTORE, DTRUMP, DDUCK));
    }

    // Funktion för att sortera users mha passwordExpires
    Function<List<User>, List<User>> sortByPasswordExipres = users -> users.stream()
        .sorted(Comparator.comparing(x -> x.passwordExpires)) // Detta är precis samma sak som raden ovan
        .collect(Collectors.toList());

    @Test
    public void sortUsersByPasswordExpires_function() {
        List<User> sortedByPasswordExipres = sortByPasswordExipres.apply(repository.getAll());

        assertThat(sortedByPasswordExipres, contains(PSTORMARE, PVESTLIN, PPAN, PSTORE, DTRUMP, DDUCK));
    }

    @Test
    public void usersWithFirstnamePeterSortedByPasswordExpires_stream() {
        List<User> sortedByPasswordExipres =
            repository.getAll().stream()
                .filter(user -> user.firstname.equals("Peter"))
                .sorted(Comparator.comparing(x -> x.passwordExpires))
                .collect(Collectors.toList());

        assertThat(sortedByPasswordExipres, contains(PSTORMARE, PVESTLIN, PPAN, PSTORE));
    }

    // Funktion som hämtar alla användare mha förnamn
    BiFunction<String, List<User>, List<User>> byFirstname =
        (name, articles) -> articles.stream()
            .filter(a -> a.firstname.equals(name))
            .collect(Collectors.toList());

    // En funktion som hämtar alla användare mha ett visst förnamn samt sorterar dem efter passwordExpires.
    // Detta är Function Composition eftersom vi slår ihop två mindre funktioner till en större.
    BiFunction<String, List<User>, List<User>> usersWithFirstnameSortedByPasswordExpires =
        byFirstname.andThen(sortByPasswordExipres);

    @Test
    public void usersThatFirstnameIsPeterSortedByPasswordExpires_functionComposition() {
        assertThat(usersWithFirstnameSortedByPasswordExpires.apply("Peter", repository.getAll()),
            contains(PSTORMARE, PVESTLIN, PPAN, PSTORE));
    }

}
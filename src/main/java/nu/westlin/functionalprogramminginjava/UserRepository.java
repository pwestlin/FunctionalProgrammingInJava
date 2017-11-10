package nu.westlin.functionalprogramminginjava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class UserRepository {

    public static final Country NEVERLAND = new Country("NN", "Neverland");
    public static final Country SWEDEN = new Country("SE", "Sweden");
    public static final Country RUSSIA = new Country("RU", "Russia");
    public static final Country USA = new Country("US", "USA");

    public static final User PSTORMARE = new User("pstormare", "Peter", "Stormare", SWEDEN, LocalDate.now().plus(1, DAYS));
    public static final User PVESTLIN = new User("pvestlin", "Peter", "Vestlin", SWEDEN, LocalDate.now().plus(2, DAYS));
    public static final User PPAN = new User("ppan", "Peter", "Pan", NEVERLAND, LocalDate.now().plus(3, DAYS));
    public static final User PSTORE = new User("pstore", "Peter", "den Store", RUSSIA, LocalDate.now().plus(4, DAYS));
    public static final User DTRUMP = new User("dtrump", "Donald", "Trump", USA, LocalDate.now().plus(5, DAYS));
    public static final User DDUCK = new User("dduck", "Donald", "Duck", USA, LocalDate.now().plus(6, DAYS));

    List<User> users = Arrays.asList(
        PPAN,
        PVESTLIN,
        PSTORMARE,
        PSTORE,
        DDUCK,
        DTRUMP
    );

    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }

}

package nu.westlin.functionalprogramminginjava;

import java.util.Objects;

public final class Country {
    public final String code;
    public final String name;

    public Country(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) &&
            Objects.equals(name, country.name);
    }

    @Override public int hashCode() {
        return Objects.hash(code, name);
    }

}

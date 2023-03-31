package be.vdab.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Persoon {
    private final Set<String> voornamen = new LinkedHashSet<>();

    public void add (String voornaam) {

        if (voornamen.contains(voornaam)) {
            throw new IllegalArgumentException("Dezelfde voornaam bestaat al!");
        }
        if (voornaam.isBlank()) {
            throw new IllegalArgumentException("Naam mag niet blanco zijn!");
        }
        if (voornaam.equals(null)) {
            throw new NullPointerException("Naam mag niet NULL zijn!");
        }

        voornamen.add(voornaam);

    }

    @Override
    public String toString() {
        return voornamen.stream().collect(Collectors.joining(" "));
    }


}

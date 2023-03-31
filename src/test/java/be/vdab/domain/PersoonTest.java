package be.vdab.domain;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PersoonTest {
    private Persoon persoon;


    @BeforeEach void beforeEach() {
        persoon = new Persoon();
        persoon.add("Pieter");
        persoon.add("Jan");
    }


    @ParameterizedTest
    @ValueSource(strings = {"Pieter", "Jan"})
    void addDezelfdeVoornaamMagNiet(String voornaam) {
        assertThatIllegalArgumentException().isThrownBy(() -> persoon.add(voornaam));
    }

    @Test
    void addAndereVoornamenMag() {
        persoon.add("Raf");
        persoon.add("Henry");
        assertThat(persoon).hasToString("Pieter Jan Raf Henry");
    }

    @Test
    void addNullVoornaamMagNiet() {
        assertThatNullPointerException().isThrownBy(() -> persoon.add(null));
    }

    @Test
    void addLegeVoornaamStringMagNiet() {
        assertThatIllegalArgumentException().isThrownBy(() -> persoon.add(""));
    }

    @Test
    void testToString() {
        assertThat(persoon).hasToString("Pieter Jan");
    }
}
package org.example.struct;

import java.util.Objects;

public class Condom {
    private Firm firm;
    private int part;
    public Condom(Firm firm, int part) {
        this.firm = firm;
        this.part = part;
    }

    public enum Firm{
        CONTEX,
        DUREX,
        GANZO,
        KING
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condom condom = (Condom) o;
        return part == condom.part && firm == condom.firm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firm, part);
    }
}

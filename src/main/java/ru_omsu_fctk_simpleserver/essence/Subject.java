package ru_omsu_fctk_simpleserver.essence;

import java.util.Objects;

public class Subject {
    private Long id;
    private String name;
    private String shortName;


    public Subject() {}
    public Subject(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Subject(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject discipline = (Subject) o;
        return Objects.equals(id, discipline.id) && Objects.equals(name, discipline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}

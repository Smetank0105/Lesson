public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) && age == person.age;
    }

//    @Override
//    public int hashCode() {
//        return name.hashCode() ^ (age * 31);
//    }
}

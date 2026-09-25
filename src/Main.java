void main() {
    //1
    List<Integer> numbers = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    );

    numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);

    //2
    List<String> names = Arrays.asList("иван", "Мария", "ПЁТР", "Иван", "мария");

    names.stream()
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
            .sorted()
            .forEach(System.out::println);

    //3
    List<Student> students = new ArrayList<>();
    students.add(new Student("Иван", 5));
    students.add(new Student("Петр", 3));
    students.add(new Student("Сергей", 4));
    students.add(new Student("Михаил", 5));
    students.add(new Student("Николай", 2));

    int grade = 4;

    List<Student> topStudents = students.stream()
            .filter(student -> student.getGrade() > grade)
            .collect(Collectors.toList());

    System.out.println("Количество студентов с баллом выше " + grade + ": " + topStudents.size());

    System.out.println("Имена студентов с баллом выше " + grade + ":");
    topStudents.forEach(student -> System.out.println(student.getName()));
}



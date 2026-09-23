void main() {
    //1
    System.out.println("Задача 1");
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1, 2);
    Point p3 = new Point(3, 4);

    System.out.println("p1 == p2: " + (p1 == p2));
    System.out.println("p1.equals(p2): " + p1.equals(p2));

    HashSet<Point> set = new HashSet<>();
    set.add(p1);
    set.add(p2);
    set.add(p3);

    System.out.println("Size: "+set.size());

    Point p4 = new Point(1, 2);
    set.add(p4);

    System.out.println("Size: "+set.size());

    //2
    System.out.println("Задача 2");
    Person psn1 = new Person("Nick", 25);
    Person psn2 = new Person("Nick", 25);

    System.out.println("p1.equals(p2): " + psn1.equals(psn2));

    Map<Person, String> map = new HashMap<>();
    map.put(psn1, "First");
    map.put(psn2, "Second");

    System.out.println("map.get(p1): " + map.get(psn1));
    System.out.println("map.get(p2): " + map.get(psn2));
    System.out.println("map.size(): " + map.size());

    //3
    System.out.println("Задача 3");
    PointRec pr1 = new PointRec(1, 2);
    PointRec pr2 = new PointRec(1, 2);
    PointRec pr3 = new PointRec(3, 4);

    System.out.println("p1 == p2: " + (p1 == p2));
    System.out.println("p1.equals(p2): " + p1.equals(p2));

    HashSet<PointRec> set1 = new HashSet<>();
    set1.add(pr1);
    set1.add(pr2);
    set1.add(pr3);

    System.out.println("Size: "+set1.size());

    PointRec pr4 = new PointRec(1, 2);
    set1.add(pr4);

    System.out.println("Size: "+set1.size());

//    pr1.x = 5;
}

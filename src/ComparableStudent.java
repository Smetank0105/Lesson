public class ComparableStudent implements Comparable<ComparableStudent>{
    private String name;
    private double averageGrade;

    public ComparableStudent(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }


    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(ComparableStudent o) {
        if(!(o instanceof ComparableStudent)){
            throw new ClassCastException("Object is not ComparableStudent.");
        }
        ComparableStudent otherStudent = (ComparableStudent) o;
        return Double.compare(this.getAverageGrade(), otherStudent.getAverageGrade());
    }

    @Override
    public String toString() {
        return getName()+" (средняя оценка: "+getAverageGrade()+")";
    }
}

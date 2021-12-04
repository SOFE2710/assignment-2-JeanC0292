import java.util.Vector;

public class Student extends Person{
    private String id;
    private Vector<Course> courses; // contains all courses the student is registered in


    public  Student(String stdId, String stdName) {
        super.setName(stdName);
        this.id=stdId;
        this.courses = new Vector<Course>();
    }
    public void registerFor(Course course){
       if(!courses.contains(course))
           this.courses.add(course);

    }
    public boolean isRegisteredInCourse(Course course){

        if(courses.contains(course)) // tests if the course is among the students courses or not
            return true;
        else
            return false;

    }

    public String getName() {
        return super.getName();
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        System.out.println(  id + " " +getName() + " " + "\n" + "Registered Courses :" + " " + courses.toString());
        for (int i = 0; i < courses.size(); i ++) {
            System.out.print(courses.get(i).getCode() + " " + courses.get(i).getNumber());
            if (courses.size() - i != 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        return " ";
    }
}

import java.util.Vector;
public class Department {
    private String name; // the name of school Dept of Computing and Info Science
    private String id; // short name for courses SOFE, ELEE, STAT, etc
    private Vector<Course> courseList; // all courses offered by the department
    private Vector<Student> registerList; // all students taking courses in the department.


    public Department(String name, String id) {
        this.name = name;
        this.id=id;
        this.courseList=new Vector<Course>();
        this.registerList=new Vector<Student>();

    }

    public void offerCourse(Course course) {
        courseList.add(course);
    }
    public void printCoursesOffered(){
        for(Course allCourses : courseList) // Displays a list of all the courses offered in a department
            System.out.println(allCourses.toString());
    }
    public void printStudentsByName(){
        for (Student student : registerList) // Displays a list of all students taking courses in this department
            System.out.println(student.toString());

    }
    public Vector<Student> studentsRegisteredInCourse(int code){
        Vector<Student> classList = new Vector<Student>();
        for (Course course : courseList){
            if(course.getNumber()==code)
            {
                classList = course.getClassList();
            }
        }
        return classList;
    }

    public boolean isStudentRegistered(Student student) {
        int i = 0;
        while (i<registerList.size()) {
            if ((student.getId().equals( registerList.get(i).getId())) && (student.getName().equals(registerList.get(i).getName()))) {
                return true; // Checks whether a student is registered for a course in a department by matching name and Id
            }
            i++;
        }
        return false;
    }

    public void printStudentsRegisteredInCourse(int code) {
        if (studentsRegisteredInCourse(code).isEmpty())
        {
         System.out.println("No student registered for this course");
        }
        else {
            for (Student student : studentsRegisteredInCourse(code)) {
                System.out.println(student.getId() + "\t " + student.getName());
            }
        }

    }
    public String largestCourse(){
            int i = 0;

            int[] courses = new int[courseList.size()];
            String[] title = new String[courseList.size()];

            while (i < courseList.size()) {
                courses[i] = courseList.get(i).getClassSize();
                title[i] = courseList.get(i).getTitle();
                i++;
            }
            int largest = courses[0];
            String value = title[0];
            for (int j = 0; j < courses.length; j++) {
                if (courses[j] > largest) {
                    largest = courses[j];
                    value = title[j];
                }
            }
        return value;
    }
    public void registerStudentCourseInDepartment(Student name, Course course){
        boolean checkStudent = true;
        boolean checkCourse = true;
        for(int i=0;i< registerList.size();i++){
            if((registerList.get(i).getId().equals(name.getId())) && (registerList.get(i).getName().equals( name.getName())))
                checkStudent = false;
        }
        if(checkStudent)
            registerList.add(name);

        for(int i=0;i< courseList.size();i++){
            if (course.equals(courseList.get(i)))
                checkCourse = false;
        }
        if(checkCourse)
            courseList.add(course);
    }

    public String getName() {
        return name;

    }

    public String getId() {
        return id;

    }


    public String toString() {
        // returns a string representation of department name, number of courses offered and number of students registered in the department.
        // Use the format: ECSE: 53 courses, 460 students
        return (name +":" + courseList.size() + "courses" + ", " + registerList.size() + "students");
    }


}

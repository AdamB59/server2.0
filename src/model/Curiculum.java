package model;

/**
 * Created by magnusrasmussen on 12/10/2016.
 */
public class Curiculum {

    String school, education;
    int semester;

    public Curiculum(){

    }
    public Curiculum(String school, String education, int semester) {
        this.school = school;
        this.education = education;
        this.semester = semester;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Curiculum{" +
                "school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", semester=" + semester +
                '}';
    }
}

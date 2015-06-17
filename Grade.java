import java.io.Serializable;

public class Grade implements Serializable {// 이름 학번 학과 중간 기말 출석 과제 성적
    private String name;//
    private int stnumber;
    private String major;
    private int midterm;
    private int finalexam;
    private int attendence;
    private int homework;
    private int score;
    private String grade;
   
    
    
    
    public Grade(String name, int stnumber, String major, int midterm, int finalexam, int attendence, 
    		int homework, int score, String grade){//
        this.name = name;
        this.stnumber = stnumber;
        this.major = major;
        this.midterm = midterm;
        this.finalexam = finalexam;
        this.attendence = attendence;
        this.homework = homework;
        this.score = score;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    
    public String getMajor() {
        return major;
    }
    
    public int getStnumber() {
        return stnumber;
    }
    
    public int getMidterm() {
        return midterm;
    }
    
    public int getFinalexam() {
        return finalexam;
    }
    
    public int getAttendence() {
        return attendence;
    }
    
    public int getHomework() {
        return homework;
    }
    
    public int getScore() {
    	return score;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setStnumber(int stnumber) {
        this.stnumber = stnumber;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }
    
    public void setFinalexam(int finalexam) {
        this.finalexam = finalexam;
    }
    
    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }
    
    public void setHomework(int homework) {
        this.homework = homework;
    }
    
    public void setScore(int score) {
    	this.score = score;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public String toString(){// 이름 학번 학과 중간 기말 출석 과제 성적
        return getName() + "," + getStnumber() + "," + getMajor() + "," + getMidterm() +"," + getFinalexam() + "," + 
    		"," + getAttendence() + ","+ getHomework() + "," + getScore() + "," + getGrade();
    }
    
}

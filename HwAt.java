import java.io.Serializable;

public class HwAt implements Serializable {// 이름 과제1 과제2 과제3 리포트 결석횟수 지각횟수
    private String name2;
    private int hw1;
    private int hw2;
    private int hw3;
    private int report;
    private int absence;
    private int late;
   
    
    
    
    public HwAt(String name2, int hw1, int hw2, int hw3, int report, 
    		int absence, int late){//
        
        this.name2 = name2;
        this.hw1 = hw1;
        this.hw2 = hw2;
        this.hw3 = hw3;
        this.report = report;
        this.absence = absence;
        this.late = late;
    }
    
    public String getName2(){
    	return name2;
    }
    public int gethw1() {
        return hw1;
    }
    
    public int gethw2() {
        return hw2;
    }
    
    public int gethw3() {
        return hw3;
    }
    
    public int getreport() {
        return report;
    }
    
    public int getabsence() {
        return absence;
    }
    
    public int getlate() {
    	return late;
    }
    
   
    
}

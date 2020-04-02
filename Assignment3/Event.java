package Assignment3;


public class Event {
    private int arrTime;
    private int serTime;
    private int compTime;
    //private int numQueue;
    //private int numStudents;

    public Event(int arrTime, int serTime, int compTime){//, int numQueue, int numStudents){
        this.arrTime = arrTime;
        this.serTime = serTime;
        this.compTime = compTime;
        //this.numQueue = numQueue;
        //this.numStudents = numStudents;
    }

    public int getArrTime(){
        return arrTime;
    }

    public void setArrTime(int arrTime){
        this.arrTime = arrTime;
    }

    public int getSerTime(){
        return serTime;
    }

    public void setSerTime(int serTime){
        this.serTime = serTime;
    }

    public int getCompTime(){
        return compTime;
    }

    public void setCompTime(int compTime){
        this.compTime = compTime;
    }
    
    public String toString(){
        return "The student arrival time was " + arrTime + ". The Service Time is " + serTime+ ". The Completion Time is "+ compTime ;
    }

}
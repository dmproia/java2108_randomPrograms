package Queue;

import java.io.*;

public class LabSimulation
{
    private int minInt;
    private int maxInt;
    private int minSer;
    private int maxSer;
    private int queues;
    private int students;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    private String input = br.readLine();
    
    public LabSimulation()
    {
        minInt = 0;
        maxInt = 0;
        minSer = 0;
        maxSer = 0;
        queues = 0;
        students = 0;
    }
    
    public LabSimulation(int minIn, int maxIn, int minSe, int maxSe, int que, int stu)
    {
        minInt = minIn;
        maxInt = maxIn;
        minSer = minSe;
        maxSer = maxSe;
        queues = que;
        students = stu;
    }
    
    public void setMinInt(int minInt)
    {
        minInt = Integer.parseInt(input);
    }
    
    public void setMaxInt(int maxInt)
    {
        maxInt = Integer.parseInt(input);
    }    
    
    public void setMinSer(int minSer)
    {
        minSer = Integer.parseInt(input);
    }
    
    public void setMaxSer(int maxSer)
    {
        maxSer = Integer.parseInt(input);
    }
    
    public void setQueues(int queues)
    {
        queues = Integer.parseInt(input);
    }
    
    public void setStudents(int students)
    {
        students = Integer.parseInt(input);
    }
    
    public void getMinInt(int minInt)
    {
        return minInt;
    }
    
    public void getMaxInt(int maxInt)
    {
        return maxInt;
    }    
    
    public void getMinSer(int minSer)
    {
        return minSer;
    }
    
    public void getMaxSer(int maxSer)
    {
        return maxSer;
    }
    
    public void getQueues(int queues)
    {
        return queues;
    }
    
    public void getStudents(int students)
    {
        return students;
    }
    
//     //loop for making average student
//     public void setAveReturn(int aveReturn)
//     {
//         aveReturn = ;
//     }
//    
//     //loop for making largest students
//     public void setLargestStudents(int largestStudents)
//     {
//         largestStudents = ;
//     }
    
     
}
    
    
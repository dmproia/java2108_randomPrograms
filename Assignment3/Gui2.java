package Assignment3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;
import javax.swing.*;

public class Gui2 extends JFrame implements ActionListener{
    private JLabel inputStatement, minInterArrive, maxInterArrive, minSerTime, maxSerTime, numbQueues, numbStud, aveWait, largStudents ; 
    private TextField minInterText, maxInterText, minSerText, maxSerText, queuesText, studentsText, aveText, studentText ; 
    private JButton simulate, clear ;
    
    private int minInterText_1;
    private int maxInterText_1;
    private int minSerText_1;
    private int maxSerText_1;
    private int queuesText_1;
    private int studentsText_1;
//     private int numberIn; //input number's
   
    Queue <Student> studentQueue = new LinkedList<Student>();
    Queue <Event> eventQueue = new LinkedList<Event>();
    
    /** Contructor for my GUI */
    public Gui2() {
        JFrame frame = new JFrame("Queue Simulation Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        
        //input Statement - setBounds(int x,int y, int width, int height)
        inputStatement = new JLabel("Input Arguments:");
        panel_1.add(inputStatement);
        inputStatement.setBounds(5, 5, 150, 25);
        
        //Minimum Inter-Arrival Time label + textfield + actionlistener
        minInterArrive = new JLabel("Minimum Inter-Arrival Time");
        minInterArrive.setBounds(15, 30, 170, 25);
        panel_1.add(minInterArrive);
        
        minInterText = new TextField(8);
        minInterText.setBounds(190, 30, 50, 20);
        panel_1.add(minInterText);
        
        minInterText.addActionListener(this);
        
        //Maximum Inter-Arrival Time label + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        maxInterArrive = new JLabel("Maximum Inter-Arrival Time");
        maxInterArrive.setBounds(15, 55, 170, 25);
        panel_1.add(maxInterArrive);
        //change y +25 + names
        maxInterText = new TextField(8);
        maxInterText.setBounds(190, 55, 50, 20);
        panel_1.add(maxInterText);
        
        maxInterText.addActionListener(this);
        
        //Minimum Service Time label + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        minSerTime = new JLabel("Minimum Service Time");
        minSerTime.setBounds(15, 80, 170, 25);
        panel_1.add(minSerTime);
        //change y +25 + names
        minSerText = new TextField(8);
        minSerText.setBounds(190, 80, 50, 20);
        panel_1.add(minSerText);
        
        minSerText.addActionListener(this);
        
        //Maximum Service Time label + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        maxSerTime = new JLabel("Maximum Service Time");
        maxSerTime.setBounds(15, 105, 170, 25);
        panel_1.add(maxSerTime);
        //change y +25 + names
        maxSerText = new TextField(8);
        maxSerText.setBounds(190, 105, 50, 20);
        panel_1.add(maxSerText);
        
        maxSerText.addActionListener(this);
        
        //Number of Queues label + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        numbQueues = new JLabel("Number of Queues");
        numbQueues.setBounds(15, 130, 170, 25);
        panel_1.add(numbQueues);
        //change y +25 + names
        queuesText = new TextField(8);
        queuesText.setBounds(190, 130, 50, 20);
        panel_1.add(queuesText);
        
        queuesText.addActionListener(this);
        
        //Number of Students label + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        numbStud = new JLabel("Number of Students");
        numbStud.setBounds(15, 155, 170, 25);
        panel_1.add(numbStud);
        //change y +25 + names
        studentsText = new TextField(8);
        studentsText.setBounds(190, 155, 50, 20);
        panel_1.add(studentsText);
        
        studentsText.addActionListener(this);
        
        //JButton for Simulate
        simulate = new JButton("Simulate");
        simulate.setBounds(0, 180, 175, 35); 
        panel_1.add(simulate);
        simulate.addActionListener(this);
        
        //JButton for Clear
        clear = new JButton("Clear");
        clear.setBounds(175, 180, 175, 35); 
        panel_1.add(clear);
        clear.addActionListener(this);
        
        //Average Wait time + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        aveWait = new JLabel("Average Wait Time: ");
        aveWait.setBounds(75, 225, 115, 25);
        panel_1.add(aveWait);
        //change y +25 + names
        aveText = new TextField(8);
        aveText.setBounds(190, 225, 50, 20);
        aveText.setEditable(false);
        panel_1.add(aveText);
        
        aveText.addActionListener(this);
        
        //Largest Number of students waiting + textfield + actionlistener 
        //- setBounds(int x,int y, int width, int height)
        //Change y +25 + names
        largStudents = new JLabel("Largest number of students waiting in a queue: ");
        largStudents.setBounds(15, 250, 270, 25);
        panel_1.add(largStudents);
        //change y +25 + names
        studentText = new TextField(8);
        studentText.setBounds(285, 250, 50, 20);
        studentText.setEditable(false);
        panel_1.add(studentText);
        
        studentText.addActionListener(this);
        

        //Frame size and visibility
        frame.add(panel_1);
        frame.setSize(360,350);
        frame.setVisible(true);
        
    }
    
    
    //Clear ->>> minInterText, maxInterText, minSerText, maxSerText, queuesText, studentsText, aveText, studentText
    public void actionPerformed(ActionEvent evt) {
        try{
        if(evt.getSource() == clear)
        {
            
            minInterText.setText("");
            maxInterText.setText("");
            minSerText.setText("");
            maxSerText.setText("");
            queuesText.setText("");
            studentsText.setText("");
            aveText.setText("");
            studentText.setText("");
        }
        else if(evt.getSource() == simulate)
        {
                minInterText.getText();
                minInterText_1 = Integer.parseInt(minInterText.getText());
                maxInterText.getText();
                maxInterText_1 = Integer.parseInt(maxInterText.getText());
                minSerText.getText();
                minSerText_1 = Integer.parseInt(minSerText.getText());
                maxSerText.getText();
                maxSerText_1 = Integer.parseInt(maxSerText.getText());
                queuesText.getText();
                queuesText_1 = Integer.parseInt(queuesText.getText());
                if (queuesText_1 == 1){
                    studentsText.getText();
                    studentsText_1 = Integer.parseInt(studentsText.getText());
                    processQueue(minInterText_1, maxInterText_1, minSerText_1, maxSerText_1, queuesText_1, studentsText_1);
                }
                else if(queuesText_1 > 1){
                    studentsText.getText();
                    studentsText_1 = Integer.parseInt(studentsText.getText());
                    multipleProcessQueue(minInterText_1, maxInterText_1, minSerText_1, maxSerText_1, queuesText_1, studentsText_1);
                }

        }
        else
        {
            System.out.println("failure");
        }
    }
        catch(NumberFormatException e){
            System.out.println("Illegal input character, please input an Integer only");
        }
    }

    
    public int randNum(int min, int max){
        
        Random rn = new Random();
        int range = max - min + 1;
        int randomNum =  rn.nextInt(range) + min;
        return randomNum;
        
    }
    public Student studentBuild(int arrTime, int serTime){
        Student student = new Student(arrTime, serTime);
        return student;
    }
//     public Event eventBuild(int arrTime, int serTime, int compTime){
//         Event event = new Event(arrTime, serTime, compTime);
//         return event;
//     }

    public void processQueue(int minArrive, int maxArrive, int minService, int maxService, int queueNum, int studentNum){
        int time = 0;
        int maxQueueSize = 0;
        int totalWaitTime = 0;
        int waitTime = 0;
        int queueSize = 0;
        int avgWaitTime = 0;
        int compTime = 0;
        int arrTime = 0;
        int serTime = 0;
        int startTime = 0;
        int i = 0;
        Student currentStudent = null;
        while(i<studentNum){
            arrTime = randNum(minArrive, maxArrive);
            serTime = randNum(minService+1, maxService-1);
            studentQueue.offer(studentBuild(arrTime, serTime));
            i++;
        }

        while((currentStudent = studentQueue.poll()) != null){
            arrTime = currentStudent.getArrTime();
            serTime = currentStudent.getSerTime();
            if(time==arrTime){
                Event event = new Event(arrTime, serTime, compTime = arrTime + serTime);
                eventQueue.add(event);
                queueSize++;
            }
                       
            if(time > arrTime){
                //  compTime = arrTime + serTime; and totalWaitTime=totalWaitTime+compTime-arrTime-serTime;
                compTime = arrTime + serTime;
                waitTime = compTime - arrTime;
                startTime = arrTime + waitTime;
                Event event = new Event(startTime, serTime, startTime-serTime);
                eventQueue.add(event);                
                totalWaitTime=totalWaitTime+compTime;
                queueSize++;
            }
            
            if(queueSize>maxQueueSize){
                maxQueueSize = queueSize;
            }
            time+=serTime;
            avgWaitTime = (totalWaitTime/studentNum);
        }
        aveText.setText(Integer.toString(avgWaitTime));
        studentText.setText(Integer.toString(maxQueueSize));

    }
    
    public void multipleProcessQueue(int minArrive, int maxArrive, int minService, int maxService, int queueNum, int studentNum){
        int time = 0;
        int maxQueueSize = 0;
        int totalWaitTime = 0;
        int waitTime = 0;
        int queueSize = 0;
        int avgWaitTime = 0;
        int compTime = 0;
        int arrTime = 0;
        int serTime = 0;
        int startTime = 0;
        int i = 0;
        Student currentStudent = null;
        while(queueNum > 1)
        {
            Queue <Student> studentQueue = new LinkedList<Student>();
            queueNum = queueNum -1;
        }
        if(queueNum == 1)
        {
            Queue <Student> studentQueue = new LinkedList<Student>();
        }
            
        while(i<studentNum){
            arrTime = randNum(minArrive, maxArrive);
            serTime = randNum(minService+1, maxService-1);
            studentQueue.offer(studentBuild(arrTime, serTime));
            i++;
        }

        while((currentStudent = studentQueue.poll()) != null){
            arrTime = currentStudent.getArrTime();
            serTime = currentStudent.getSerTime();
            if(time==arrTime){
                Event event = new Event(arrTime, serTime, compTime = arrTime + serTime);
                eventQueue.add(event);
                queueSize++;
            }
                       
            if(time > arrTime){
                //  compTime = arrTime + serTime; and totalWaitTime=totalWaitTime+compTime-arrTime-serTime;
                compTime = arrTime + serTime;
                waitTime = compTime - arrTime;
                startTime = arrTime + waitTime;
                Event event = new Event(startTime, serTime, startTime-serTime);
                eventQueue.add(event);                
                totalWaitTime=totalWaitTime+compTime;
                queueSize++;
            }
            
            if(queueSize>maxQueueSize){
                maxQueueSize = queueSize;
            }
            time+=serTime;
            avgWaitTime = ((totalWaitTime/studentNum));
        }
        aveText.setText(Integer.toString(avgWaitTime));
        studentText.setText(Integer.toString(maxQueueSize));

    }
    

//     numberIn = Integer.parseInt(minInterText.getText());
       
    /** The entry main() method */
    public static void main(String[] args) {
        new Gui2();

        
    }
}
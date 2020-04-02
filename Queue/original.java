package Queue;

    import java.util.Queue;
    import java.util.LinkedList;
    import java.util.Iterator;
    public class original
    {
    public static double expo(double mean)
    {
    //The "random" method in the Math class produces random values in the range [0,1]. We make
    //our random times more realistic by transforming these into values from the exponential
    //distribution with the appropriate mean
    //First generate a uniform random variable
    double ran = Math.random();
    //Now transform it to an expontial random variable of the indicated mean
    double ex = -mean * Math.log(ran);
    return ex;
    }
    public static void main(String[] args)
    {
    //The program will simulate a system with one queue and one server. Customers waiting in the
    //queue will be processed on a first come, first served basis. In order to collect waiting-time
    //statistics you will store the arrival times for each person as they enter the queue. (Thus, the queue
    //will contain items that store Double objects.)
    //Note: All times are given in minutes
    double meanInterArrival = 10.2;	//average time between successive arrivals
    double meanService = 1.0;	//average length of service time per customer
    double clock = 0;	//simulated clock initialized to zero before simulation starts
    //The only types of events that change the state of the system are the arrival of a new customer,
    //the departure of the customer currently being served, and the closing of the doors
    double nextArrival;	//the time of the next pending arrival
    double nextDeparture;	//the time of the next pending departure
    double closingTime = 5000;	//stop allowing arrivals once closing time is reached
    boolean serverIdle = true;	//the server is idle before the first customer arrives
    boolean closed = false;	//the doors have not yet closed for the end of the day
    //Now we need some variables to collect statistical results about the simulation. We want to know the
    //average waiting time (in the queue) per person. So we need to count the number of people who pass through
    //the system and accumulate the individual waiting times.
    int customerCount = 0;
    double customerWaitTime = 0;	//waiting time for the customer finishing his or her wait
    double totalWaitTime = 0;	//accumulated waiting time for all customers
    Queue<String> que=new LinkedList<String>();	//the Queue that stores the information for the arrivals
    //Schedule the time of arrival for the first customer. Since there is no-one being served, the time of the
    //next departure is set artificially high so that it isn't chosen as the next event to happen
    nextArrival = clock + expo(meanInterArrival);
    //Since no one is being served, set the next departure time artificially high
    nextDeparture = 5000;
    //now the loop to run the simulation until closing time has passed and the queue has emptied out
    //NOTE: There are many things about this loop that are incomplete. I removed some things that we
    //haven't yet talked about in class. There are other things that you will need to add as part of your
    //programming assignment. I put only enough in here now to make it executable and to give you an idea
    //of the general loop structure.
    while (/*queue is not empty && */ !closed)
    {
    //find the minimum of nextArrival, nextDeparture and closingTime to determine what type of
    //event occurs next
    if (nextArrival < nextDeparture && nextArrival < closingTime)
    {	
    clock=nextArrival;
    if(serverIdle=false)
    {
    que.add(Double.toString(nextArrival));	//updates clock
    }
    else
    {
    //next event is an arrival
    System.out.println("arrival");	//indicates a new customer has arrived
    que.add(Double.toString(nextArrival));	//adds the arrival time to the queue
    nextArrival = clock + expo(meanInterArrival);	//calculates the next arrival
    nextDeparture = clock + expo(meanService);	//calculates the next departure
    customerCount =+ 1;	//increase tally of number of people served
    serverIdle=false;
    }
    }
    else if (nextDeparture < nextArrival && nextDeparture < closingTime)	//next event is a departure
    {	
    clock=nextDeparture;	//time is updated
    System.out.println("departure");	//denotes someone left
    if(que.isEmpty())	//if there is no one in line
    {
    serverIdle=true;	//server is no longer busy
    nextDeparture=5000;	//virtual infinity to prevent someone leaving when there is no one there.
    }
    else
    {
    customerWaitTime=nextDeparture-(Double.parseDouble(que.poll()));	//calculates how long the customer waited in line
    totalWaitTime = totalWaitTime+customerWaitTime;	//total time waiting
    meanService = totalWaitTime/customerCount;	//average time per person
    nextDeparture = clock + expo(meanService);	//next person to leave
    customerCount =+1;
    }
    }
    else
    {
    //next event is to close the doors and stop allowing arrivals
    System.out.println("closing");	//the doors have closed
    closed = true;
    closingTime = 5000;	//virtual infinity
    nextArrival = 5000;	//virtual infinity
    clock=closingTime;	//updates clock time
    if(!que.isEmpty())	//signifies there are still people waiting in line
    {
    customerWaitTime=nextDeparture-(Double.parseDouble(que.poll()));	//calculates how long the customer waited in line
    totalWaitTime = totalWaitTime+customerWaitTime;	//total time waiting
    meanService = totalWaitTime/customerCount;	//average time per person
    nextDeparture = clock + expo(meanService);	//next person to leave
    clock=nextDeparture;	//update the time
    }	
    }	
    }
    System.out.println("Average Service Time is :" + meanService);
    Iterator it=que.iterator();	//declare iterator for queue
    }
    }
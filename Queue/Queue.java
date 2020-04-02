package Queue;


///////////////////////////////////////////////////////////////////////////////
//
// Data Queue example.  This program uses the DataQueue class to put
// records on a data queue.
//
// This example uses the Record and Record format classes to put data
// on the queue.  String data is converted from Unicode to ebcdic
// and numbers are converted from Java to the server format.  Because data
// is converted the data queue, entries can be read by a server program,
// an iSeries Access for Windows program, or another Java program.
//
// This is the producer side of the producer/consumer example.  It puts work
// items on the queue for the consumer to process.
//
// Command syntax:
//    DQProducerExample system
//
///////////////////////////////////////////////////////////////////////////////


import java.io.*;
import java.util.*;
import java.net.*;

// Queue.java: queue implementation
public class Queue {
   private int qMaxSize;// max queue size
   private int fp = 0;  // front pointer
   private int rp = 0;  // rear pointer
   private int qs = 0;  // size of queue
   private char[] q;    // actual queue

   public Queue(int size) {
      qMaxSize = size;
      fp = 0;
      rp = 0;
      qs = 0;
      q = new char[qMaxSize];
   }

   public char delete() {
      if (!emptyq()) {
         qs--;
         fp = (fp + 1)%qMaxSize;
         return q[fp];
      }
      else {
         System.err.println("Underflow");
         return '?';
      }
   }

   public void insert(char c) {
      if (!fullq()) {
         qs++;
         rp = (rp + 1)%qMaxSize;
         q[rp] = c;
      }
      else
         System.err.println("Overflow\n");
   }

   public boolean emptyq() {
      return qs == 0;
   }

   public boolean fullq() {
      return qs == qMaxSize;
   }
   
   public void printq() {
      System.out.print("Size: " + qs +
         ", rp: " + rp + ", fp: " + fp + ", q: ");
      for (int i = 0; i < qMaxSize; i++)
         System.out.print("q[" + i + "]=" 
            + q[i] + "; ");
      System.out.println();
   }
}
package com.doubt.data;

import com.doubt.domain.Doubt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseInitialize {
	
	private List<Doubt> getDoubtsList()
        {
		List<Doubt> doubts = new ArrayList<>();
		doubts.add(new Doubt(1,"What is the difference between NULL and VOID?","While NULL is a value, VOID is a data type identifier. A variable assigned with a NULL value represents an empty value. The VOID is used for identifying pointers having no initial size.","answered","Keshkar","Prathith","10" ));
		doubts.add(new Doubt(2, "Please draw a comparison between notify() and notifyAll() methods.","The notify() method is used for sending a signal to wake up a single thread in the waiting pool. Contrarily, the notifyAll() method is used for sending a signal to wake up all threads in a waiting pool.","answered","pooja","abhishek","56"));	
                doubts.add(new Doubt(3,"Is it possible to write multiple catch blocks under a single try block?","unanswered","pooja" ));	
                doubts.add(new Doubt(4, "Explain exception propagation?","The method at the top of the stack throws an exception if it is not caught. It moves to the next method and goes on like this until caught.","answered","pooja"));
		doubts.add(new Doubt(5, "what is direct mapping?","In direct mapping, the RAM is used to store data and some of the data is stored in the Cache.  The address space is divided into two parts index field and tag field.  The tag field is used to store the tag field whereas the rest is stored in the main memory.","answered","tiwari","harshal","23" ));
		doubts.add(new Doubt(6, "Can you explain the Tower of Hanoi problem?","unanswered","keskar","rahul","59" ));
		doubts.add(new Doubt(7, "When can you tell that a Memory Leak will occur?","A memory leak occurs when a program does not free a block of memory allocated dynamically.","answered","keskar" ,"shruti","34"));	
                doubts.add(new Doubt(8, "what is the use of RAID system?","unanswered","tiwari","pawan","89"));	
                doubts.add(new Doubt(9, "If S=span(u1,u2,…,un) then dim(S)=n.is it correct sir?","If S=span(u1,u2,…,un) then dim(S)=n.","answered","satish kumar"));
		doubts.add(new Doubt(10, "What is the advantage of the heap over a stack?","The heap is more flexible than the stack. That’s because memory space for the heap can be dynamically allocated and de-allocated as needed. However, the memory of the heap can at times be slower when compared to that stack.","answered","keskar" ,"shreya","76"));
		return doubts;
	}

	public void initializeDatabase() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb1","root","Adesh12345@");) {
			
				try (PreparedStatement prepStm = conn.prepareStatement("DROP TABLE IF EXISTS doubts;")) {
					prepStm.execute();
				}
				
//				try (PreparedStatement prepStm = conn.prepareStatement("DROP TABLE IF EXISTS orders;")) {
//					prepStm.execute();
//				}
				
				try (PreparedStatement prepStm = conn.prepareStatement("CREATE TABLE doubts (id int, question varchar(300), answer varchar(300), status varchar(30),teacher varchar(130),student varchar(130),rollno varchar(30) );")) {
					prepStm.execute();
				}
				
				List<Doubt> itemsList = getDoubtsList();
				for (Doubt items : itemsList)
                                {
					try (PreparedStatement prepStm = conn.prepareStatement("INSERT INTO doubts (id,question,answer,status,teacher,student,rollno ) values (?,?,?,?,?,?,?);");) {
						prepStm.setInt(1, items.getId());
						prepStm.setString(2, items.getQuestion());
						prepStm.setString(3, items.getAnswer());
						prepStm.setString(4, items.getStatus());
						prepStm.setString(5, items.getTeacher());
                                                prepStm.setString(6, items.getname());
						prepStm.setString(7, items.getrollno());
						prepStm.execute();
					}
				}	
				
//				try (PreparedStatement prepStm = conn.prepareStatement("CREATE TABLE orders (id int auto_increment primary key, customer varchar(30), contents varchar(255), status varchar(50));")) {
//					prepStm.execute();
//				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
       
}

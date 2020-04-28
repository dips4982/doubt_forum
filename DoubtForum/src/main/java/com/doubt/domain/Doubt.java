/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doubt.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adesh
 */
public class Doubt 
{
	//private Map<String,String> doubt = new HashMap<>();
        private int id;
        private String question;
        private String answer;
	public String status;
        private String teacher;
        String name;
        String rollno;

    public Doubt() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        public String getTeacher() {
		return this.teacher;
	}
	
//	public void setTecher(String teacher) {
//		this.teacher = teacher;
//	} 
        public String getQuestion() {
		return this.question;
	}
	
	public void setQuestion(String teacher) {
		this.question = teacher;
	}
        public String getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(String teacher) {
		this.answer = teacher;
	}
        public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
        public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
        
        public Doubt(int id,String question,String answer,String status,String teacher,String name,String rollno) {
                this.id=id;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.teacher = teacher;
                this.name=name;
                this.rollno=rollno;
	}
        public Doubt(int id,String question,String status,String teacher,String name,String rollno) {
                this.id=id;
		this.question = question;
		this.answer = "";
		this.status = status;
		this.teacher = teacher;
                this.name=name;
                this.rollno=rollno;
	}
         public Doubt(int id,String question,String status,String teacher) {
                this.id=id;
		this.question = question;
		this.answer = "";
		this.status = status;
		this.teacher = teacher;
                this.name="Anonymous";
                this.rollno="-1";
            }
         public Doubt(int id,String question,String answer,String status,String teacher) {
                this.id=id;
		this.question = question;
		this.answer = "";
		this.status = status;
		this.teacher = teacher;
                this.name="Anonymous";
                this.rollno="-1";
	}
         public String getname() {
		return this.name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
         public String getrollno() {
		return this.rollno;
	}
	
	public void setrollno(String rollno) {
		this.rollno = rollno;
	}
	
		public String toString() 
                {
		return (this.name +" \n Question:" + this.question + System.lineSeparator()+" \n Answer: " + this.answer + "");
                }

//    public void setTeacher(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void setTeacher(String string) {
       this.teacher = string;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
        
}

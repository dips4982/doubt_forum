/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doubt.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adesh
 */
public class Post {
	private ArrayList<Doubt> doubts = new ArrayList<>();
        
        public void addDoubt(Doubt t)
        {
            doubts.add(t);
        }
        public String toString() {
		StringBuilder sb = new StringBuilder();
			for (Doubt item : doubts)
                        {
                            if(item.getStatus()=="answered")
				sb.append(item.getQuestion() + " : " + item.getAnswer() + "<br/>");
			}
		return sb.toString();
	}
}

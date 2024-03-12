package com.chatgpt.integration.chatgptintegration.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ChatGPTRequest {

	
	private String model;
	private List<Message> messages=new ArrayList<Message>();
	public ChatGPTRequest(String model, String prompt) {
		this.model = model;
		this.messages.add(new Message("user",prompt)); 
		System.out.println(messages);
		System.err.println(prompt);
		
	}
	
	
}

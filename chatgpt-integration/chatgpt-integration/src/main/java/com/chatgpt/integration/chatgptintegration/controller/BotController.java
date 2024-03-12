package com.chatgpt.integration.chatgptintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chatgpt.integration.chatgptintegration.dto.ChatGPTRequest;
import com.chatgpt.integration.chatgptintegration.dto.ChatGPTResponse;

@RestController
@RequestMapping("/bot")
public class BotController {

	@Value("${openai.model}")
	private String model;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${openai.api.url}")
	private String apiURL;
	
	
	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		ChatGPTRequest chatGPTRequest=new ChatGPTRequest("gpt-3.5-turbo", prompt);
		ChatGPTResponse postForObject = restTemplate.postForObject(apiURL, chatGPTRequest, ChatGPTResponse.class);
		return postForObject.getChoices().get(0).getMessage().getContent();
	}
}

package com.luve.models;

public class Networking {
	
	private int id;
    private String term;
    private String description;
    private String topic;
    private String example;
    
    
	public Networking(int id, String term, String description, String topic, String example) {
		this.id = id;
		this.term = term;
		this.description = description;
		this.topic = topic;
		this.example = example;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
    
    

}

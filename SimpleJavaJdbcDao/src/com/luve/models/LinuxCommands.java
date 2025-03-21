package com.luve.models;

public class LinuxCommands {
	
	private int id;
    private String command;
    private String description;
    private String example;
    
    
	public LinuxCommands(int id, String command, String description, String example) {
		this.id = id;
		this.command = command;
		this.description = description;
		this.example = example;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
    

}

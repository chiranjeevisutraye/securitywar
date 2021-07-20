package com.swar.model;

import java.io.Serializable;
import java.util.List;

public class Folder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Folder> folders;
	private String name;
	
	public Folder() {
		
	}

	public Folder(List<Folder> folders, String name) {
		super();
		this.folders = folders;
		this.name = name;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

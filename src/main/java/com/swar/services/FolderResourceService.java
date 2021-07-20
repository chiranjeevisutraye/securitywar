package com.swar.services;

import java.util.ArrayList;
import java.util.List;

import com.swar.model.Folder;

public class FolderResourceService {
	
	List<Folder> rootFolders;
	
	public FolderResourceService() {
		rootFolders = new ArrayList<Folder>();
		//create dummy folders
		Folder root = new Folder();
		root.setName("Root");
		Folder f2 = new Folder();
		f2.setName("F2");
		Folder f3 = new Folder();
		f3.setName("F3");
		List<Folder> innerFolders = new ArrayList<Folder>();
		innerFolders.add(f2);
		innerFolders.add(f3);
		root.setFolders(innerFolders);
		rootFolders.add(root);
		
		
	}
	
	public Folder getFolderByName(String name) {
		for(Folder f : rootFolders) {
			if(f.getName().equalsIgnoreCase(name))
				return f;
		}
		return null;
	}
	
	public List<Folder> getAllFolders() {
		return rootFolders;
	}
}

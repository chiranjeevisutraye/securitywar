package com.swar.rest;

import java.util.List;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swar.model.Folder;
import com.swar.services.FolderResourceService;

@RestController
@RequestMapping("/folders")
public class FolderService {
	
	@RequestMapping(value="find/{folderName}",method = RequestMethod.GET ,produces="application/json")
	public Folder getFolder(@PathVariable String folderName) {
		FolderResourceService frs = new FolderResourceService();
		return frs.getFolderByName(folderName);
	}
	
	@RequestMapping(value="find/all",method = RequestMethod.GET ,produces="application/json")
	public List<Folder> getFolder() {
		FolderResourceService frs = new FolderResourceService();
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		String user = auth.getName();
		
		return frs.getAllFolders();
	}
	
	
	public void addFolder() {
		
	}
}

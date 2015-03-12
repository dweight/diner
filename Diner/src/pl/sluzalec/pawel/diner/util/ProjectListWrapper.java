package pl.sluzalec.pawel.diner.util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pl.sluzalec.pawel.diner.model.Project;

// Helper to wrap a list of projects to save them as XML.
@XmlRootElement(name = "projects")
public class ProjectListWrapper {

	private List<Project> projects;
	
	@XmlElement(name = "project")
	public List<Project> getProjects(){
		return projects;
	}
	
	public void setProjects(List<Project> persons) {
		this.projects = projects;
	}
}

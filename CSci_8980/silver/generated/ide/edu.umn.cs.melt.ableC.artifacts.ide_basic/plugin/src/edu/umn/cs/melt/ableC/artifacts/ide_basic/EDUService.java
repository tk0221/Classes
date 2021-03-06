/*
 * Variables used:
 *   PKG_NAME
 *   LANG_NAME
 */
package edu.umn.cs.melt.ableC.artifacts.ide_basic;

import ide.NIdeEnv;
import ide.NIdeProperty;
import ide.PmakeIdeProperty;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

import edu.umn.cs.melt.ableC.artifacts.ide_basic.eclipse.resource.LinkedResourceTracker;
import edu.umn.cs.melt.ableC.artifacts.ide_basic.imp.builders.EDUBuilder;
import edu.umn.cs.melt.ide.silver.property.ProjectProperties;
import edu.umn.cs.melt.ide.silver.property.Property;

/**
 * Services managed for each project of EDU in the workspace.
 * <p>
 * This class is used to get per-project properties and environment parameters,
 * which are required by most optional functions declared in Silver's IDE
 * declaration block.
 */
public class EDUService {

	private Map<String, ProjectProperties> map;
	
	private Map<String, NIdeEnv> env = new HashMap<String, NIdeEnv>();
	
	private Map<String, LinkedResourceTracker> trackers = 
        new HashMap<String, LinkedResourceTracker>();

	private EDUService(){
		if(map==null){
			map = new HashMap<String, ProjectProperties>();
		}
		if(env==null){
			env = new HashMap<String, NIdeEnv>();
		}
	}
	
	private final static EDUService singleton = new EDUService();
	
	public static EDUService getInstance(){
		return singleton;
	}
	
	/**
	 * Get resource trackers of project specified by given IProject instance.
	 * 
	 * @param project
	 * @return
	 */
	public LinkedResourceTracker getLinkedResourceTracker(IProject project){		
		String name = project.getName();
		LinkedResourceTracker tracker = trackers.get(name);
		if(tracker==null){
			tracker = new LinkedResourceTracker(project);
			trackers.put(name, tracker);
		}
		
		return tracker;
	}

	/**
	 * Get properties of project specified by given IProject instance.
	 * 
	 * @param project
	 * @return
	 */
	public ProjectProperties getProperties(IProject project){		
		String name = project.getName();
		ProjectProperties pp = map.get(name);
		if(pp==null){
			pp = ProjectProperties.getPropertyPersister(project.getLocation().toString());
			map.put(name, pp);
		}
		
		return pp;
	}

	/**
	 * Convert ProjectProperties to [NIdeProperty] in Silver
	 * @param properties
	 * @return
	 */
	public static NIdeProperty[] convertToNIdePropertyList(ProjectProperties properties) {
		Set<Entry<String, Property>> set = properties.getAll();
		NIdeProperty[] list = new NIdeProperty[set.size()];
		int i=0;
		for(Entry<String, Property> entry: set){
			Property prop = entry.getValue();
			list[i] = new PmakeIdeProperty(
				new common.StringCatter(entry.getKey()), //this is equal to prop.getName()
				new common.StringCatter(prop.getType().name()),
				new common.StringCatter(prop.getSValue())
			);
			i++;
		}
		
		return list;
	}
	
	/**
	 * Get environment of project specified by given IProject instance.
	 * 
	 * @param project
	 * @return
	 */
	public NIdeEnv getEnvironment(IProject project){
		String name = project.getName();
		NIdeEnv result = env.get(project.getName());
		
		if(result==null){
			env.put(name, result = makeEnv(name, project));
		}
		
		return result;
	}

	private NIdeEnv makeEnv(String projectName, IProject fProject) {
		IPath path = fProject.getLocation();
		
		String projectPath = path.toOSString();
		String generatedPath = path.toOSString() + "/" + EDUBuilder.GEN_FOLDER;
		String platformPath = null;
		
		try {
			Location platform = Platform.getInstallLocation();
			File parent = new File(FileLocator.resolve(platform.getURL()).toURI());
			platformPath = parent.getAbsolutePath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NIdeEnv env = new ide.PmakeIdeEnv(
            new common.StringCatter(projectName), 
            new common.StringCatter(projectPath), 
            new common.StringCatter(generatedPath), 
            new common.StringCatter(platformPath),
            fProject
        );
		
		return env;
	}
	
}


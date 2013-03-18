package net.sheenobu.osgi;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class GoodbyeResource extends ServerResource {

    @Get
    public String represent() {
      String name = (String) getRequest().getAttributes().get("name");
        return "xgoodbye, " + name;
    }
}
 

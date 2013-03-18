package net.sheenobu.osgi;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {

    @Get
    public String represent() {
      String name = (String) getRequest().getAttributes().get("name");
        return "hello, " + name;
    }
}
   

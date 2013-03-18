package net.sheenobu.osgi; 

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class FirstStepsApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        router.attach("/hello/{name}",HelloWorldResource.class);
        router.attach("/goodbye/{name}",GoodbyeResource.class);

        return router;
    }
}
   

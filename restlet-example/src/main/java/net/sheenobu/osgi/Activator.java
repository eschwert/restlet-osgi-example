package net.sheenobu.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

import org.restlet.ext.servlet.ServerServlet;

import java.util.Hashtable;

public class Activator implements BundleActivator {

    ServiceReference httpServiceRef;

    public void start(BundleContext context) throws Exception {
      httpServiceRef = context.getServiceReference(HttpService.class.getName());
      if(httpServiceRef != null) {
        System.out.println("Adding /rest-example service");
        HttpService service = (HttpService) context.getService(httpServiceRef);

        Hashtable initParams = new Hashtable();
        initParams.put("org.restlet.application","net.sheenobu.osgi.FirstStepsApplication");

        ServerServlet srv = new ServerServlet();

        service.registerServlet("/rest-example", srv, initParams, null);
      }
    }

    public void stop(BundleContext context) {
        
        if(httpServiceRef != null) {
          HttpService service = (HttpService) context.getService(httpServiceRef);
          service.unregister("/rest-example");
        }
        httpServiceRef = null;   
    }

}

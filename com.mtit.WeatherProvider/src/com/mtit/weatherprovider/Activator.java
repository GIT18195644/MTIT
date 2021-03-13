package com.mtit.weatherprovider;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;



public class Activator extends AbstractUIPlugin  {

	private static BundleContext context;
	ServiceRegistration<?> serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		Activator.context = bundleContext;
		Hashtable<String,String> props = new Hashtable<>();
		props.put("Country" , "Sri Lanka");
		System.out.println("Weather provider started....");
		
		WeatherProvider wp = new WeatherProviderImpl();
		serviceRegistration = context.registerService(WeatherProvider.class.getName() , wp , props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Weather provider stopped....");
		serviceRegistration.unregister();
	}

}

package com.mtit.locationpicker;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration<?> serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		Activator.context = bundleContext;
		Hashtable<String, String> props = new Hashtable<>();
		props.put("Country", "Sri Lanka");
		System.out.println("Location picker start");
		LocationPick locPicker = new LocationPickImpl();
		serviceRegistration = bundleContext.registerService(LocationPick.class.getName(), locPicker, props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Location picker stop");
		serviceRegistration.unregister();
	}

}

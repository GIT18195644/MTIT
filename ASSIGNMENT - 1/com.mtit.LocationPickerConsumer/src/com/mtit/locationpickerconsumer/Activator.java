package com.mtit.locationpickerconsumer;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.locationpicker.LocationPick;


public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference<?> serviceReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		Activator.context = bundleContext;
		String location;
		
		System.out.println("Location Picker consumer started.");
		serviceReference = bundleContext.getServiceReference(LocationPick.class.getName());
		LocationPick Locationpick = (LocationPick) bundleContext.getService(serviceReference);
		
		System.out.println("Please enter a location..");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		location = in.readLine();
		
		Locationpick.pickLocation(location);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Location Picker consumer stoped..");
		bundleContext.ungetService(serviceReference);
	}

}

package com.mtit.weatherappconsumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.weatherprovider.WeatherProvider;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference<?> serviceReference;
	
	static BundleContext getContext() {
		return context;
	}

	String location;
	
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Weather Provider Consumer started...");
		serviceReference=bundleContext.getServiceReference(WeatherProvider.class.getName());
		WeatherProvider weatherProvider=(WeatherProvider)bundleContext.getService(serviceReference);
		
		System.out.println("please enter a location");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		location=in.readLine();
		weatherProvider.provideWeather(location);
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Weather Provider Consumer stoped...");
		bundleContext.ungetService(serviceReference);
	}

}

package consumeweatherguide;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import produceweatherguide.WeatherGuide;

public class Activator implements BundleActivator {
	
	ServiceReference<?> serviceReference;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	String location;

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		System.out.println("Weather Guider Consumer started...");
		serviceReference=bundleContext.getServiceReference(WeatherGuide.class.getName());
		WeatherGuide WeatherGuide=(WeatherGuide)bundleContext.getService(serviceReference);
		
		System.out.println("please enter a location");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		location=in.readLine();
		WeatherGuide.guideWeather(location);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Weather Guider Consumer stoped...");
		bundleContext.ungetService(serviceReference);
	}

}

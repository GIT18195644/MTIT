package produceweatherguide;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration<?> serviceRegistration;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		Activator.context = bundleContext;
		Hashtable<String,String> props = new Hashtable<>();
		props.put("Country" , "Sri Lanka");
		System.out.println("Weather guider started....");
		
		WeatherGuide wg = new WeatherGuideImpl();
		serviceRegistration = bundleContext.registerService(WeatherGuide.class.getName() , wg , props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Weather guider stopped....");
		serviceRegistration.unregister();
	}

}

package producelocationtracker;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

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
		System.out.println("Location tracker start");
		LocationTrack locTracker = new LocationTrackImpl();
		serviceRegistration = bundleContext.registerService(LocationTrack.class.getName(), locTracker, props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		
		System.out.println("Location tracker stop");
		serviceRegistration.unregister();
	}

}

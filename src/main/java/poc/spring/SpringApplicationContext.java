package poc.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * The bean definition for this bean is:
 * <bean class="ca.on.gov.edu.common.util.SpringApplicationContext"/>
 *
 * Get a reference for a "mySpringBean" bean which has been defined in the Spring context:
 *		MySpringBean mySpringBean = SpringApplicationContext.getBean("mySpringBean");
 *  	// do something with MySpringBean
 * 
 * @author zhuyo
 *
 */
public class SpringApplicationContext implements ApplicationContextAware {

	public static final String BEAN_ID_APP_NAME = "appName";
	
	private static ApplicationContext context;
	private static boolean isDestroyed = false;
	
	private static final Log log = LogFactory.getLog(SpringApplicationContext.class);

	@PreDestroy
	public void preDestroyListener() {
		if(log.isInfoEnabled()) {
			log.info("preDestroyListener - " + isDestroyed);
		}
		isDestroyed = true;
	}
	@PostConstruct
	public void init() {
		//RE-INIT spring context
		if(log.isInfoEnabled()) {
			log.info("init - " + isDestroyed);
		}
		isDestroyed = false;
	}
	
	/**
	 * This method will be called when the ApplicationContext starting up,
	 *  once it is done, it will stick a reference to itself into this bean.
	 * 
	 * @param context
	 *            a reference to the ApplicationContext.
	 */
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if(null==context) return null;
		return (T)context.getBean(beanName);		
	}
	
	public static boolean containsBean(String beanName) {
		if(null==context) return false;
		return context.containsBean(beanName);
	}

	public static boolean isApplicationContextDestroyed() {
		return isDestroyed;
	}
	
	
	public static String retrieveAppIdentifer() {		
		
		if(SpringApplicationContext.containsBean(BEAN_ID_APP_NAME)) {
			return SpringApplicationContext.getBean(BEAN_ID_APP_NAME);
		}else {
			return null;
		}
		
	}
	
}

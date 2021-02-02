package presentation;

import java.beans.Beans;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	private Messages() {
		// do not instantiate
	}

	////////////////////////////////////////////////////////////////////////////
	//
	// Bundle access
	//
	////////////////////////////////////////////////////////////////////////////
	private static final String BUNDLE_NAME = "presentation.messages"; //$NON-NLS-1$
	private static ResourceBundle RESOURCE_BUNDLE = loadBundle();

	private static ResourceBundle loadBundle() {
		return ResourceBundle.getBundle(BUNDLE_NAME);
	}

	////////////////////////////////////////////////////////////////////////////
	//
	// Strings access
	//
	////////////////////////////////////////////////////////////////////////////
	public static String getString(String key) {
		try {
			ResourceBundle bundle = Beans.isDesignTime() ? loadBundle() : RESOURCE_BUNDLE;
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}

	private static Locale getLocale(String appIdioma) {
		Locale locale = new Locale("es");
		if (appIdioma.equals("ingl�s"))
			locale = new Locale("en");
		if (appIdioma.equals("espa�ol"))
			locale = new Locale("es");
		return locale;
	}

	public static void setIdioma(String idioma) {
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, getLocale(idioma));
	}

}

/*
 * (c) Copyright 2002, 2005 Uwe Voigt
 * All Rights Reserved.
 */
package zipeditor.actions;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ActionMessages {
	private static final String BUNDLE_NAME = "zipeditor.actions.ActionMessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private ActionMessages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getFormattedString(String key, Object argument) {
		try {
			String pattern = RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(pattern, argument instanceof Object[] ? (Object[]) argument : new Object[] { argument });
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

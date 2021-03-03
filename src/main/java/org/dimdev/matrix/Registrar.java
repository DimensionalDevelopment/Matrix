package org.dimdev.matrix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies the namespace for registry entries.
 *
 * <p>This must be annotated on the class you wish
 * to keep all your registry entries (as fields).</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Registrar {
	Class<?> element();

	String modid();
}

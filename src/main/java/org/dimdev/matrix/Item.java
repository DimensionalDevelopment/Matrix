package org.dimdev.matrix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Item {

    /**
     * Sets the item registry name for the item.
     */
    String registryName() default "";

    /**
     * Sets the translation key for the item.
     */
    String translationKey() default "";

    /**
     * Sets the creative tab for the item
     */
    Class<?> creativetab();

}

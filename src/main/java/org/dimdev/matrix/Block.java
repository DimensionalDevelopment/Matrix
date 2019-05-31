package org.dimdev.matrix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Block {

    /**
     * Sets the item registry name for the block.
     */
    String registryName() default "";

    /**
     * Sets the translation key for the block.
     */
    String translationKey() default "";

}

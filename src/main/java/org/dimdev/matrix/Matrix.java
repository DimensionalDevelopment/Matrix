package org.dimdev.matrix;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * An Annotation Based Registration Library.
 *
 * <p>Matrix allows registering items, blocks, etc. without
 * calling {@code Registry.register(...)} a bunch of times or
 * registering at static init. Registering at static init
 * is not safe as you might just register the entries much
 * before vanilla registers its entries.</p>
 *
 * <p>Using Annotations is simple and easy to migrate to.
 * You no longer have to worry about skipping a call to
 * {@code Registry.register(...)}.</p>
 */
public class Matrix {
	/**
	 *
	 * @param clazz The class that should be scanned for registry entries.
	 * @param registry The registry that entries should be registered to.
	 * @param entryClass The class that each registry entry should be an instance of.
	 * @param <T> The registry's container type.
	 */
	public static <T> void register(Class<?> clazz, Registry<T> registry, Class<T> entryClass) {
		String modId = Optional.ofNullable(clazz.getAnnotation(Register.class)).orElseThrow(() -> new UnsupportedOperationException(clazz.getName() + " did not have the Register annotation!")).modid();
		Arrays.stream(clazz.getFields())
				.filter(field -> {
					int modifiers = field.getModifiers();
					return Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers);
				})
				.filter(field -> field.isAnnotationPresent(RegistryEntry.class))
				.filter(field -> entryClass.isAssignableFrom(field.getType()))
				.forEach(field -> {
					T value;
					try {
						//noinspection unchecked
						value = (T) field.get(null);
					} catch (IllegalAccessException e) {
						throw new AssertionError(e); // cant happen
					}
					Identifier id = new Identifier(modId, field.getAnnotation(RegistryEntry.class).value());
					Registry.register(registry, id, value);
				});
	}
}

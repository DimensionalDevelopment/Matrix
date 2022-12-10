package org.dimdev.matrix;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

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
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void register(Class<?> clazz, Registry<?> registry) {
		Registrar registrar = clazz.getAnnotation(Registrar.class);
		if (registrar == null) {
			return;
		}

		String modid = registrar.modid();
		Class<?> element = registrar.element();

		Arrays.stream(clazz.getFields())
				.filter(field -> field.isAnnotationPresent(RegistryEntry.class)
						&& Modifier.isPublic(field.getModifiers())
						&& Modifier.isStatic(field.getModifiers())
						&& Modifier.isFinal(field.getModifiers())
						&& element.isAssignableFrom(field.getType())
				)
				.forEach(field -> {
					try {
						Object value = field.get(null);
						Registry.register((Registry) registry, new Identifier(modid, field.getAnnotation(RegistryEntry.class).value()), element.cast(value));
						if (value instanceof BlockItem) {
							Item.BLOCK_ITEMS.put(((BlockItem) value).getBlock(), (Item) value);
						}
					} catch (IllegalAccessException e) {
						throw new AssertionError(e);
					}
				});
	}
}

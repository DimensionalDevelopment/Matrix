package org.dimdev.matrix;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.lang.reflect.Modifier;
import java.util.Arrays;

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
	 * @param registryKey The resource key for the registry being registered to.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T, S> void register(Class<T> clazz, ResourceKey<Registry<S>> registryKey) {
		Registrar registrar = clazz.getAnnotation(Registrar.class);
		if (registrar == null) {
			return;
		}

		String modid = registrar.modid();

		Class<?> element = registrar.element();

		DeferredRegister<S> deferredRegister = DeferredRegister.create(modid, registryKey);

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

						deferredRegister.register(new ResourceLocation(modid, field.getAnnotation(RegistryEntry.class).value()), () -> (S) value);
						if (value instanceof BlockItem) {
							Item.BY_BLOCK.put(((BlockItem) value).getBlock(), (Item) value);
						}
					} catch (IllegalAccessException e) {
						throw new AssertionError(e);
					} catch (ClassCastException e) {
						//TODO: Make this print more concise details than a stacktrace
						e.printStackTrace();
					}
				});
	}
}

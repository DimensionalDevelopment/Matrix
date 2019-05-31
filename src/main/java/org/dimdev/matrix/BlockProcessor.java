package org.dimdev.matrix;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("org.dimdev.matrix.Block")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BlockProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            for (Element element : roundEnv.getElementsAnnotatedWith(Block.class)) {
                Matrix.addBlock(element.getClass().getConstructor().newInstance(element.getModifiers()));
            }
        } catch (Exception e) {

        }
        return true;
    }

}

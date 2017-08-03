package cn.cj.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Set;

/**
 * Created by hp on 2017/8/1.
 */
@SupportedAnnotationTypes({"cn.cj.processor.MyAnnot"/*, "cn.cj.processor.OtherAnnot"*/ /*完整包路径、多个类似字符串数组*/})
public class MyProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager msg = processingEnv.getMessager();
        for (TypeElement te : annotations){
            for (Element e : roundEnv.getElementsAnnotatedWith(te)){
                msg.printMessage(Diagnostic.Kind.NOTE, "qqqqqqqqqq - Printing: " + e.toString());
            }
        }
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}


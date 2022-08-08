import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import preprocessor.PreProcessor;
import preprocessor.PreProcessorToLower;
import preprocessor.PreProcessorToUpperImpl;
import printer.Printer;
import printer.PrinterWithDateTimeImpl;
import printer.PrinterWithPrefixImpl;
import renderer.Renderer;
import renderer.RendererErrImpl;
import renderer.RendererStandardImpl;

import java.time.LocalDateTime;

public class Program {

    public static void main(String[] args) {
//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        PreProcessor preProcessor1 = new PreProcessorToLower();
//        Renderer renderer = new RendererStandardImpl(preProcessor);
//        Renderer renderer1 = new RendererErrImpl(preProcessor1);
//        PrinterWithDateTimeImpl printer = new PrinterWithDateTimeImpl(renderer);
//        printer.setDateTime(LocalDateTime.now());
//        printer.print("Hello!") ;
//        PrinterWithPrefixImpl printer1 = new PrinterWithPrefixImpl(renderer1);
//        printer1.setPrefix("Prefix ");
//        printer1.print("Hello!");

//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        Renderer renderer = new RendererErrImpl(preProcessor);
//        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
//        printer.setPrefix("Prefix ");
//        printer.print("Hello!") ;

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefix", Printer.class);
        printer.print ("Hello!") ;
        Printer printer1 = context.getBean("printerWithDateTime", Printer.class);
        printer1.print ("Hello!") ;
//        PrinterWithPrefixImpl bean = context.getBean(PrinterWithPrefixImpl.class);
//        bean.setPrefix("asdfg");
//        System.out.println(bean.getPrefix());

    }
}

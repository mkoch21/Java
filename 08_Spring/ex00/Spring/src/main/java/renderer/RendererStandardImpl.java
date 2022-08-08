package renderer;

import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl (PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    @Override
    public void print(String input) {
        System.out.println(this.preProcessor.process(input));
    }

}

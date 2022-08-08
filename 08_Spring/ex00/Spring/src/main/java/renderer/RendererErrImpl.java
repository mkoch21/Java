package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl (PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    @Override
    public void print(String input) {
        System.err.println(this.preProcessor.process(input));
    }
}

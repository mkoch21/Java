package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl () {
    }

    public PrinterWithPrefixImpl (Renderer renderer) {
        this.renderer = renderer;
        this.prefix = "";
    }

    @Override
    public void print(String input) {
        this.renderer.print(this.prefix + input);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

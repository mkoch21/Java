package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private LocalDateTime dateTime;

    Renderer renderer;

    public PrinterWithDateTimeImpl () {
    }

    public PrinterWithDateTimeImpl (Renderer renderer) {
        this.renderer = renderer;
        this.dateTime = LocalDateTime.now();
    }
    @Override
    public void print(String input) {
        this.renderer.print(this.dateTime.toString() + input);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

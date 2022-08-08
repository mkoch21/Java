package preprocessor;

public class PreProcessorToLower implements PreProcessor {

    @Override
    public String process (String input) {
        return input.toLowerCase();
    }

}

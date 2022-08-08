package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {

    @Override
    public String process (String input) {
        return input.toUpperCase();
    }

}

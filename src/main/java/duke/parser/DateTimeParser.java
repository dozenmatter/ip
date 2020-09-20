package duke.parser;

import java.text.SimpleDateFormat;

/**
 * Parses Date to string and vice versa
 */
public interface DateTimeParser {
    SimpleDateFormat STRING_TO_DATE = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat DATE_TO_STRING = new SimpleDateFormat("MMM d yyyy, h:mma");
    String ERROR_INVALID_DATE_STRING = "Please specify the date/time string in this format:\ndd/MM/yyyy HHmm";
}

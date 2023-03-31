package hu.me;

import hu.me.input.CsvReader;
import hu.me.output.Printer;

public class CalendarEngineImpl {

    private final CsvReader csvReader;
    private final Printer printer;
    private final JobConverter jobConverter;

    public CalendarEngineImpl(CsvReader csvReader, Printer printer, JobConverter jobConverter) {
        this.csvReader = csvReader;
        this.printer = printer;
        this.jobConverter = jobConverter;
    }

    public void process(String fileName) {
        printer.print(
                jobConverter.from(
                        csvReader.load(fileName)
                )
        );
    }
}

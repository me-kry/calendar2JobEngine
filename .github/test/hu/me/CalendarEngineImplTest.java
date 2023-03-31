package hu.me;

import hu.me.input.CsvReader;
import hu.me.model.Calendar;
import hu.me.model.Job;
import hu.me.output.Printer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CalendarEngineImplTest {

    @Test
    void process() {
        // GIVEN
        String fileName = "filename_2";

        CsvReader csvReader = mock(CsvReader.class);
        List<Calendar> calendarList = new ArrayList<>();
        when(csvReader.load(eq(fileName))).thenReturn(calendarList);

        JobConverter jobConverter = mock(JobConverter.class);
        List<Job> jobItemList = new ArrayList<>();
        when(jobConverter.from(same(calendarList))).thenReturn(jobItemList);

        Printer printer = mock(Printer.class);

        CalendarEngineImpl subject = new CalendarEngineImpl(
                csvReader, printer, jobConverter
        );


        // WHEN
        subject.process(fileName);

        // THEN
        verify(csvReader, times(1)).load(eq(fileName));
        verify(jobConverter, times(1)).from(same(calendarList));
        verify(printer, times(1)).print(same(jobItemList));
    }
}
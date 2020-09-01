/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface for mapping rows from a CSV file into Java objects.
 *
 * @author Steve Leach
 */
public interface CSVRowSource {

    String getString(String key);

    int getInteger(String key);

    Integer getIntegerOrNull(String key);

    BigDecimal getCurrencyValue(String key);

    LocalDate getDate(String key, String format);

    int getRowIndex();

    String getCurrentRowSource() throws IOException;

    List<String> getCurrentRowAsList();

    String getCurrentRowAsString();

    String getCurrentRowAsString(char separator);

    String getCurrentRowAsString(String separator);

}

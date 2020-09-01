/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GlaUtils {

    static Logger log = LoggerFactory.getLogger(GlaUtils.class);

    private static Random rnd = new Random();

    /**
     * @param string a string representation of an integer.
     * @return the parsed integer value or null if the given value wasn't an integer.
     */
    public static Integer parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal addBigDecimals(BigDecimal bd1, BigDecimal bd2) {
        if (bd1 == null && bd2 == null) {
            return null;
        }

        if (bd1 == null) return bd2;
        if (bd2 == null) return bd1;

        return bd1.add(bd2);
    }

    public static BigDecimal addBigDecimals(BigDecimal ... bigDecimals) {
        BigDecimal result = new BigDecimal(0);
        for (BigDecimal bd: bigDecimals) {
            result = addBigDecimals(result, bd);
        }
        return result;
    }

    public static int compareBigDecimals(BigDecimal bd1,  BigDecimal bd2) {
        if (bd1 == null && bd2 == null) {
            return 0;
        }

        if (bd1 == null) return -1;
        if (bd2 == null) return 1;

        return bd1.compareTo(bd2);
    }

    public static boolean areEqual(BigDecimal bd1,  BigDecimal bd2) {
        if (bd1 == null && bd2 == null) {
            return true;
        }

        if (bd1 != null && bd2 != null) {
            return bd1.compareTo(bd2) == 0;
        }

        return false;
    }

    public static Integer nullSafeAdd(Integer ... numbers) {
        Integer sum = 0;
        for (Integer n: numbers) {
            sum += (n == null ? 0 : n);
        }
        return sum;
    }



    public static Long nullSafeAdd(Long ... numbers) {
        Long sum = 0L;
        for (Long n: numbers) {
            sum += (n == null ? 0 : n);
        }
        return sum;
    }

    public static BigDecimal nullSafeAdd(BigDecimal ... numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal n: numbers) {
            sum = sum.add(n == null ? BigDecimal.ZERO : n);
        }
        return sum;
    }

    public static Integer nullSafeMultiply(Integer ... numbers) {
        Integer result = 1;
        for (Integer n: numbers) {
            if (n == null) {
                return null;
            }
            else {
                result *= n;
            }
        }
        return result;
    }

    /**
     * Returns true if both arguments are equal; either both null, or both non-null and matched via equals().
     */
    public static boolean nullSafeEquals(Object o1, Object o2) {
        if ((o1 == null) && (o2 == null)) {
            return true;
        }
        if ((o1 == null) || (o2 == null)) {
            return false;
        }
        return o1.equals(o2);
    }

    public static String nullSafeConcat(String ... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string: strings) {
            if (string != null) {
                sb.append(string);
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    public static String getStackTraceAsString(Throwable error) {
        if (error == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (error.getMessage() != null) {
            sw.write(error.getMessage());
            sw.write("\n");
        }
        error.printStackTrace(pw);
        return sw.toString();
    }

    /**
     * Returns a string with all the values in the list, separated by commas.
     */
    public static String listToString(List values) {
        if (values == null) {
            return "";
        }
        if (values.size() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (Object value : values) {
            if (result.length() > 0) {
                result.append(",");
            }
            result.append(value.toString());
        }
        return result.toString();
    }

    public static boolean notNull(final Object o) {
        return o != null;
    }

    public static String getFileContent(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()), UTF_8);
        } catch (IOException e) {
            log.error("Error reading file " + file.getName(), e);
            return null;
        }
    }

    public static List createNullIgnoringList() {
        return new ArrayList() {
            @Override
            public boolean add(Object o) {
                if (o == null) {
                    return true;
                }
                else {
                    return super.add(o);
                }
            }
        };
    }

    public static boolean isNullOrEmpty(final String externalId) {
        return externalId == null || externalId.isEmpty();
    }

    /**
     * Converts non-breaking spaces to normal spaces.
     */
    public static String breakAllSpaces(String original) {
        return original.replace((char)160,' ');
    }

    /**
     * Enhanced trim() function. Trims non-breaking spaces as well.
     */
    public static String superTrim(String original) {
        if (original == null) {
            return null;
        }
        return breakAllSpaces(original).trim();
    }

    public static List<String> csStringToList(String commaSeparatedString) {
        if (commaSeparatedString == null || commaSeparatedString.isEmpty()) {
            return Collections.emptyList();
        }  else {
            return Arrays.asList(commaSeparatedString.split(","));
        }
    }

    public static String listToCsString(List<String> list) {
        if (list != null) {
            return StringUtils.join(list, ",");
        } else {
            return "";
        }
    }

    public static OffsetDateTime parseDateString(String dateString, String format) {
        if (StringUtils.isNotEmpty(dateString)) {
            if (dateString.length() != format.length()) {
                dateString = dateString.substring(0, format.length());
            }
            return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(format)).atZone(ZoneId.systemDefault()).toOffsetDateTime();
        }  else {
            return null;
        }
    }

    /**
     * Converts LocalDate to OffsetDateTime with the default time zone and at the start of the day (00:00)
     * @param localDate
     * @return
     */
    public static OffsetDateTime toOffsetDateTime(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return localDate.atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
    }

    public static String getRequestIp() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (request != null) {
                return StringUtils.join(request.getRemoteAddr(), request.getHeader("HTTP_X_FORWARDED_FOR"), request.getHeader("X-Forwarded-For"), " ").trim();
            }
        }
        return null;
    }

    @Deprecated
    public static int getCurrentQuarter(int month) {
        return getQuarterFor(month);
    }

    public static int getQuarterFor(int month) {
        if (month > 3 && month <= 6) {
            return 1;
        } else if (month > 6 && month <= 9) {
            return 2;
        } else if (month > 9 && month <= 12) {
            return 3;
        } else {
            return 4;
        }
    }

    public static int getFirstMonthInQuarter(int quarter) {
        if (quarter == 1) {
            return 4;
        } else if (quarter == 2) {
            return 7;
        } else if (quarter == 3) {
            return 10;
        } else {
            return 1;
        }
    }

    public static int getActualYearFrom(int financialYear, int quarter) {
        return quarter == 4 ? financialYear + 1 : financialYear;
    }

    public static String getFinancialYearFromYear(int year) {

        int nextYear = Integer.parseInt(String.valueOf(year + 1).substring(2));




        return String.format(year + "/%02d", nextYear);
    }

    public static String getFinancialYearList(List<Integer> years, String separator) {
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < years.size(); i++) {
            response.append(getFinancialYearFromYear(years.get(i))).append(separator);
        }
        return response.toString().substring(0, response.length() - separator.length());
    }

    public static int getActualMonthFromAcademicPeriod(int period) {
        return ((period + 6) % 12) + 1;
    }

    public static String getActualMonthNameFromAcademicPeriod(int period) {
        int actualMonth = getActualMonthFromAcademicPeriod(period);
        return Month.of(actualMonth).name();
    }

    /**
     * @param year financial year format: "YYYY/YY" (ex: 2018/19)
     *                                           "YY/YY" (ex: 18/19)
     * @return in the example above 2018
     */
    public static Integer parseYear(String year) {
        Integer returnYear = null;
        if (year != null) {
            if (year.charAt(4) == '/') {
                returnYear = Integer.valueOf(year.substring(0, 4));
            } else if (year.charAt(2) == '/') {
                returnYear = Integer.valueOf("20" + year.substring(0, 2));
            }
        }
        return returnYear;
    }

    public static String generateRandomId() {
        int idNum = rnd.nextInt(Integer.MAX_VALUE);
        idNum /= 2;                     // Remove small values
        idNum += Integer.MAX_VALUE / 2;

        // Convert to a hex string
        return String.format("%x", idNum);
    }

}

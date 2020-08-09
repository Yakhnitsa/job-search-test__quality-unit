package com.yurets_y.service;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.ResponseType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryExtractorImpl implements QueryExtractor {
    private final String SERVICE_ID_PATTERN = "(\\*|([1-9]|10)(\\.[1-3])?)";
    private final String QUESTION_ID_PATTERN = "(\\*|([1-9]|10)(\\.([1-9]|(1\\d)|20))?(\\.[1-5])?)";
    private final String TYPE_PATTERN = "[P,N]";
    private final String DATE_PATTERN = "\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}";
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


    @Override
    public QueryEntity getQuery(String query) {
        if(!queryStringTest(query)) return null;
        String[] params = query.split(" ");
        if(params.length != 5) return null;
        String serviceId = params[1];
        String questionId = params[2];
        ResponseType type = ResponseType.valueOf(params[3]);

        String[] dates = params[4].split("-");

        Date dateFrom = null;
        Date dateUntil = null;
        try{
            dateFrom = DATE_FORMAT.parse(dates[0]);
            dateUntil = dates.length == 2 ? DATE_FORMAT.parse(dates[1]) : null;
        }catch (ParseException e){
            return null;
        }

        return new QueryEntity(serviceId,questionId,type,dateFrom,dateUntil);
    }

    private boolean queryStringTest(String query){
        String pattern = "D\\s" +  SERVICE_ID_PATTERN + "\\s" + QUESTION_ID_PATTERN + "\\s" +
                TYPE_PATTERN + "\\s" + DATE_PATTERN + "(-" + DATE_PATTERN + ")?";
        return query.matches(pattern);
    }
}

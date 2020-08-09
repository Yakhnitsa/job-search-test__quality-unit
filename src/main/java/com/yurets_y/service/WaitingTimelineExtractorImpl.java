package com.yurets_y.service;

import com.yurets_y.entity.ResponseType;
import com.yurets_y.entity.WaitingTimelineEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingTimelineExtractorImpl implements WaitingTimelineExtractor {
    private final String SERVICE_ID_PATTERN = "([1-9]|10)(\\.[1-3])?";
    private final String QUESTION_ID_PATTERN = "([1-9]|10)(\\.([1-9]|(1\\d)|20))?(\\.[1-5])?";
    private final String TYPE_PATTERN = "[P,N]";
    private final String DATE_PATTERN = "\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}";
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public WaitingTimelineEntity getWaitingTimelineEntity(String query) {
        if(!testQuery(query)) return  null;
        String[] params = query.split(" ");
        if(params.length != 6) return null;

        String serviceId = params[1];
        String questionId = params[2];
        ResponseType type = ResponseType.valueOf(params[3]);

        Integer time = null;
        Date date = null;
        try {
            date = DATE_FORMAT.parse(params[4]);
            time = Integer.parseInt(params[5]);
        } catch (ParseException e) {
            return null;
        }
        return new WaitingTimelineEntity(serviceId,questionId,type,date,time);
    }

    private boolean testQuery(String query){
        String pattern = "C\\s" +  SERVICE_ID_PATTERN + "\\s" + QUESTION_ID_PATTERN + "\\s" +
                TYPE_PATTERN + "\\s" + DATE_PATTERN + "\\s\\d+";
        return query.matches(pattern);
    }
}

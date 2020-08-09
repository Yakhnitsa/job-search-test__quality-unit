package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.ResponseType;
import com.yurets_y.entity.WaitingTimelineEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StorageServiceTest {
    private static final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");


    public static void findByServiceIdTest(){


    }

    public static void main(String[] args) throws ParseException {
        storageServiceMatcherTest();
    }
    private static void storageServiceMatcherTest() throws ParseException {
        StorageServiceImpl storageService = new StorageServiceImpl();
        List<WaitingTimelineEntity> entities = getTestData();
        QueryEntity queryEntity = getTestQueryEntity();
        entities.forEach(entity ->{
            if (storageService.isStorageEntityMatchesQueryEntity(entity, queryEntity)) {
                System.out.println(entity);
            }
        });

    }


    private static List<WaitingTimelineEntity> getTestData() throws ParseException {

        ResponseType typeP = ResponseType.P;
        ResponseType typeN = ResponseType.N;

        return Arrays.asList(new WaitingTimelineEntity[]{
                new WaitingTimelineEntity("10","2.12.1",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("10.1","3.5",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("9.5","5.16.4",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("10.3","1.2",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("1.1","6.7",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("2.2","10.3",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("2","1",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("2.3","15.6.5",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("4.2","4.5",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("4","5.1",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("1.1","8.5.1",typeP,df.parse("10.01.2020"),100),
                new WaitingTimelineEntity("10.1","2.12",typeP,df.parse("10.01.2020"),100),
        });
    }
    private static QueryEntity getTestQueryEntity() throws ParseException {

        String serviceId = "1";
        String questionId = "*";
        ResponseType type = ResponseType.P;
        Date dateFrom = df.parse("01.01.2020");
        Date dateUntil = df.parse("10.01.2020");

        Date nullDate = null;
        return new QueryEntity(serviceId,questionId,type,dateFrom,dateUntil);
    }


}


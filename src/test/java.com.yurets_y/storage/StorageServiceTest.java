package storage;

import com.yurets_y.entity.StorageEntity;
import com.yurets_y.storage.StorageService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StorageServiceTest {
    private static List<StorageEntity> testData = Arrays.asList(new StorageEntity[]{
            new StorageEntity("10","2.12.1",new Date(),100),
            new StorageEntity("10.1","3.5",new Date(),100),
            new StorageEntity("9.5","5.16.4",new Date(),100),
            new StorageEntity("10.3","1.2",new Date(),100),
            new StorageEntity("1.1","6.7",new Date(),100),
            new StorageEntity("2.2","10.3",new Date(),100),
            new StorageEntity("2","1",new Date(),100),
            new StorageEntity("2.3","15.6.5",new Date(),100),
            new StorageEntity("4.2","4.5",new Date(),100),
            new StorageEntity("4","5.1",new Date(),100),
            new StorageEntity("1.1","8.5.1",new Date(),100),
            new StorageEntity("10.1","10",new Date(),100),
    });

    public static void findByServiceIdTest(){
        String searchId1 = "10";
        String searchId2 = "10.2";
        String searchId3 = "9.6";
        findById(searchId2);

    }

    public static void main(String[] args){
//        String testString = "10.2";
//        System.out.println(testString.matches("10.1(\\.\\d)?(\\.\\d)?"));
        findByServiceIdTest();
    }

    public static void findById(String id){
        String pattern = id + "(\\.\\d)?(\\.\\d)?";
        testData.forEach(entity ->{
            if(entity.getServiceId().matches(pattern)){
                System.out.println(entity);
            }
//            else{
//                System.out.println(entity.getServiceId() + " do not matches pattern " + pattern);
//            }
        });
    }
}


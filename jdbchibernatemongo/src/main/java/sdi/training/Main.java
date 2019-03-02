package sdi.training;

import sdi.training.dto.CatPassportContent;
import sdi.training.model.CatPassport;
import sdi.training.model.CatPassportHibernate;
import sdi.training.service.CatPassportService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... arg) {
        System.out.println("Hello Wourld!!!");


        CatPassportService catPassportService = new CatPassportService();


//        catPassportService.addCatPassportContent(new CatPassport("TEST"));

        //     List<CatPassport> catPassportList = catPassportService.getAllCatPassports();

        //     catPassportList.forEach(System.out::println);
        List<String> vaccines = new ArrayList<>();
        vaccines.add("TRE");
        vaccines.add("HYG");

        CatPassportContent catPassportContent = new CatPassportContent(
                "name",
                "120234-103",
                1L,
                vaccines,
                "JIASHIHASIF"
        );

     //   catPassportService.addCatPassportContent(catPassportContent);
     //   catPassportService.getCatPassportMongo("120234-103");

        List<CatPassportHibernate> passports = null;

       // passports = catPassportService.getAllHIBERNATE_JPGL();

        // passports = catPassportService.getAllHIBERNATE_CRITERIA();

// passports = catPassportService.getAllHIBERNATE_DAO();

        passports.forEach(System.out::println);
    }
}

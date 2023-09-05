package thatdz.java6.java6lab1.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import thatdz.java6.java6lab1.entity.Country;
import thatdz.java6.java6lab1.entity.People;
import thatdz.java6.java6lab1.entity.Slogan;

@Repository
public class PeopleRepository {
    public File file = new File("");
    public String pathToFolder = file.getAbsolutePath() + "\\src\\jsondata\\";

    public String jsondata1 = file.getAbsolutePath() + "\\src\\jsondata\\people_0.json";
    public final int pageSize = 10;
    public int pageno = 1;

    public List<People> getListFromOneFile(String path) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream fileInputStream = new FileInputStream(jsondata1);
        // List<People> post = mapper.readTree(fileInputStream);
        List<People> listPeople = mapper.readValue(fileInputStream, new TypeReference<List<People>>() {
        });
        fileInputStream.close();
        return listPeople;
    }

    public List<Slogan> getSlogan(List<People> list) {
        List<String> getSetSlogan = new ArrayList<>();
        List<Slogan> slogans = new ArrayList<>();
        list.forEach((pp) -> {
            List<String> txt = Arrays.asList(pp.getSlogan().split(" "));
            txt.forEach((n) -> {
                getSetSlogan.add(n);
            });
        });
        Map<String, Integer> duplicateCountMap = getSetSlogan
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), company -> 1, Math::addExact));
        duplicateCountMap.forEach(
                (key, value) -> slogans.add(new Slogan(key, value)));

        List<Slogan> sortedList = slogans.stream()
                .sorted(Comparator.comparingInt(Slogan::GetCount)
                        .reversed())
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Country> getQuocGia(List<People> list) {
        List<String> quocgias = new ArrayList<>();
        List<Country> res = new ArrayList<>();
        list.forEach((pp) -> {
            quocgias.add(pp.getCountry());
        });
        Map<String, Integer> duplicateCountMap = quocgias
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), company -> 1, Math::addExact));
        duplicateCountMap.forEach(
                (key, value) -> res.add(new Country(key, value)));

        List<Country> sortedList = res.stream()
                .sorted(Comparator.comparingInt(Country::GetCount)
                        // .reversed()
                        )
                .collect(Collectors.toList());
        return sortedList;
    }

    public int[] getPanigation() {
        int size;
        try {
            size = getListFromOneFile(jsondata1).size();
        } catch (IOException e) {
            size = 0;
            e.printStackTrace();
        }
        int numpage = Math.round(size / pageSize);
        int[] panigation = IntStream.rangeClosed(1, numpage).toArray();
        return panigation;
    }

    public int[] panigationRelase() {
        int[] panigation = getPanigation();
        int[] pani;
        if (this.pageno <= 2) {
            pani = IntStream.rangeClosed(1, 5).toArray();
        } else if (this.pageno >= panigation.length - 2) {
            pani = IntStream.rangeClosed(panigation.length - 4, panigation.length).toArray();
        } else {
            pani = IntStream.rangeClosed(this.pageno - 2, this.pageno + 2).toArray();
        }
        return pani;
    }

    public List<People> getObjectInPage(int pageno) {
        List<People> list = new ArrayList<People>();
        if (pageno < getPanigation().length) {
            this.pageno = pageno;
            try {
                for (int index = (pageno - 1) * 10; (index < (pageno) * 10)
                        && (index < getListFromOneFile(jsondata1).size()); index++) {
                    People people = getListFromOneFile(jsondata1).get(index);
                    list.add(people);
                }
            } catch (Exception e) {
                System.out.println("1h rooi di ngu thoi");
            }
        } else {
        }
        return list;
    }

    public List<People> getPrevPage() {
        if (this.pageno <= 1) {
            return getObjectInPage(1);
        } else {
            return getObjectInPage(this.pageno - 1);
        }
    }

    public List<People> getNextPage() {
        if (this.pageno >= this.getPanigation().length) {
            return getObjectInPage(this.getPanigation().length);
        } else {
            return getObjectInPage(this.pageno + 1);
        }
    }

    public void margeFile() {
        List<People> listpp = getAllPeoples();
        // System.out.println(listpp.size());
        JsonFactory factory = new JsonFactory();

        try (JsonGenerator generator = factory.createGenerator(new File(pathToFolder + "margefile\\post.json"),
                JsonEncoding.UTF8)) {
            generator.writeStartArray(); // Start the JSON array

            listpp.forEach((pp) -> {
                try {
                    generator.writeStartObject();
                    generator.writeStringField("id", pp.getId().toString());
                    generator.writeStringField("first_name", pp.getFirst_name());
                    generator.writeStringField("last_name", pp.getLast_name());
                    generator.writeStringField("email", pp.getEmail());
                    generator.writeStringField("gender", pp.getGender());
                    generator.writeStringField("ip_address", pp.getIp_address());
                    generator.writeStringField("avatar", pp.getAvatar());
                    generator.writeStringField("country", pp.getCountry());
                    generator.writeStringField("job", pp.getJob());
                    generator.writeStringField("company", pp.getCompany());
                    generator.writeStringField("salary", pp.getSalary());
                    generator.writeStringField("username", pp.getUsername());
                    generator.writeStringField("password", pp.getPassword());
                    generator.writeStringField("slogan", pp.getSlogan());
                    generator.writeEndObject();
                } catch (IOException e) {
                    System.out.println("Cannot write object");
                }
            });

            generator.writeEndArray(); // End the JSON array
            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public List<People> getAllPeoples() {
        List<People> listpp = new ArrayList<People>();
        List<String> filestrs = Arrays.asList(new File(pathToFolder).list());
        List<String> filestr = filestrs.stream()
                .filter(filename -> filename.endsWith(".json"))
                .collect(Collectors.toList());
        filestr.forEach((n) -> {
            try {
                listpp.addAll(getListFromOneFile(pathToFolder + n));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        return listpp;
    }

    public List<People> getSortList(List<People> list) {
        List<People> listppsort = list.stream()
                .sorted((o1, o2) -> (int) (o2.getSalaryNum() - o1.getSalaryNum())).collect(Collectors.toList());
        return listppsort;
    }

    public static void main(String[] args) {
        PeopleRepository repo = new PeopleRepository();
        repo.getQuocGia(repo.getAllPeoples()).forEach((n) -> {
            System.out.println(n);
        });
    }
}
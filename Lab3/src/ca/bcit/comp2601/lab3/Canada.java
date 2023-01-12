package ca.bcit.comp2601.lab3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is our driver.
 *
 * @author  Amir Armion
 * @version V1.0
 */
public class Canada
{
    private static ArrayList<ProvinceTerritory> provinces;

    public static final int NUMBER_OF_PROVINCES = 13;
    public static final int MAXIMUM_PERCENT     = 100;

    public static void main(final String[] args)
    {
        provinces = new ArrayList<>();

        provinces.add(new ProvinceTerritory("British Columbia",          4400057));
        provinces.add(new ProvinceTerritory("Alberta",                   3645257));
        provinces.add(new ProvinceTerritory("Manitoba",                  1208268));
        provinces.add(new ProvinceTerritory("Nunavut",                   31906));
        provinces.add(new ProvinceTerritory("Saskatchewan",              1033381));
        provinces.add(new ProvinceTerritory("Nova Scotia",               921727));
        provinces.add(new ProvinceTerritory("New Brunswick",             751171));
        provinces.add(new ProvinceTerritory("Ontario",                   12851821));
        provinces.add(new ProvinceTerritory("Newfoundland and Labrador", 514536));
        provinces.add(new ProvinceTerritory("Prince Edward Island",      140204));
        provinces.add(new ProvinceTerritory("Quebec",                    7903001));
        provinces.add(new ProvinceTerritory("Northwest Territories",     41462));
        provinces.add(new ProvinceTerritory("Yukon",                     33897));



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> All provinces of Canada with their populations (Sorted Alphabetically):\n");

        List<ProvinceTerritory> provCanada = provinces.stream()
                .sorted(Comparator.comparing(p -> p.getNameOfProvince()))
                .collect(Collectors.toList());

        provCanada.forEach(p -> System.out.println(p.getNameOfProvince() + " :: " + p.getPopulation()));



        System.out.println("\n\n--------------------------------------------------\n");

        int sum = provinces.stream()
                .mapToInt(ProvinceTerritory::getPopulation).sum();

        System.out.println(">> Canada population: " + sum);



        System.out.println("\n\n--------------------------------------------------\n");

        List<ProvinceTerritory> pro = provinces.stream()
                .filter(p -> p.getPopulation() < 100000)
                .collect(Collectors.toList());

        System.out.println(">> Number of provinces that have population less than 100,000 people: " + pro.size());



        System.out.println("\n\n--------------------------------------------------\n");

        List<ProvinceTerritory> proMoreThanOneMillion = provinces.stream()
                .filter(p -> p.getPopulation() > 1000000)
                .collect(Collectors.toList());

        System.out.println(">> How many provinces in Canada have population more than 1 million: " +
                proMoreThanOneMillion.size());



        System.out.println("\n\n--------------------------------------------------\n");

        List<ProvinceTerritory> prosMoreThanOneMillion = provinces.stream()
                .filter(p -> p.getPopulation() > 1000000)
                .collect(Collectors.toList());

        double total   = prosMoreThanOneMillion.size();
        double percent = (total / NUMBER_OF_PROVINCES) * MAXIMUM_PERCENT;

        System.out.printf(">> The percent of provinces in Canada have population more than 1 million: %.2f%%%n", percent);



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> All provinces of Canada with population more than 1 million people (Sorted based on " +
                "population):\n");

        List<ProvinceTerritory> prov = provinces.stream()
                .filter(p -> p.getPopulation() > 1000000)
                .sorted(Comparator.comparing(ProvinceTerritory::getPopulation))
                .collect(Collectors.toList());

        prov.forEach(p -> System.out.println(p.getNameOfProvince() + " :: " + p.getPopulation()));



        System.out.println("\n\n--------------------------------------------------\n");

        provinces.stream()
                .max(Comparator.comparing(ProvinceTerritory::getPopulation))
                .ifPresent(maxPopProv -> System.out.println(">> Province with Maximum population is \"" +
                        maxPopProv.getNameOfProvince().toUpperCase() + "\" with population " +
                        maxPopProv.getPopulation()));



        System.out.println("\n\n--------------------------------------------------\n");

        provinces.stream()
                .min(Comparator.comparing(ProvinceTerritory::getPopulation))
                .ifPresent(minPopProv -> System.out.println(">> Province with minimum population is \"" +
                        minPopProv.getNameOfProvince().toUpperCase() + "\" with population " +
                        minPopProv.getPopulation()));



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> All provinces of Canada with population between 1 million and 8 million (Sorted Alphabetically):\n");

        List<ProvinceTerritory> provs = provinces.stream()
                .filter(p -> ((p.getPopulation() > 1000000) && (p.getPopulation() < 8000000)))
                .sorted(Comparator.comparing(ProvinceTerritory::getNameOfProvince))
                .collect(Collectors.toList());

        provs.forEach(p -> System.out.println(p.getNameOfProvince() + " :: " + p.getPopulation()));



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> Grouping all provinces of Canada by their first letter:\n");

        Map<Character, List<ProvinceTerritory>> provMap = provinces.stream()
                .filter(p -> !p.getNameOfProvince().trim().isBlank())
                .collect(Collectors.groupingBy(p -> p.getNameOfProvince().charAt(0)));

        provMap.forEach((firstLetter, allProvs) ->
                {
                    System.out.println(firstLetter + ": ");
                    allProvs.forEach(p -> System.out.println(p.getNameOfProvince()));
                    System.out.println();
                }
        );



        System.out.println("\n--------------------------------------------------\n");

        Optional<ProvinceTerritory> longest = provinces.stream()
                .filter(p -> !p.getNameOfProvince().trim().isBlank())
                .max(Comparator.comparing(p -> p.getNameOfProvince().length()));

        longest.ifPresent(p -> System.out.println(">> Longest province name: " + p.getNameOfProvince()));



        System.out.println("\n\n--------------------------------------------------\n");

        Optional<ProvinceTerritory> shortest = provinces.stream()
                .filter(p -> !p.getNameOfProvince().trim().isBlank())
                .min(Comparator.comparing(p -> p.getNameOfProvince().length()));

        shortest.ifPresent(p -> System.out.println(">> Shortest province name: " + p.getNameOfProvince()));



        System.out.println("\n\n--------------------------------------------------\n");

        boolean anyIsMatch = provinces.stream()
                .anyMatch(p -> p.getPopulation() > 10000000);

        System.out.println(">> Canada has provinces with population more than 10 million: " + anyIsMatch);



        System.out.println("\n\n--------------------------------------------------\n");

        boolean allAreMatch = provinces.stream()
                .allMatch(p -> p.getPopulation() > 500000);

        System.out.println(">> All provinces in Canada has population more than 500,000 people: " + allAreMatch);



        System.out.println("\n\n--------------------------------------------------\n");

        boolean anyProv = provinces.stream()
                .filter(p -> !p.getNameOfProvince().trim().isBlank())
                .anyMatch(p -> p.getNameOfProvince().equalsIgnoreCase("Ontarioo"));

        System.out.println(">> \"Ontarioo\" is a province of Canada: " + anyProv);



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> All provinces of Canada whose name contains “m” (case in-sensitive): \n");

        List<ProvinceTerritory> provNameContain = provinces.stream()
                .filter(p -> (!p.getNameOfProvince().trim().isBlank()) &&
                       (p.getNameOfProvince().toLowerCase().contains("m")))
                .collect(Collectors.toList());

        provNameContain.forEach(p -> System.out.println(p.getNameOfProvince()));



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> All provinces of Canada whose name starts with “S” (case sensitive): \n");

        List<ProvinceTerritory> provStartWith = provinces.stream()
                .filter(p -> (!p.getNameOfProvince().trim().isBlank()) && (p.getNameOfProvince().startsWith("S")))
                .collect(Collectors.toList());

        provStartWith.forEach(p -> System.out.println(p.getNameOfProvince()));



        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println(">> The percent of total population for each province:\n");

        List<ProvinceTerritory> allPro = provinces.stream()
                .filter(p -> ((p.getNameOfProvince() != null) && (!p.getNameOfProvince().trim().isBlank())))
                .collect(Collectors.toList());

        int canadaPopulation = provinces.stream()
                .mapToInt(ProvinceTerritory::getPopulation).sum();

        allPro.forEach(p -> System.out.printf("%s :: %.2f%%%n", p.getNameOfProvince(),
                (((double) p.getPopulation() / canadaPopulation) * MAXIMUM_PERCENT)));
    }
}

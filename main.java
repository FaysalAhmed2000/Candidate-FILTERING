
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // This program will analyse and filter through creators to get the suitable match for the client
        static class Creator {

        private String creator ;
        private int followers;
        private double engagementRate;
        private String platform;

        Creator(String creator, int followers, double engagementRate, String platform) {
            this.creator = creator;
            this.followers = followers;
            this.engagementRate = engagementRate;
            this.platform = platform;

        }

        @Override
        public String toString(){
            return String.format(" Creator = '%s'| Followers = %d | Engagement Rate = %f | Platform = '%s' --- ", creator, followers, engagementRate, platform);
          }
        }

        public static void main(String[] args) throws InterruptedException {

        Stream<Creator> creators = Stream.of(
                new Creator("Creator 1", 1600000, 15, "Youtube"),
                new Creator("Creator 2", 2080000, 5, "Youtube"),
                new Creator("Creator 3", 5700000, 7, "Youtube"),
                new Creator("Creator 4", 11000000, 30, "Youtube"),
                new Creator("Creator 5", 108000, 7, "Youtube"),
                new Creator("Creator 6", 1400000, 9, "Youtube"),
                new Creator("Creator 7", 58100, 3, "Twitch"),
                new Creator("Creator 8", 38000, 7, "Twitch"),
                new Creator("Creator 9", 4400000, 50, "Instagram"),
                new Creator("Creator 10", 2900000, 10, "Youtube"),
                new Creator("Creator 11", 120000, 9, "Instagram"));


        System.out.println("Preferred amount of minimum followers from creator? (Insert): ");

        Scanner clientDesire = new Scanner(System.in);
        int clientMin = clientDesire.nextInt();

        Thread.sleep(500);

        System.out.println("Preferred amount of maximum followers from creator? (Insert Any Number): ");

        int clientMax = clientDesire.nextInt();

        Thread.sleep(500);

        System.out.println("Preferred amount of minimum Engagement rate from creator? (Insert 0-100): ");

        int clientErMin = clientDesire.nextInt();

        Thread.sleep(500);
            System.out.println("Preferred amount of maximum Engagement rate from creator? (Insert 0-100): ");

            int clientErMax = clientDesire.nextInt();

            Thread.sleep(500);
        System.out.println("Preferred Platform? (Youtube, Instagram, Twitter etc..): ");

        String clientPlatform = clientDesire.next();

        Thread.sleep(500);

        List<Creator> suitableCreator = creators.filter(f -> f.followers >= clientMin == f.followers <= clientMax)
                .filter(e -> e.engagementRate >= clientErMin == e.engagementRate <= clientErMax)
                .filter(p -> p.platform.equalsIgnoreCase(clientPlatform)).collect(Collectors.toList());

        System.out.println("Here are the suitable matches for your company: ");
        Thread.sleep(1000);
        System.out.println(suitableCreator);
        clientDesire.close();
    }
}

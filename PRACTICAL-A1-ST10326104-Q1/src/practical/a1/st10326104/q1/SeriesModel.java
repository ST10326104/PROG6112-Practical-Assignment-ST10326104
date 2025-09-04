package practical.a1.st10326104.q1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class SeriesModel extends NewMedia
{
    public String seriesAge;
    public String episodeCount; // the designated name seemed a bit long

    public SeriesModel(String mediaId, String mediaName, String mediaSize, String seriesAge, String episodeCount)
    {
        super(mediaId, mediaName, mediaSize);
        this.seriesAge = seriesAge;
        this.episodeCount = episodeCount;
    }

    @Override
    public void printDetails()
    {
        System.out.println("SERIES ID              : " + mediaId);
        System.out.println("SERIES NAME            : " + mediaName);
        System.out.println("SERIES AGE RESTRICTION : " + seriesAge);
        System.out.println("NUMBER OF EPISODES     : " + episodeCount);
    }
}

class SeriesApp
{
    private static Scanner read = new Scanner(System.in);
    private static List<SeriesModel> seriesList = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine();

        if(choice.equals("1"))
        {
            launchMenu();
        }
        else
        {
            System.out.println("Exiting Application...");
        }
    }

    public static void launchMenu()
    {
        while(true)
        {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");

            String option = read.nextLine();

            switch(option)
            {
                case "1":
                    captureSeries();
                    break;
                case "2":
                    searchSeries();
                    break;
                case "3":
                    updateSeries();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    printReport();
                    break;
                case "6":
                    System.out.println("Exiting Application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }

    public static void captureSeries()
    {
        System.out.println("CAPTURE NEW SERIES");
        System.out.println("*************************");

        System.out.print("Enter the series ID: ");
        String id = read.nextLine();

        System.out.print("Enter the series name: ");
        String name = read.nextLine();

        System.out.print("Enter the media size (MB): ");
        String size = read.nextLine();

        String age;
        while(true)
        {
            System.out.print("Enter the series age restriction (between 2 and 18): ");
            age = read.nextLine();
            try
            {
                int ageNum = Integer.parseInt(age);
                if(ageNum >= 2 && ageNum <= 18)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid! Age must be between 2 and 18. Please re-enter the series age.");
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number between 2 and 18.");
            }
        }

        System.out.print("Enter the number of episodes: ");
        String episodes = read.nextLine();

        SeriesModel newSeries = new SeriesModel(id, name, size, age, episodes);
        seriesList.add(newSeries);

        System.out.println("Series has been captured successfully!!!");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine();
        if(!choice.equals("1"))
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public static void searchSeries()
    {
        System.out.print("Enter the series ID to search: ");
        String id = read.nextLine();

        boolean found = false;
        for(SeriesModel s : seriesList)
        {
            if(s.mediaId.equals(id))
            {
                System.out.println("------------------------------");
                s.printDetails();
                found = true;
                break;
            }
        }

        if(!found)
        {
            System.out.println("------------------------------------------");
            System.out.println("Series with id: " + id + " was not found!");
            System.out.println("------------------------------------------");
        }

        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine();
        if(!choice.equals("1"))
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public static void updateSeries()
    {
        System.out.print("Enter the series ID to update age restriction: ");
        String id = read.nextLine();

        SeriesModel found = null;
        for(SeriesModel s : seriesList)
        {
            if(s.mediaId.equals(id))
            {
                found = s;
                break;
            }
        }

        if(found != null)
        {
            while(true)
            {
                System.out.print("Enter new age restriction (between 2 and 18): ");
                String newAge = read.nextLine();
                try
                {
                    int ageNum = Integer.parseInt(newAge);
                    if(ageNum >= 2 && ageNum <= 18)
                    {
                        found.seriesAge = newAge;
                        System.out.println("Age restriction updated successfully!");
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid input. Please re-enter the series age (between 2 and 18).");
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input. Please enter a number between 2 and 18.");
                }
            }
        }
        else
        {
            System.out.println("Series with id: " + id + " was not found!");
        }
    }

    public static void deleteSeries()
    {
        System.out.print("Enter the series ID you wish to delete: ");
        String id = read.nextLine();

        SeriesModel found = null;
        for(SeriesModel s : seriesList)
        {
            if(s.mediaId.equals(id))
            {
                found = s;
                break;
            }
        }

        if(found != null)
        {
            System.out.println("Are you sure you want to delete series " + found.mediaId + " from the system? Yes (y) to delete.");
            String confirm = read.nextLine();
            if(confirm.equalsIgnoreCase("y"))
            {
                seriesList.remove(found);
                System.out.println("--------------------------------------");
                System.out.println("Series with Series id: " + id + " was deleted!");
                System.out.println("--------------------------------------");
            }
        }
        else
        {
            System.out.println("Series with id: " + id + " was not found!");
        }

        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine();
        if(!choice.equals("1"))
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public static void printReport()
    {
        if(seriesList.isEmpty())
        {
            System.out.println("No series have been recorded yet.");
        }
        else
        {
            int count = 1;
            for(SeriesModel s : seriesList)
            {
                System.out.println("Series " + count);
                System.out.println("-----------------------------");
                s.printDetails();
                System.out.println("---------------------------------");
                count++;
            }
        }

        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine();
        if(!choice.equals("1"))
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
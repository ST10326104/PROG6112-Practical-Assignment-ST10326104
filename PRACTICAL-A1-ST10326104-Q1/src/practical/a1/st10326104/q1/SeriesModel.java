package practical.a1.st10326104.q1;

/*References:
Farrall, J., 2020, *Java Programming*, 9th ed.
OpenAI, 2025. ChatGPT [AI language model]. Available at: https://chat.openai.com/
 [Accessed 10 September 2025].
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class SeriesModel extends NewMedia
{
    public String seriesAge;      // Age restriction
    public String episodeCount;   // Number of episodes

    public SeriesModel(String mediaId, String mediaName, String mediaSize, String seriesAge, String episodeCount) // Constructor
    {
        super(mediaId, mediaName, mediaSize);
        this.seriesAge = seriesAge;
        this.episodeCount = episodeCount;
    }

    @Override
    public void printDetails() // Print series details
    {
        System.out.println("SERIES ID              : " + mediaId);
        System.out.println("SERIES NAME            : " + mediaName);
        System.out.println("SERIES AGE RESTRICTION : " + seriesAge);
        System.out.println("NUMBER OF EPISODES     : " + episodeCount);
    }
}

class SeriesApp
{
    private static Scanner read = new Scanner(System.in); // Scanner for input
    private static List<SeriesModel> seriesList = new ArrayList<>(); // Store series

    public static void main(String[] args)
    {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine(); // User input

        if(choice.equals("1"))
        {
            launchMenu(); // Open menu
        }
        else
        {
            System.out.println("Exiting Application...");
        }
    }

    public static void launchMenu() // Main menu loop
    {
        while(true)
        {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update a series");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");

            String option = read.nextLine(); // Menu choice

            switch(option)
            {
                case "1":
                    captureSeries(); // Capture series
                    break;
                case "2":
                    searchSeries(); // Search series
                    break;
                case "3":
                    updateSeries(); // Update series
                    break;
                case "4":
                    deleteSeries(); // Delete series
                    break;
                case "5":
                    printReport(); // Print all series
                    break;
                case "6":
                    System.out.println("Exiting Application...");
                    System.exit(0); // Exit program
                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }

    public static void captureSeries() // Capture new series
    {
        System.out.println("CAPTURE NEW SERIES");
        System.out.println("*************************");

        System.out.print("Enter the series ID: ");
        String id = read.nextLine(); // Input series ID

        System.out.print("Enter the series name: ");
        String name = read.nextLine(); // Input series name

        System.out.print("Enter the series lenght (minutes): ");
        String size = read.nextLine(); // Input length

        String age;
        while(true)
        {
            System.out.print("Enter the series age restriction (between 2 and 18): ");
            age = read.nextLine(); // Input age
            try
            {
                int ageNum = Integer.parseInt(age); // Validate number
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
        String episodes = read.nextLine(); // Input episodes

        SeriesModel newSeries = new SeriesModel(id, name, size, age, episodes); // Create series
        seriesList.add(newSeries); // Add to list

        System.out.println("Series has been captured successfully!!!");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine(); 
        if(!choice.equals("1"))
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public static void searchSeries() // Search series
    {
        System.out.print("Enter the series ID to search: ");
        String id = read.nextLine(); // Input ID

        boolean found = false;
        for(SeriesModel s : seriesList)
        {
            if(s.mediaId.equals(id))
            {
                System.out.println("------------------------------");
                s.printDetails(); // Print series
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

    public static void updateSeries() // Update series (help from ChatGPT, 2025)
    {
        System.out.print("Enter the series ID to update: ");
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
            System.out.print("Enter new series name: ");
            found.mediaName = read.nextLine();

            System.out.print("Enter new series length (minutes): ");
            found.mediaSize = read.nextLine();

            String age;
            while(true)
            {
                System.out.print("Enter new series age restriction (between 2 and 18): ");
                age = read.nextLine();
                try
                {
                    int ageNum = Integer.parseInt(age);
                    if(ageNum >= 2 && ageNum <= 18)
                    {
                        found.seriesAge = age;
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid! Age must be between 2 and 18. Please re-enter.");
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input. Please enter a number between 2 and 18.");
                }
            }

            System.out.print("Enter new number of episodes: ");
            found.episodeCount = read.nextLine();

            System.out.println("Series updated successfully!");
        }
        else
        {
            System.out.println("Series with id: " + id + " was not found!");
        }
    }

    public static void deleteSeries() // Delete series
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
                seriesList.remove(found); // Remove series
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

    public static void printReport() // Print all series
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
                s.printDetails(); // Print series details
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

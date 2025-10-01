package practical.a1.st10326104.q1;

//Reference: Farrall, J., 2020, *Java Programming*, 9th ed.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NewMedia
{
    public String mediaId;   // Unique media ID
    public String mediaName; // Media name
    public String mediaSize; // Media size in MB

    public NewMedia(String mediaId, String mediaName, String mediaSize) // Constructor
    {
        this.mediaId = mediaId;
        this.mediaName = mediaName;
        this.mediaSize = mediaSize;
    }

    public void printDetails() // Print media details
    {
        System.out.println("MEDIA ID   : " + mediaId);
        System.out.println("MEDIA NAME : " + mediaName);
        System.out.println("MEDIA SIZE : " + mediaSize + "MB");
    }
}

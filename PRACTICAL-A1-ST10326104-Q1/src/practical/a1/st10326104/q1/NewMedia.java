package practical.a1.st10326104.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NewMedia
{
    public String mediaId;
    public String mediaName;
    public String mediaSize;

    public NewMedia(String mediaId, String mediaName, String mediaSize)
    {
        this.mediaId = mediaId;
        this.mediaName = mediaName;
        this.mediaSize = mediaSize;
    }

    public void printDetails()
    {
        System.out.println("MEDIA ID   : " + mediaId);
        System.out.println("MEDIA NAME : " + mediaName);
        System.out.println("MEDIA SIZE : " + mediaSize + "MB");
    }
}
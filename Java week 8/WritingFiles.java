import java.io.*; //PrintWriter class
import java.util.*; // Random

public class WritingFiles
{
    public static void main(String[] args)
    {
        try (PrintWriter fileOut = new PrintWriter("results.txt"))
        {
            // Which folder/directory will Java try to write to
            System.out.println(System.getProperty("user.dir"));
            // generate 10 random integers from 0-99 and put into 
            // an array and write the num to the file
            int[] nums = new int[10];
            Random gen = new Random();
            for (int index=0; index < nums.length; index++)
            {
                nums[index] = gen.nextInt(100);
                fileOut.println(nums[index]);
                System.out.println(nums[index]);
            }
        } catch (FileNotFoundException error)
        {
            System.err.println(error);
        }
    }
}
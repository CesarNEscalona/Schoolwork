package war_and_peace;

public class ReaderTester {

    public static void main(String[] args) {
        // create a new reader obj with the file path as param
        Reader test = new Reader("files/war_and_peace.txt");

        // for each Scanner line in the test print out the line
        for (String line : test) {
            System.out.println(line);
        }
    }
}

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IO;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String filePath = "/home/elisha/IdeaProjects/MyFirstProjectt/src/KAMA SI MZIKI - FLEVA ALKEE (official video).wav";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(System.in);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response= "";
            while (!response.equals("Q")){
                System.out.println("P= Play");
                System.out.println("S= Stop");
                System.out.println("R= Reset");
                System.out.println("Q= quit");
                System.out.print("Enter your choice: ");
                response = scanner.next().toUpperCase();
            }
            switch (response){
                case "P" -> clip.start();
                case "S"-> clip.stop();
                case "R"->clip.setMicrosecondPosition(0);
                case "Q"->clip.close();
                default -> System.out.println("Invalid Choice");
            }

        } catch (FileNotFoundException e) {
            System.out.println(" could not locate the file");

        } catch (IOException | UnsupportedAudioFileException e) {
            System.out.println("something went wrong");
        } catch (LineUnavailableException e) {
            System.out.println("unable to access audio stream");
        } finally {
            System.out.println("Bye!");
        }


    }

    }




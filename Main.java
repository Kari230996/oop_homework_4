import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();


        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);


        Character[] characters = { new Peasant("John", x, y), new Bandit("Ronya", x, y), new Sniper("Joshua", x, y), new Crossbowman("Gilgamesh", x, y),
                new Spearman("Lancelot", x, y),
                new Magician("Deya", x, y), new Monk("Kiritsugi", x, y) };

     

        
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(4);
            list1.add(characters[index]);
        }

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(4) + 3;
            list2.add(characters[index]);
        }

        // объединяем два списка в один
        List<Character> allCharacters = new ArrayList<>();
        allCharacters.addAll(list1);
        allCharacters.addAll(list2);

        // сортируем список персонажей по скорости
        allCharacters.sort((c1, c2) -> c2.getSpeed() - c1.getSpeed());

        // выводим информацию обо всех персонажах

        /*
         * for (Character character : allCharacters) {
            System.out.println(character.getDescription());

        }
         * 
         */

         System.out.println(allCharacters);
        

    }
}
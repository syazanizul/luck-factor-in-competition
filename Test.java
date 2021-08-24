import java.util.ArrayList;

public class Test {

    public static void main (String [] aghs)  {

        // Variables
        final int total_people = 300;  
        final int total_chosen = 3;
        final int max_nonluck = 9800;
        final int max_luck = 200;

        // Benda
        ArrayList<People> array_people = new ArrayList<People>();
        ArrayList<People> chosen_people = new ArrayList<People>();

        // Create the people
        for(int i = 0; i< total_people; i++)   {
            array_people.add(new People(max_nonluck, max_luck));
        }
        
        // Choose the best
        int step_count = 0;

        for(int j = 0; j< total_chosen; j++)   {
            int highest = 0;
            int index_save = 0;

            for(int i=0; i< total_people - step_count; i++)   {

                int current = array_people.get(i).getTotal();

                if (current>highest)   {
                    highest = current;
                    index_save = i;
                }
            }

            People person_highest = array_people.get(index_save);
            chosen_people.add(person_highest);

            array_people.remove(index_save);
            step_count++;
        }

        // Show highest
        int total_nonluck = 0;
        int total_luck = 0;
        for (People person_top : chosen_people) {
            total_nonluck += person_top.getNonluck();
            total_luck += person_top.getLuck();
            System.out.println("Total score : " + person_top.getTotal() + ", Nonluck (XP, hardwork, skill) : " + person_top.getNonluck() + ", Luck : " + person_top.getLuck());
        }
        System.out.println("Average NonLuck : " + total_nonluck/total_chosen + " / " + max_nonluck);
        System.out.println("Average Luck : " + total_luck/total_chosen + " / " + max_luck);
    }
}

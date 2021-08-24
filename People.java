public class People {
    private int nonluck, luck;

    public People(int max_nonluck, int max_luck) {
        nonluck = People.random(0, max_nonluck);
        luck = People.random(0, max_luck);
    }

    public int getNonluck() {
        return nonluck;
    }

    public int getLuck()    {
        return luck;
    }

    public int getTotal()   {
        return nonluck + luck;
    }

    public static int random(int min, int max) {
        double result = Math.random() * (max - min + 1) + min;

        return (int)result;
    }
}

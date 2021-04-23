public class Lab9B {
    public int crudelog(int i) {
        if (i / 2 <= 0) {
            return 0;
        }
        return crudelog(i/2) + 1;
    }
}

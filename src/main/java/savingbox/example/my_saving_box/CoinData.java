package savingbox.example.my_saving_box;

public class CoinData {
    private double total; // Общая сумма в копилке
    private int[] coinCounts; // Количество монет каждого номинала
    private double[] coinValues; // Номиналы монет

    // Конструктор
    public CoinData(double total, int[] coinCounts, double[] coinValues) {
        this.total = total;
        this.coinCounts = coinCounts;
        this.coinValues = coinValues;
    }

    // Геттер для общей суммы
    public double getTotal() {
        return total;
    }

    // Геттер для количества монет
    public int[] getCoinCounts() {
        return coinCounts;
    }

    // Геттер для номиналов монет
    public double[] getCoinValues() {
        return coinValues;
    }
}
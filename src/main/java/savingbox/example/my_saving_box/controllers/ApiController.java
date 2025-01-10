package savingbox.example.my_saving_box.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import savingbox.example.my_saving_box.CoinData;

@RestController
public class ApiController {

    private double total = 0.0; // Общая сумма
    private double[] coinValues = {2.0, 1.0, 0.5, 0.2, 0.1, 0.05}; // Номиналы монет
    private int[] coinCounts = new int[coinValues.length]; // Количество каждой монеты


    private Map<String, Object> data = new HashMap<>();

    public ApiController() {
        //initialisation Mock-data
        data.put("total", 12.34);
        Map<String, Integer> coins = new HashMap<>();
        coins.put("2.0", 3);
        coins.put("1.0", 5);
        coins.put("0.5", 2);
        coins.put("0.2", 7);
    }

    @GetMapping("/api/coins")
    public Map<String, Object> getCoins() {
        return data;
    }

    @PostMapping("/api/coins/reset")
    public Map<String, Object> resetCoins() {
        data.put("total", 0.0);
        Map<String, Integer> coins = new HashMap<>();
        coins.put("2.0", 0);
        coins.put("1.0", 0);
        coins.put("0.5", 0);
        coins.put("0.2", 0);
        data.put("coins", coins);
        return data;
    }

    @PostMapping("/api/coins/randomCoin")
    public CoinData randomCoin(){
        // Массив с номиналами монет
        double[] coinValues = {2.0, 1.0, 0.5, 0.2, 0.1, 0.05};

        // Генерация случайного индекса
        int randomIndex = (int) (Math.random() * coinValues.length);
        double randomCoin = coinValues[randomIndex];

        total += randomCoin;

        coinCounts[randomIndex]++;

        return new CoinData(total, coinCounts, coinValues);
    }
}

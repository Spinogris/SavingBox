const API_BASE_URL = "http://localhost:8081";
const totalElement = document.getElementById("total");
const coinList = document.getElementById("coin-list");
const resetElement = document.getElementById("reset");

// Функция для обновления интерфейса
function updateData(data) {
  totalElement.textContent = data.total.toFixed(2);
  coinList.innerHTML = ""; // Очищаем таблицу

  for (const [nominal, count] of Object.entries(data.coins)) {
    const row = `<tr><td>${nominal} €</td><td>${count}</td></tr>`;
    coinList.innerHTML += row;
  }
}

// Загрузка данных из API
async function loadData() {
  try {
    const response = await fetch(`${API_BASE_URL}/api/coins`); // Запрос к API
    const data = await response.json();
    updateData(data);
  } catch (error) {
    console.error("Ошибка загрузки данных:", error);
  }
}

// Сброс данных через API
resetElement.addEventListener("click", async () => {
  try {
    const response = await fetch(`${API_BASE_URL}/api/coins/reset`, {
      method: "POST",
    });
    if (response.ok) {
      alert("Данные сброшены!");
      loadData(); // Перезагрузка данных
    } else {
      throw new Error("Ошибка сервера");
    }
  } catch (error) {
    alert("Произошла ошибка при сбросе данных");
    console.error("Ошибка сброса данных:", error);
  }
});

// Рандомная монета
document.getElementById("randomCoin").addEventListener("click", async () => {
  try {
    const response = await fetch(`${API_BASE_URL}/api/coins/randomCoin`, {
      method: "POST",
    });
    if (response.ok) {
      const data = await response.json();
      updateData(data); // Обновляем отображение данных
    } else {
      console.error("Ошибка добавления случайной монеты");
    }
  } catch (error) {
    console.error("Ошибка:", error);
  }
});

// Первоначальная загрузка данных
loadData();

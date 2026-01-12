# 🪙 CryptoTracker

**CryptoTracker** is a modern cryptocurrency monitoring application that provides real-time data, detailed charts, and an adaptive interface for different screen sizes. Developed with the latest technologies in the Android ecosystem, the project focuses on scalability, testability, and performance.

---

## 📸 Screenshots

Here you can view the application interface in different contexts:

### 📱 Mobile Version

<img src="https://github.com/user-attachments/assets/944a28d2-2c27-462a-904c-adbb7aa7593c" width="220" alt="CryptoTracker Mobile">
<img src="https://github.com/user-attachments/assets/e5f9dc8d-21bd-442e-9d8b-32fb653c383c" width="220" alt="CryptoTracker Mobile">

### 🖥️ Tablet Version 
(Adaptive Layout)

<img width="1057" height="663" alt="Screenshot 2026-01-10 at 21 05 31" src="https://github.com/user-attachments/assets/a1a4e037-0413-4535-a252-f00a7042286d" />


### 📊 CryptoChart (Custom Canvas)
*Price variation chart developed from scratch using the Jetpack Compose Canvas API.*

  <img src="https://github.com/user-attachments/assets/a6b91d8d-4007-4d50-a555-fc5b531b498b" width="600" alt="CryptoChart Canvas">

---

## 🛠️ Technologies Used

- **[Kotlin](https://kotlinlang.org/):** Main language of the project.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Modern toolkit for building native UI.
- **[Koin](https://insert-koin.io/):** Lightweight and pragmatic Dependency Injection framework.
- **[Ktor](https://ktor.io/):** HTTP client for consuming asynchronous APIs.
- **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization):** Efficient JSON conversion to Kotlin objects.
- **[Compose Material3 Adaptive](https://developer.android.com/jetpack/androidx/releases/compose-material3-adaptive):** Support for layouts that adapt to different screen sizes (Foldables, Tablets).
- **[Detekt](https://detekt.dev/):** Static code analysis tool to ensure quality and standards.

---

## 🏗️ Architecture and Organization

The project follows the principles of **Clean Architecture** divided into layers, facilitating maintenance and test implementation.

### Package Structure

```
com.johnkenedy.cryptotracker
├── core                  # Shared resources between modules
│   ├── data              # Generic networking, error handling, and mappers
│   ├── domain            # Common domain models and error interfaces
│   ├── navigation        # Centralized navigation logic
│   └── presentation      # Generic UI components and utilities
│
├── crypto                # Main Cryptocurrency functionality
│   ├── data              # DTOs, Mappers, and Repository implementation (Ktor)
│   ├── domain            # Domain models and Repository interfaces
│   └── presentation      # ViewModels, States, Screens, and Components (Canvas Chart)
│
├── di                    # Dependency Injection module definitions (Koin)
└── ui.theme              # Color definitions, typography (Material 3), and themes
```

### Architectural Details
- **MVI (Model-View-Intent):** Used in the presentation layer to separate business logic from the UI.
- **UDF (Unidirectional Data Flow):** Screen states are managed via `StateFlow` and events via `Channel`, ensuring predictability.
- **Mapper Pattern:** Conversion of DTOs (Data Transfer Objects) to domain models to avoid leaking network dependencies to the UI.

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/johnkenedy/CryptoTracker.git
   ```
2. Add your API key (optional) in the `local.properties` file:
   ```properties
   API_KEY=your_key_here
   ```
3. Sync Gradle and run the app.

---

## 📈 Features
- Cryptocurrency listing with price updates.
- Detailed information for each coin.
- **CryptoChart:** Interactive price chart drawn with Canvas.
- Support for Dark Mode and Light Mode.
- Responsive layout for mobile and tablet devices.

---

## 🔮 Future Features
- **Favorites:** Mark your favorite coins for quick access.
- **Wallet:** Track your crypto holdings and portfolio value.
- **Comparison:** Compare multiple cryptocurrencies side-by-side.

---

Developed by [John Kenedy](https://github.com/johnkenedy) 👋

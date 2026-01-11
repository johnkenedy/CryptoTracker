# 🪙 CryptoTracker

**CryptoTracker** is a modern cryptocurrency monitoring application that provides real-time data, detailed charts, and an adaptive interface for different screen sizes. Developed with the latest technologies in the Android ecosystem, the project focuses on scalability, testability, and performance.

---

## 📸 Screenshots

Here you can view the application interface in different contexts:

### 📱 Mobile Version
<p align="center">
  <img src="path/to/your/mobile_image.png" width="300" alt="CryptoTracker Mobile">
</p>

### 🖥️ Tablet Version 
(Adaptive Layout)
<p align="center">
  <img src="path/to/your/tablet_image.png" width="600" alt="CryptoTracker Tablet">
</p>

### 📊 CryptoChart (Custom Canvas)
*Price variation chart developed from scratch using the Jetpack Compose Canvas API.*
<p align="center">
  <img src="path/to/your/canvas_image.png" width="600" alt="CryptoChart Canvas">
</p>

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
- **MVVM (Model-View-ViewModel):** Used in the presentation layer to separate business logic from the UI.
- **UDF (Unidirectional Data Flow):** Screen states are managed via `StateFlow` and events via `Channel`, ensuring predictability.
- **Mapper Pattern:** Conversion of DTOs (Data Transfer Objects) to domain models to avoid leaking network dependencies to the UI.

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/CryptoTracker.git
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

Developed by [John Kenedy](https://github.com/johnkenedy) 👋
